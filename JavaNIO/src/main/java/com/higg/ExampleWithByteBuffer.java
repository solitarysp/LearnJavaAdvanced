package com.higg;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExampleWithByteBuffer {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\PhanMem\\oracle-vm-virtualbox.exe");
        FileChannel fileChannel = null;
        FileInputStream fileInputStream = null;
        ByteBuffer byteBuffer = null;
        try {
            fileInputStream = new FileInputStream(file);// chuyền file vào
            fileChannel = fileInputStream.getChannel();// get về một channel
            byteBuffer = ByteBuffer.allocate((int) fileChannel.size());// tạo buffter với tổng dung lượng của file
            int result = fileChannel.read(byteBuffer);// đọc dữ liệu vào bộ nhớ đệm
            while (result != -1) {

                byteBuffer.flip();  //làm buffter sẵn sàn để đọc

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get()); //đọc 1 type dữ liệu 1 lần đọc.
                }

                byteBuffer.clear(); //xoá sạch dữ liệu trong buffter đẽ sẵn sàn cho lần mới.
                result = fileChannel.read(byteBuffer);// set lại số type chưa đoc
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileChannel.close();
            fileInputStream.close();
        }
    }
}
