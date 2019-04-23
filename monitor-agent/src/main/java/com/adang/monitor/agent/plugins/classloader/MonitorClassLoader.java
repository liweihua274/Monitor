package com.adang.monitor.agent.plugins.classloader;


import java.io.File;
import java.util.jar.JarFile;

/**
 * 2019.3.11
 * 类加载器
 */
public class MonitorClassLoader extends ClassLoader{

    public String classPath = "D:\\Knowledge\\source\\Monitor\\monitor-agent\\target\\classes";

    private static MonitorClassLoader monitorClassLoader;

   public static MonitorClassLoader getMonitorClassLoader(){
        if (monitorClassLoader == null){
            synchronized (MonitorClassLoader.class){
                if(monitorClassLoader == null){
                    monitorClassLoader = new MonitorClassLoader();
                }
            }
        }
        return monitorClassLoader;
    }
/*
    private MonitorClassLoader(String classPath,ClassLoader parent){
        if (parent == null){
            parent = Thread.currentThread().getContextClassLoader();
        }


    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getClassFile(name);
        System.out.println("文件名" + fileName);
        byte[] classByte=null;
        try {
            classByte = getClassBytes(fileName);
        }catch( IOException e ){
            e.printStackTrace();
        }
        //利用自身的加载器加载类
        Class retClass = defineClass( null,classByte , 0 , classByte.length);
        if( retClass != null ) {
            System.out.println("由我加载");
            return retClass;
        }
        //在classPath中找不到类文件，委托给父加载器加载,父类会返回null，因为可加载的话在
        //委派的过程中就已经被加载了
        return super.findClass(name);
    }


    private  byte [] getClassBytes ( String name ) throws IOException {
        FileInputStream fileInput = new FileInputStream(name);
        FileChannel channel = fileInput.getChannel();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        WritableByteChannel byteChannel = Channels.newChannel(output);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int flag;
            while ((flag = channel.read(buffer)) != -1) {
                if (flag == 0) break;
                //将buffer写入byteChannel
                buffer.flip();
                byteChannel.write(buffer);
                buffer.clear();
            }
        }catch ( IOException e ){
            System.out.println("can't read!");
            throw e;
        }
        fileInput.close();
        channel.close();
        byteChannel.close();
        return output.toByteArray();
    }


    private String getClassFile (String name){
        //利用StringBuilder将包形式的类名转化为Unix形式的路径
        StringBuilder sb = new StringBuilder(classPath);
        sb.append("/")
                .append ( name.replace('.','/'))
                .append(".class");
        return sb.toString();
    }
*/




    private class Jar {
        private JarFile jarFile;
        private File sourceFile;

        private Jar(JarFile jarFile, File sourceFile) {
            this.jarFile = jarFile;
            this.sourceFile = sourceFile;
        }
    }




}
