package syncoder.myfin.blockchain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;

    public Block(String firstBlock, String number) {
        this.hash = firstBlock;
        this.previousHash = number;
        this.timeStamp = System.currentTimeMillis();
        this.data = firstBlock;

    }


    public String calculateHash() {
        return crypt.sha256(previousHash + timeStamp + data);
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }


}
