package com.example.micha.kodiremote.Utills;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michał on 04.11.2017.
 */

public class IPv4Matcher {
    String IPv4;
    String ipPattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IPv4Matcher(String IPv4){
        this.IPv4=IPv4;
    }

    public boolean isMaching(){
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(IPv4);
        return  matcher.matches();
    }
}
