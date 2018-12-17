package com.music.imusic.playlist.playlistDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.music.imusic.R;
import com.music.imusic.addSongToPlaylist.SongsListActivity;
import com.music.imusic.controls.Contants;
import com.music.imusic.model.Song;

import java.util.List;

public class PlaylistDetailsActivity extends AppCompatActivity implements PlaylistDetailsView.view {

    private PlaylistDetailsPresenter playlistDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_details);
        playlistDetailsPresenter = new PlaylistDetailsPresenter(this);
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
            playlistDetailsPresenter.onClickMenu();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ifNoSongsFound() {

    }

    @Override
    public void showLoadingPopup() {

    }

    @Override
    public void dismissLoadingPopup() {

    }

    @Override
    public void navigateToSongsListActivity() {
        Intent intent = new Intent(getApplicationContext(), SongsListActivity.class);
        intent.putExtra(Contants.PLAYLIST_NAME_INTENT, getIntent().getStringExtra(Contants.PLAYLIST_NAME_INTENT));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onSuccessfullyGettingSongsFromTheDB(List<Song> songList) {

    }
}
