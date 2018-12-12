package com.music.imusic.playlist;

import com.music.imusic.model.Playlist;

import java.util.List;

public class PlaylistView {

    interface view{
        void onNoPlaylistFound();
        void onFinishLoadingPlaylist(List<String> playlistList);
    }

    interface presenter {
        void onClickMenu();
        void loadPlaylistFromDB();
    }

    interface interactor {
        void onFinishLoadingPlaylist(List<String> playlistList);
    }
}
