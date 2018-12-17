package com.music.imusic.playlist;

import com.music.imusic.model.Playlist;

import java.util.List;

public class PlaylistView {

    interface view{
        void onNoPlaylistFound();
        void navigateUserToPlaylistDetails(String playlistName);
        void onFinishLoadingPlaylist(List<String> playlistList);
    }

    interface presenter {
        void onClickMenu();
        void loadPlaylistFromDB();
        void onClickPlaylistView(String playlistName);
    }

    interface interactor {
        void onFinishLoadingPlaylist(List<String> playlistList);
    }
}
