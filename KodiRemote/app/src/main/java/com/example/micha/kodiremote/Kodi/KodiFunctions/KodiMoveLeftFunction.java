package com.example.micha.kodiremote.Kodi.KodiFunctions;

import com.example.micha.kodiremote.Utills.KodiParameters;
import com.example.micha.kodiremote.Utills.HttpRequestClient;
import com.google.gson.Gson;

/**
 * Created by Michał on 06.11.2017.
 */

public class KodiMoveLeftFunction implements IKodi {
        private String id;
        private String method;
        private String jsonrpc;
        private transient KodiParameters kp;

    public KodiMoveLeftFunction(KodiParameters kp) {
        this.kp=kp;
        this.setId("1");
        this.setJsonrpc("2.0");
        this.setMethod("Input.Left");
        Params param = new Params();
        param.setPlayerid(0);
    }

      public KodiMoveLeftFunction(String id, String jsonrpc, String method) {
        this.setId(id);
        this.setJsonrpc(jsonrpc);
        this.setMethod(method);
      }
        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getMethod ()
        {
            return method;
        }

        public void setMethod (String method)
        {
            this.method = method;
        }

        public String getJsonrpc ()
        {
            return jsonrpc;
        }

        public void setJsonrpc (String jsonrpc)
        {
            this.jsonrpc = jsonrpc;
        }


    @Override
    public void function() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        HttpRequestClient httpRequestClient = new HttpRequestClient(this.kp.getIp(),this.kp.getPort());
        httpRequestClient.execute(json);
    }
}
