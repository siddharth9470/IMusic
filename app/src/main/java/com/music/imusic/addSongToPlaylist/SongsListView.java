package com.music.imusic.addSongToPlaylist;

import com.music.imusic.model.Song;

import java.util.List;

public class SongsListView {

    interface mainView {
        void onNoSongFound();
        void setSongListAdapter(List<Song> songList);
    }

    interface presenter {
        void retrieveSongsFromStorage();
        void onClickSongsListView(int clickedPosition, String playlistName);
    }
}
