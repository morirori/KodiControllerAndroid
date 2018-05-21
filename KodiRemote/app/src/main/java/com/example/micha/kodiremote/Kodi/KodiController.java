package com.example.micha.kodiremote.Kodi;

import com.example.micha.kodiremote.Kodi.KodiFunctions.IKodi;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiBackFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiMoveDownFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiMoveLeftFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiMoveRightFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiMoveUpFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiPlayAndPause;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiSelectFunction;
import com.example.micha.kodiremote.Kodi.KodiFunctions.KodiSetVolumeFunction;
import com.example.micha.kodiremote.Utills.KodiParameters;

/**
 * Created by Michał on 05.11.2017.
 */

public class KodiController {

    IKodi kodifun;
    KodiParameters kodiParameters;

    public KodiController(KodiParameters kp){
        this.kodiParameters = kp;
    }


    public void playPause(){
        kodifun = new KodiPlayAndPause(this.kodiParameters);
        kodifun.function();
    }

    public void select(){
        kodifun = new KodiSelectFunction(this.kodiParameters);
        kodifun.function();
    }

    public void moveUp(){
        kodifun = new KodiMoveUpFunction(this.kodiParameters);
        kodifun.function();
    }
    public void moveDown(){
        kodifun = new KodiMoveDownFunction(this.kodiParameters);
        kodifun.function();
    }
    public void moveLeft(){
        kodifun = new KodiMoveLeftFunction(this.kodiParameters);
        kodifun.function();
    }
    public void moveRight(){
        kodifun = new KodiMoveRightFunction(this.kodiParameters);
        kodifun.function();
    }

    public void back(){
        kodifun = new KodiBackFunction(this.kodiParameters);
        kodifun.function();
    }

    public void setVolume(String volume){
        kodifun = new KodiSetVolumeFunction(this.kodiParameters,volume);
        kodifun.function();
    }

}
