package syncoder.myfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import syncoder.myfin.blockchain.Block;
import syncoder.myfin.blockchain.Blockchain;

import java.util.ArrayList;

@SpringBootApplication
public class MyFinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFinApplication.class, args);

        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("First transaction: Omina -> Bank");
        blockchain.addBlock("Second transaction: Bank -> Client");

        blockchain.printBlockchain();

        System.out.println("Blockchain valid: " + blockchain.isChainValid());


    }



}
