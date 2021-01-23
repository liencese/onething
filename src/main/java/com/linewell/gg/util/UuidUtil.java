package com.linewell.gg.util;

import java.util.UUID;

public class UuidUtil {
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    public static void main(String[] args) {
        for(int i =0;i<32;i++){
            System.out.println(getUuid());
        }
    }
}
