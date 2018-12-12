package com.music.imusic.playlist.createPlaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.music.imusic.R;
import com.music.imusic.addSongToPlaylist.SongsListActivity;

public class CreatePlaylistActivity extends AppCompatActivity implements CreatePlaylistView.view {

    private EditText playlistName;
    private Button submit, addSong;
    private CreatePlaylistPresenter createPlaylistPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);
        submit = findViewById(R.id.submit);
        addSong = findViewById(R.id.addSong);
        playlistName = findViewById(R.id.playlistName);
        submit.setOnClickListener(new ActivityButtonClickListeners());
        addSong.setOnClickListener(new ActivityButtonClickListeners());
        createPlaylistPresenter = new CreatePlaylistPresenter(this, new CreatePlaylistInteractor());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        createPlaylistPresenter.onDestroyActivity();
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
            createPlaylistPresenter.onClickAddSongsInPlaylist();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToAllSongsActivity() {
        Intent intent = new Intent(getApplicationContext(), SongsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onSuccessfullyPlaylistCreated() {

    }

    @Override
    public void onFailedToCreatePlaylist(String error) {

    }

    private class ActivityButtonClickListeners implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.submit:
                    createPlaylistPresenter.onClickCreatePlaylist(playlistName.getText().toString());
                    break;

                case R.id.addSong:
                    createPlaylistPresenter.onClickAddSongsInPlaylist();
                    break;
            }
        }
    }
}
