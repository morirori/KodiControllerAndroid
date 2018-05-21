package com.example.micha.kodiremote.Kodi.KodiFunctions;

import com.example.micha.kodiremote.Utills.HttpRequestClient;
import com.example.micha.kodiremote.Utills.KodiParameters;
import com.google.gson.Gson;

/**
 * Created by Michał on 06.11.2017.
 */

public class KodiSetVolumeFunction implements IKodi{
    private String id;
    private String method;
    private VolParamm params;
    private String jsonrpc;
    private transient KodiParameters kp;

    public KodiSetVolumeFunction(KodiParameters kp, String volume) {
        this.kp=kp;
        this.setId("1");
        this.setJsonrpc("2.0");
        this.setMethod("Application.SetVolume");
        VolParamm param = new VolParamm();
        param.setVolume(Integer.parseInt(volume));
        this.setParams(param);
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getMethod () {
        return method;
    }

    public void setMethod (String method) {
        this.method = method;
    }

    public VolParamm getParams () {
        return params;
    }

    public void setParams (VolParamm params) {
        this.params = params;
    }

    public String getJsonrpc () {
        return jsonrpc;
    }

    public void setJsonrpc (String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    @Override
    public void function() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        System.out.print(json);
        HttpRequestClient httpRequestClient = new HttpRequestClient(this.kp.getIp(),this.kp.getPort());
        httpRequestClient.execute(json);
    }
}

class VolParamm
{
    private int volume;

    public int getVolume ()
    {
        return volume;
    }

    public void setVolume (int volume)
    {
        this.volume = volume;
    }

}
