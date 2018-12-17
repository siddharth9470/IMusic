package com.music.imusic.playlist.playlistDetail;

/**
 * Created by Lenovo on 12/15/2018.
 */

public class PlaylistDetailsPresenter implements PlaylistDetailsView.presenter {

    private PlaylistDetailsView.view view;

    public PlaylistDetailsPresenter(PlaylistDetailsView.view view) {
        this.view = view;
    }

    @Override
    public void onClickMenu() {
        if (view != null) {
            view.navigateToSongsListActivity();
        }
    }

    @Override
    public void fetchSongsFromDB(String playlistName) {

    }
}
