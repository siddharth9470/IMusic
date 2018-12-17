package com.music.imusic.addSongToPlaylist;

/**
 * Created by Lenovo on 12/16/2018.
 */

public interface ISongListSelector {
    /*
    * This interface is used for updated background on click of listview
    * Selector sets to true on save song in DB
    * */

    void onClickSongsListView(int clickedPosition, boolean isSongPathSavedInDB);
}
