package com.tjlcast.demo02.Example01;

/**
 * Created by tangjialiang on 2018/5/28.
 */
public interface AsyncTask<T, T1, T2> {

    boolean doInBackground(Void... params) ;

    void onPostExecute(final boolean success) ;

    void onCancelled() ;
}
