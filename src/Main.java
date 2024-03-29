import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {

        File plik = new File("/home/keru/Pulpit/javatpoint_com.pdf");

        //InputStream inputStream = Main.class.getResourceAsStream("image.jpg");

        try {
            byte[] fileContent = Files.readAllBytes(plik.toPath());

            //for(byte myValue: fileContent){ System.out.println("plik: "+myValue); }

            try (FileOutputStream stream = new FileOutputStream("/home/keru/Pulpit/output.pdf")) {
                stream.write(fileContent);
            }

        } catch (IOException e) {
            System.out.println("wyjatek: "+e.getMessage());
        }
//
        //FileUtils.writeByteArrayToFile(new File("pathname"), myByteArray);

        String key = "Mary has one cat";
        File inputFile = new File("/home/keru/Pulpit/crypt_test/doc.txt");
        File encryptedFile = new File("/home/keru/Pulpit/crypt_test/document.encrypted");
        File decryptedFile = new File("/home/keru/Pulpit/crypt_test/document.decrypted");

        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
}
