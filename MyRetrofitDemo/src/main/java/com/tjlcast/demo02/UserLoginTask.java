package com.tjlcast.demo02;

import com.tjlcast.demo02.Example01.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 传统的做法
 */
public class UserLoginTask implements AsyncTask<Void,Void,Boolean> {

    private final String mEmail ;
    private final String mPassword ;
    private final String[] DUMMY_CREDENTIALS = new String[1] ;

    UserLoginTask(String mEmail, String mPassword) {
        this.mEmail = mEmail ;
        this.mPassword = mPassword ;
    }

    @Override
    public boolean doInBackground(Void... params) {
        try {
            // Simulate network access.
            String result = "" ;
            BufferedReader in = null ;
            String path = "http://localhost:8080/login?" + "email=" + mEmail + "&password" + mPassword ;
            URL url = new URL(path) ;

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            ) ;
            String line ;
            while ((line = in.readLine()) != null) {
                result += "\n" + line ;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":") ;
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword) ;
            }
        }

        return true ;
    }

    @Override
    public void onPostExecute(boolean success) {
        if (success) {
            // do something.
        } else  {
            // do something.
        }
    }

    @Override
    public void onCancelled() {
        // do something.
    }
}
