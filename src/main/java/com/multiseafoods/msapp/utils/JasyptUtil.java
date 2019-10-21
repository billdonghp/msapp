package com.multiseafoods.msapp.utils;

import org.jasypt.util.text.BasicTextEncryptor;
public class JasyptUtil {

    private static String PASSWORD = "ABCDEF0987654321";
    public static String decode(String str){
        BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword(PASSWORD);
        return bte.decrypt(str);
    }

    public static String encode(String str){
        BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword(PASSWORD);
        return bte.encrypt(str);
    }
}
