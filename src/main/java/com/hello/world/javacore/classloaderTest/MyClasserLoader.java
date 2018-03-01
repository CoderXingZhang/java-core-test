package com.hello.world.javacore.classloaderTest;

import java.io.*;

/**
 * @author xing
 */
public class MyClasserLoader extends ClassLoader{

    private String classDir;


    public MyClasserLoader(String classDir) {
        this.classDir = classDir;
    }

    public MyClasserLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPathFile = classDir + "/" + name + ".class";
        try {
            FileInputStream fis = new FileInputStream(classPathFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            encodeAnDecode(fis,bos);
            byte[] classByte = bos.toByteArray();
            return defineClass(classByte,0,classByte.length);

        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception{
        String srcpath = "E:\\project\\javacore\\src\\main\\java\\com\\hello\\world\\javacore\\classloaderTest\\ClassLoaderAttachment.class";
        String despath = "class_temp";
        String desFileName = srcpath.substring(srcpath.lastIndexOf("\\") + 1);
        String desPathFile = despath + "/" + desFileName;
        FileInputStream fis = new FileInputStream(srcpath);
        FileOutputStream fos = new FileOutputStream(desPathFile);
        encodeAnDecode(fis,fos);
        fis.close();
        fos.close();

    }
    private static void encodeAnDecode(InputStream is, OutputStream os) throws Exception{
        int bytes = -1;
        while ((bytes = is.read()) != -1){
            bytes = bytes ^ 0xff;
            os.write(bytes);
        }
    }

}
