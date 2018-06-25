package com.test.articles.utils;

import java.util.UUID;

public class UuidGenerator {

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
