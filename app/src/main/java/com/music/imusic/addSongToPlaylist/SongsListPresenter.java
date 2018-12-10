package com.music.imusic.addSongToPlaylist;

import com.music.imusic.model.Song;

import java.util.List;

public class SongsListPresenter implements SongsListView.presenter,
        SongsListInteractor.onFinishRetrieveSongsFromStorage {

    private SongsListView.mainView mainView;
    private SongsListInteractor songsListInteractor;

    public SongsListPresenter(SongsListView.mainView mainView, SongsListInteractor songsListInteractor) {
        this.mainView = mainView;
        this.songsListInteractor = songsListInteractor;
    }

    @Override
    public void onRetrieveSongsFromStorage(List<Song> songList) {
        if (mainView != null) {
            mainView.setSongListAdapter(songList);
        }
    }

    @Override
    public void retrieveSongsFromStorage() {
        if (songsListInteractor != null) {
            songsListInteractor.allSongFromDevice(this);
        }
    }
}
