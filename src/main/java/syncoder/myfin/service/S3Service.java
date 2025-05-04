package syncoder.myfin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Value("${aws.region}")
    private String region;

    public String uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(fileName)
                            .build(),
                    RequestBody.fromBytes(file.getBytes())
            );
            return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }


    public void deleteFilesByUrls(List<String> imageUrls) {
        List<String> keys = imageUrls.stream()
                .map(this::extractKeyFromUrl)
                .collect(Collectors.toList());
        deleteFiles(keys);
    }

    public String extractKeyFromUrl(String imageUrl) {
        try {
            URI uri = new URI(imageUrl);
            return uri.getPath().substring(1);
        } catch (URISyntaxException e) {
            throw new RuntimeException();
        }
    }

    public void deleteFiles(List<String> fileNames) {
        for (String fileName : fileNames) {
            deleteFile(fileName);
        }
    }

    public void deleteFile(String fileName) {
        try {
            s3Client.deleteObject(
                    DeleteObjectRequest.builder()
                            .bucket(bucketName)
                            .key(fileName)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
