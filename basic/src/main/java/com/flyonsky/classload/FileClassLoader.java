package com.flyonsky.classload;

import java.io.*;

/**
 * @author luowengang
 * @date 2022/1/28
 */
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir ;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        else {
            return defineClass(name , classData , 0, classData.length );
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        InputStream ins = null;
        try {
            ins = new FileInputStream(path );
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize ];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer )) != -1) {
                baos.write( buffer, 0, bytesNumRead);
            }
            return baos .toByteArray();
        } catch (IOException e ) {
            e.printStackTrace();
        } finally{
            if(ins != null){
                try {
                    ins.close();
                } catch (IOException e ) {
                    e.printStackTrace();
                }
            }
        }
        return null ;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.' , File.separatorChar ) + ".class" ;
    }
}
