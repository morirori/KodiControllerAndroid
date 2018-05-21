package com.example.micha.kodiremote.Utills;

import java.io.Serializable;

/**
 * Created by Michał on 04.11.2017.
 */

public class KodiParameters implements Serializable{

    String ip;
    String port;

    public KodiParameters(String ip){

        this.ip=ip;
        this.port="8080";
    }

    public KodiParameters(String ip, String port){

        this.ip=ip;
        this.port=port;
    }
    public KodiParameters(){
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
