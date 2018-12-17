package com.music.imusic.playlist.playlistDetail;

import com.music.imusic.model.Song;

import java.util.List;

/**
 * Created by Lenovo on 12/15/2018.
 */

public class PlaylistDetailsView {

    interface view {
        void ifNoSongsFound();
        void showLoadingPopup();
        void dismissLoadingPopup();
        void navigateToSongsListActivity();
        void onSuccessfullyGettingSongsFromTheDB(List<Song> songList);
    }

    interface presenter {
        void onClickMenu();
        void fetchSongsFromDB(String playlistName);
    }
}
