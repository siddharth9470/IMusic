package com.music.imusic.musicPlayer;

public class MusicPlayerView {

    interface view {

    }

    interface presenter {
        void onClickMenu();
    }

    interface interactor {
        void playSong(String songPath);
        void onFinishSong();
    }
}
