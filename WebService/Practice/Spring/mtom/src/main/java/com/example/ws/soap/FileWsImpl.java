package com.example.ws.soap;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;


public class FileWsImpl implements FileWs{

    InputStream inputStream = null;
    OutputStream outputStream = null;
    String path = "/Users/teisiaroh/Downloads/upload/HYUNJU.jpg";

    @Override
    public void upload(DataHandler attachment) {
        try {
            inputStream = attachment.getInputStream();
            outputStream = new FileOutputStream(new File(path));
            byte[] b = new byte[100000];
            int byteRead = 0;
            while((byteRead = inputStream.read(b)) != -1){
                outputStream.write(b, 0, byteRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public DataHandler download() {
        return new DataHandler(new FileDataSource(new File("/Users/teisiaroh/Downloads/upload/HYUNJU.jpg")));
    }
}
