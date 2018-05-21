package com.example.micha.kodiremote.Kodi.KodiFunctions;

import com.example.micha.kodiremote.Utills.KodiParameters;
import com.example.micha.kodiremote.Utills.HttpRequestClient;
import com.google.gson.Gson;

public class KodiPlayAndPause implements IKodi
{
        private String id;

        private String method;

        private Params params;

        private String jsonrpc;
        private transient KodiParameters kp;

        public KodiPlayAndPause(KodiParameters kp) {
           this.kp=kp;
           this.setId("1");
           this.setJsonrpc("2.0");
           this.setMethod("Player.PlayPause");
           Params param = new Params();
           param.setPlayerid(0);
           this.setParams(param);
        }
         public KodiPlayAndPause(String id, String jsonrpc, String method, int playerID) {
            this.setId(id);
            this.setJsonrpc(jsonrpc);
            this.setMethod(method);
            Params param = new Params();
            param.setPlayerid(playerID);
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

        public Params getParams () {
            return params;
        }

        public void setParams (Params params) {
            this.params = params;
        }

        public String getJsonrpc () {
            return jsonrpc;
        }

        public void setJsonrpc (String jsonrpc) {
            this.jsonrpc = jsonrpc;
        }

        @Override
        public void function(){
            Gson gson = new Gson();
            String json = gson.toJson(this);
            HttpRequestClient httpRequestClient = new HttpRequestClient(this.kp.getIp(),this.kp.getPort());
            httpRequestClient.execute(json);
        }

}

    class Params
    {
        private int playerid;

        public int getPlayerid ()
        {
            return playerid;
        }

        public void setPlayerid (int playerid)
        {
            this.playerid = playerid;
        }
    }
