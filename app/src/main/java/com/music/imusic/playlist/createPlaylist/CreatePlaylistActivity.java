package com.music.imusic.playlist.createPlaylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.music.imusic.R;

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
