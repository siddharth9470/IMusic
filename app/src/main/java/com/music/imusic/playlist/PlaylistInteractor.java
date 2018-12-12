package com.music.imusic.playlist;

import com.music.imusic.database.IMusicDAO;
import com.music.imusic.model.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistInteractor {

    private IMusicDAO iMusicDAO;

    public PlaylistInteractor() {
        iMusicDAO = IMusicDAO.getInstance();
    }


    public void getAllPlaylist(PlaylistView.interactor interactor) {
        List<String> playlist = iMusicDAO.getAllPlaylist();
        interactor.onFinishLoadingPlaylist(playlist);
    }

}
