package com.music.imusic.playlist.createPlaylist;

import com.music.imusic.model.Playlist;

public class CreatePlaylistView {

    interface view {
        void navigateToAllSongsActivity();
        void onSuccessfullyPlaylistCreated();
        void onFailedToCreatePlaylist(String error);
    }

    interface presenter {
        void onDestroyActivity();
        void onClickAddSongsInPlaylist();
        void onClickCreatePlaylist(String playlistName);
    }

    interface interactor {
        void onSuccessfullyPlaylistCreated();
        void onFailedToCreatePlaylist(String error);
    }
}
