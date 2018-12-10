package com.music.imusic.addSongToPlaylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.music.imusic.R;
import com.music.imusic.model.Song;

import java.util.List;

public class SongsListActivity extends AppCompatActivity implements SongsListView.mainView {

    private ListView songsListView;
    private SongsListView.presenter presenter;
    private SongsListViewAdapter songsListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        songsListView = findViewById(R.id.songsListView);
        presenter = new SongsListPresenter(this, new SongsListInteractor());
        presenter.retrieveSongsFromStorage();
    }

    @Override
    public void setSongListAdapter(List<Song> songList) {
        songsListViewAdapter = new SongsListViewAdapter(songList);
        songsListView.setAdapter(songsListViewAdapter);
    }
}
