package com.music.imusic.playlist.createPlaylist;

import com.music.imusic.database.IMusicDAO;

public class CreatePlaylistInteractor {

    private IMusicDAO iMusicDAO;

    public CreatePlaylistInteractor() {
        iMusicDAO = IMusicDAO.getInstance();
    }

    public void createPlaylist(String playlistName, CreatePlaylistView.interactor interactor){
        try {
            iMusicDAO.createPlaylist(playlistName);
            interactor.onSuccessfullyPlaylistCreated();
        } catch (Exception e) {
            e.printStackTrace();
            interactor.onFailedToCreatePlaylist(e.getMessage());
        }
    }
}
