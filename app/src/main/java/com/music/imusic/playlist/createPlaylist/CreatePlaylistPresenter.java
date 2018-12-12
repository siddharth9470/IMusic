package com.music.imusic.playlist.createPlaylist;

import android.text.TextUtils;

import com.music.imusic.model.Playlist;

public class CreatePlaylistPresenter implements CreatePlaylistView.presenter, CreatePlaylistView.interactor {

    private CreatePlaylistView.view view;
    private CreatePlaylistInteractor createPlaylistInteractor;

    public CreatePlaylistPresenter(CreatePlaylistView.view view, CreatePlaylistInteractor createPlaylistInteractor) {
        this.view = view;
        this.createPlaylistInteractor = createPlaylistInteractor;
    }

    @Override
    public void onDestroyActivity() {
        this.view = null;
    }

    @Override
    public void onClickAddSongsInPlaylist() {

    }

    @Override
    public void onClickCreatePlaylist(String playlistName) {
        if(view != null) {
            if(!TextUtils.isEmpty(playlistName)) {
                createPlaylistInteractor.createPlaylist(playlistName, this);
            } else {
                view.onFailedToCreatePlaylist("Enter playlist name");
            }
        }
    }

    @Override
    public void onSuccessfullyPlaylistCreated() {
        if(view != null) {
            view.onSuccessfullyPlaylistCreated();
        }
    }

    @Override
    public void onFailedToCreatePlaylist(String error) {
        if(view != null) {
            view.onFailedToCreatePlaylist(error);
        }
    }
}
