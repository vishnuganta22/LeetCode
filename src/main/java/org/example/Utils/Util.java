package org.example.Utils;

import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.openpgp.PGPException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class Util {
    public static void main(String[] args){
        File originalFile = new File("C:\\Users\\vishn\\Downloads\\member_optouts__2023-08-24_215158.csv");
        File publicKey = new File("C:\\Users\\vishn\\Downloads\\vishnu_public.pgp");
        File privateKey = new File("C:\\Users\\vishn\\Downloads\\vishnu_private.pgp");
        String passPhrase = "GantaVishnu";
        System.out.println(originalFile.exists());
        File tempEncriptedFile = new File("C:\\Users\\vishn\\Downloads\\encrypted.csv");
        File tempDecryptedFile = new File("C:\\Users\\vishn\\Downloads\\decrypted.csv");
        encrypt(originalFile, publicKey, tempEncriptedFile);
        decrypt(tempEncriptedFile, tempDecryptedFile, privateKey, passPhrase);
    }

    private static void encrypt(File originalFile, File publicKey, File tempEncriptedFile){
        try (OutputStream fos = Files.newOutputStream(tempEncriptedFile.toPath())){
            PgpEncryptionUtil pgpEncryptionUtil = PgpEncryptionUtil.builder()
                    .armor(true)
                    .compressionAlgorithm(CompressionAlgorithmTags.ZIP)
                    .symmetricKeyAlgorithm(SymmetricKeyAlgorithmTags.AES_128)
                    .withIntegrityCheck(true)
                    .build();;
            pgpEncryptionUtil.encrypt(fos, Files.newInputStream(originalFile.toPath()),
                    originalFile.length(),
                    Files.newInputStream(publicKey.toPath()));
        } catch (IOException | PGPException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void decrypt(File tempEncriptedFile, File decryptedFile, File privateKey, String passkey){
        try {
            PgpDecryptionUtil pgpDecryptionUtil = new PgpDecryptionUtil(Files.newInputStream(privateKey.toPath()), passkey);
            pgpDecryptionUtil.decrypt(Files.newInputStream(tempEncriptedFile.toPath()), Files.newOutputStream(decryptedFile.toPath()));
        } catch (IOException | PGPException e) {
            System.out.println(e.getMessage());
        }
    }
}
