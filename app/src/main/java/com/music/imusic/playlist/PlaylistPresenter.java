package com.music.imusic.playlist;

import android.content.Context;
import android.content.Intent;

import com.music.imusic.ApplicationClass;
import com.music.imusic.model.Playlist;
import com.music.imusic.playlist.createPlaylist.CreatePlaylistActivity;

import java.util.List;

public class PlaylistPresenter implements PlaylistView.presenter, PlaylistView.interactor{

    private Context context;
    private PlaylistView.view view;
    private PlaylistInteractor playlistInteractor;

    public PlaylistPresenter(PlaylistView.view view, PlaylistInteractor playlistInteractor) {
        this.view = view;
        this.context = ApplicationClass.getAppContext();
        this.playlistInteractor = playlistInteractor;
    }

    @Override
    public void onClickMenu() {
        Intent intent = new Intent(context, CreatePlaylistActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void loadPlaylistFromDB() {
        playlistInteractor.getAllPlaylist(this);
    }

    @Override
    public void onFinishLoadingPlaylist(List<String> playlistList) {
        if(playlistList == null || playlistList.size() == 0) {
            view.onNoPlaylistFound();
        } else {
            view.onFinishLoadingPlaylist(playlistList);
        }
    }
}
