package com.example.micha.kodiremote.Utills;

import android.app.DownloadManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Michał on 05.11.2017.
 */

public class HttpRequestClient extends AsyncTask<String, Void, Void> {
    String request;

    public HttpRequestClient(String ip, String port) {

        this.request = requestCreator(ip, port);
    }

    public String requestCreator(String ip, String port) {
        return "http://" + ip + ":" + port + "/jsonrpc?request=";
    }


    @Override
    protected Void doInBackground(String... json) {
        try {
            Log.d("request", "Tutaj jestem");
            URL url = new URL(this.request);
            // Create the urlConnection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            if (json[0] != null) {
                OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                writer.write(json[0]);
                writer.flush();

            }
            int statusCode = urlConnection.getResponseCode();

            if (statusCode == 200) {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                String response= readStream(inputStream, 500);
                Gson gson = new Gson();
                String resultJson = gson.toJson(response);
                Log.d("Response", resultJson);

            }
            else{

            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readStream(InputStream stream, int maxReadSize) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] rawBuffer = new char[maxReadSize];
        int readSize;
        StringBuffer buffer = new StringBuffer();
        while (((readSize = reader.read(rawBuffer)) != -1) && maxReadSize > 0) {
            if (readSize > maxReadSize) {
                readSize = maxReadSize;
            }
            buffer.append(rawBuffer, 0, readSize);
            maxReadSize -= readSize;
        }
        return buffer.toString();
    }
}
