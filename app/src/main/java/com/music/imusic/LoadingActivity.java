package com.music.imusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.music.imusic.model.Song;
import com.music.imusic.musicPlayer.MusicPlayerActivity;

import java.util.HashMap;

public class LoadingActivity extends Activity {

    private HashMap<String, Song> allSongHashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MusicPlayerActivity.class);
                startActivity(intent);
            }
        }, 1000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}
