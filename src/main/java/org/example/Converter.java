package org.example;

import java.io.*;
import java.nio.ByteBuffer;

public class Converter {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("p3_input_sample.dat"));
        byte[] buffer = new byte[4];
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
        while(fis.read( buffer ) > 0 ){
            byte[] bytesKey = new byte[] {buffer[0], buffer[1]};
            ByteBuffer byteBufferKey = ByteBuffer.wrap(bytesKey);
            String key = String.valueOf(byteBufferKey.getShort());

            byte[] bytesValue = new byte[] {buffer[2], buffer[3]};
            ByteBuffer byteBufferValue = ByteBuffer.wrap(bytesValue);
            String value = String.valueOf(byteBufferValue.getShort());

            writer.write(key + " " + value + " \n");
        }

        writer.close();
        fis.close();
    }
}
