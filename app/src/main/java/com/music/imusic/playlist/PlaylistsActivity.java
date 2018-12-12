package com.music.imusic.playlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.music.imusic.R;
import com.music.imusic.model.Playlist;

import java.util.List;

public class PlaylistsActivity extends AppCompatActivity implements PlaylistView.view {

    private TextView noPlaylistFound;
    private ListView playlistListview;
    private PlaylistAdapter playlistAdapter;
    private PlaylistPresenter playlistPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);
        noPlaylistFound = findViewById(R.id.noPlaylistFound);
        playlistListview = findViewById(R.id.playlistListview);
        playlistPresenter = new PlaylistPresenter(this, new PlaylistInteractor());
        playlistPresenter.loadPlaylistFromDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user) {
            System.out.println("action_user");
            playlistPresenter.onClickMenu();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoPlaylistFound() {
        noPlaylistFound.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishLoadingPlaylist(List<String> playlistList) {
        noPlaylistFound.setVisibility(View.GONE);
        playlistAdapter = new PlaylistAdapter(playlistList);
        playlistListview.setAdapter(playlistAdapter);
    }
}
