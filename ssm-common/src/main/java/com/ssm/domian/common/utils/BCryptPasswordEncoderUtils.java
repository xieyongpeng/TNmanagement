package com.ssm.domian.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
	private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="admin";
        //$2a$10$Zw8EPXu3uQNoM.vgC0Z1yObGqrsGBZ.dBbkAf.DMFjtIXqwba.Aeu
        String pwd = encodePassword(password);
        System.out.print(pwd);
    }
}
