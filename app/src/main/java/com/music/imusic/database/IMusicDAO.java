package com.music.imusic.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.music.imusic.ApplicationClass;
import com.music.imusic.model.Playlist;
import com.music.imusic.model.Song;

import java.util.ArrayList;
import java.util.List;

public class IMusicDAO {

    private static IMusicDAO instance;
    private static SQLiteDatabase database;

    private IMusicDAO() {

    }

    public static IMusicDAO getInstance() {
        if (instance == null) {
            instance = new IMusicDAO();
            database = new DBOpenHelper(ApplicationClass.getAppContext()).getWritableDatabase();
        }
        return instance;
    }

    public void createPlaylist(String playlistName) throws Exception {
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.IMusicAppTableConstants.PLAYLIST_NAME, playlistName);
        database.insert(DatabaseContract.IMusicAppTableConstants.PLAYLIST_TABLE, null, values);
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    public void addSongsInPlaylist(String playlistName, List<Song> songList) {

    }

    public List<String> getAllPlaylist() {
        List<String> playlistList = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.IMusicAppTableConstants.PLAYLIST_TABLE,
                null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String playListName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IMusicAppTableConstants.PLAYLIST_NAME));
            playlistList.add(playListName);
            System.out.print(playListName);
        }
        cursor.close();
        return playlistList;
    }
}
