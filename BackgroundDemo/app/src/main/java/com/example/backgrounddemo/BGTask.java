package com.example.backgrounddemo;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BGTask extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("RKTAG", "Process of background execution has started");
    }

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpURLConnection conn;

        try {
            url = new URL(urls[0]);
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while (data != -1){
                char ch = (char) data;
                result += ch;
                data = reader.read();
            }
        }catch (Exception e){
            Log.d("RKTAG", "doInBackground: Some error occured");
            return "Something went wrong";
        }

        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("RKTAG", s);
    }
}
