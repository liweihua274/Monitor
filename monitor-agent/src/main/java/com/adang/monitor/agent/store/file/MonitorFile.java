package com.adang.monitor.agent.store.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class MonitorFile {

    public final static int CONST_BUFF_LENTH = 48;


    private final FileChannel fileChannel;

    private final File file;

    private final IndexFile indexFile;



    private final MappedByteBuffer mappedByteBuffer;

    public MonitorFile(File file) throws IOException {
        this.file = file;
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileChannel = aFile.getChannel();
        this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, CONST_BUFF_LENTH);
        indexFile = new IndexFile();
    }

    public void open() {

    }

    public void close() {
        try {
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read1() {
        ByteBuffer buf = ByteBuffer.allocate(CONST_BUFF_LENTH);
        try {
            int bytesRead = fileChannel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CharBuffer charBuffer = null;
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        try {
            charBuffer = decoder.decode(buf);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        buf.flip();
        System.out.println("jieguo:" + charBuffer.toString());
    }

    public String read() throws IOException {
        byte[] ds = new byte[(int) CONST_BUFF_LENTH];

        MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                .getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, CONST_BUFF_LENTH);
        for (int offset = 0; offset < CONST_BUFF_LENTH; offset++) {
            byte b = mappedByteBuffer.get();
            ds[offset] = b;
        }
        System.out.print("内容：" + new String(ds));
        return new String(ds);

    }


    public void write(String content) throws IOException {

        RandomAccessFile dest = new RandomAccessFile(file, "rw");
        FileChannel out = dest.getChannel();
        MappedByteBuffer mappedByteBuffer = out.map(FileChannel.MapMode.READ_WRITE, 0, 100);

        ByteBuffer byteBuffer = mappedByteBuffer.slice();
        byteBuffer.position(4);
        byteBuffer.put("adsdfsdfsd".getBytes());

        out.close();

    }


}
