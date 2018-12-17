package com.music.imusic.addSongToPlaylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.music.imusic.R;
import com.music.imusic.controls.Contants;
import com.music.imusic.model.Song;

import java.util.List;

public class SongsListActivity extends AppCompatActivity implements SongsListView.mainView {

    private ListView songsListView;
    private TextView noPlaylistFound;
    private SongsListPresenter presenter;
    private SongsListViewAdapter songsListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        songsListView = findViewById(R.id.songsListView);
        noPlaylistFound = findViewById(R.id.noPlaylistFound);
        songsListView.setOnItemClickListener(new SongsListViewClickListener());
        presenter = new SongsListPresenter(this, new SongsListInteractor());
        presenter.retrieveSongsFromStorage();
    }

    @Override
    public void onNoSongFound() {
        noPlaylistFound.setVisibility(View.VISIBLE);
    }

    @Override
    public void setSongListAdapter(List<Song> songList) {
        noPlaylistFound.setVisibility(View.GONE);
        songsListViewAdapter = new SongsListViewAdapter(songList);
        songsListView.setAdapter(songsListViewAdapter);
    }

    private class SongsListViewClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            presenter.onClickSongsListView(position, getIntent().getStringExtra(Contants.PLAYLIST_NAME_INTENT));
        }
    }
}
