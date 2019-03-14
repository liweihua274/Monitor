package com.adang.monitor.agent.store.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MonitorFile {


    private FileChannel fileChannel;

    private File file;

    public MonitorFile(File file){
        this.file = file;
    }

    public void open(){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(file,"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileChannel = aFile.getChannel();
    }

    public void close(){
        try {
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void read(){
        ByteBuffer buf = ByteBuffer.allocate(48);
        try {
            int bytesRead = fileChannel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(String content){
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(content.getBytes());
        buf.flip();
        while(buf.hasRemaining()){
            try {
                fileChannel.write(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
