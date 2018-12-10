package com.music.imusic.addSongToPlaylist;

import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import com.music.imusic.ApplicationClass;
import com.music.imusic.model.Song;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongsListInteractor {

    interface onFinishRetrieveSongsFromStorage {
        void onRetrieveSongsFromStorage(List<Song> songList);
    }


    public void allSongFromDevice(onFinishRetrieveSongsFromStorage onFinishRetrieveSongsFromStorage) {
        List<Song> songList = null;
        
        final Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        final String[] cursor_cols = {MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.DURATION};
        final String where = MediaStore.Audio.Media.IS_MUSIC + "=1";
        try {
            final Cursor cursor = ApplicationClass.getAppContext().getContentResolver().query(uri,
                    cursor_cols, where, null, null);


            songList = new ArrayList<>(cursor.getCount());

            while (cursor.moveToNext()) {
            /*String artist = cursor.getString(cursor
                    .getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
            String album = cursor.getString(cursor
                    .getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));*/
                String track = cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                String data = cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                Long albumId = cursor.getLong(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));

                int duration = cursor.getInt(cursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));

                Uri sArtworkUri = Uri
                        .parse("content://media/external/audio/albumart");
                Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri, albumId);

                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(
                            ApplicationClass.getAppContext().getContentResolver(), albumArtUri);
                    bitmap = Bitmap.createScaledBitmap(bitmap, 250, 250, true);

                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();
                }

                Song song = new Song(track, data, bitmap, duration, null, null);
                songList.add(song);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        onFinishRetrieveSongsFromStorage.onRetrieveSongsFromStorage(songList);
    }
}
