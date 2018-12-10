package com.music.imusic.musicPlayer;

import android.content.Context;
import android.content.Intent;

import com.music.imusic.ApplicationClass;
import com.music.imusic.playlist.PlaylistsActivity;

public class MusicPlayerPresenter implements MusicPlayerView.presenter, MusicPlayerView.interactor {

    private Context context;
    private MusicPlayerView.view view;
    private MusicPlayerInteractor musicPlayerInteractor;

    public MusicPlayerPresenter(MusicPlayerView.view view, MusicPlayerInteractor musicPlayerInteractor) {
        this.view = view;
        this.context = ApplicationClass.getAppContext();
        this.musicPlayerInteractor = musicPlayerInteractor;
    }

    @Override
    public void onClickMenu() {
        Intent intent = new Intent(context, PlaylistsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void playSong(String songPath) {

    }

    @Override
    public void onFinishSong() {

    }
}
