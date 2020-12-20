package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmail {
    public static String RandomEmail(){
        return RandomStringUtils.random(5,true,true) + "@gmail.com";
    }
}
