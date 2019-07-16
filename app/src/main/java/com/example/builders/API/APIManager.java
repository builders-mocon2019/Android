package com.example.builders.API;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class APIManager {
    public static APIManager instance = new APIManager();

    private class HttpReqestTask extends AsyncTask<String, Void, HashMap<String, String>> {
        public static final int READ_TIMEOUT = 15000; //Timeout
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected HashMap<String, String> doInBackground(String... strings) {
            String sUrl = strings[0];

            try {
                URL url = new URL(sUrl);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod(strings[1]);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                if (strings.length >= 2 && strings[1] == "POST") {
                    connection.setDoInput(true);
                    connection.getOutputStream().write(strings[2].getBytes());
                }
                connection.connect();

                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
                JsonReader reader = new JsonReader(streamReader);

                reader.beginObject();
                HashMap<String, String> map = new HashMap<String, String>();
                while (reader.hasNext()) {
                    String key = reader.nextName();
                    String value = reader.nextString();
                    map.put(key, value);
                }
                return map;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    HashMap<String, String> get(String URL) {

        try {
            return new HttpReqestTask().execute(URL, "GET").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    HashMap<String, String> call(String... strings) throws ExecutionException, InterruptedException {
        return new HttpReqestTask().execute(strings).get();
    }
}