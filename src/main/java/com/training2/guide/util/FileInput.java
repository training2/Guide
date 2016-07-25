package com.training2.guide.util;
/**
 * This class return even one instance
 * @author Kirill Bugrim on 20.07.2016.
 * version 1.1
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInput {
    private static   FileInputStream instance;

    private FileInput() {
    }

    public static FileInputStream getInstance(String str) throws FileNotFoundException {
        if(instance==null) instance=new FileInputStream(str);
        return instance;
    }
}
