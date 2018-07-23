package com.huaqin;

import java.io.File;

public class FileIteartor {
    public static void main(String[] args) {
        File f = new File("abcde");
        myDir(f);
    }

    private static void myDir(File f) {
        File[] files = f.listFiles();
        for (File fZi : files) {
            if (fZi.isFile()){
                System.out.println(fZi.getName());
            }else {
                myDir(fZi);
            }
        }
    }

}
