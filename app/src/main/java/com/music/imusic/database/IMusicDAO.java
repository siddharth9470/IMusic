package com.music.imusic.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.music.imusic.ApplicationClass;
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
        /*
        * method for creating new  playlist
        * */
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.IMusicAppTables.PLAYLIST_NAME, playlistName);
        database.insert(DatabaseContract.IMusicAppTables.PLAYLIST_TABLE, null, values);
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    public List<String> getAllPlaylist() {
        /*
        * returns all playlist
        * */
        List<String> playlistList = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.IMusicAppTables.PLAYLIST_TABLE,
                null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String playListName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IMusicAppTables.PLAYLIST_NAME));
            playlistList.add(playListName);
            System.out.print(playListName);
        }
        cursor.close();
        return playlistList;
    }

    public List<String> getAllSongsFromThePlaylist(String playlistName) {
        /*
        * returns all playlist
        * */
        List<String> songPathList = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(DatabaseContract.IMusicAppTables.PLAYLIST_SONGS_TABLE);
        query.append(" where ");
        query.append(DatabaseContract.IMusicAppTables.PLAYLIST_NAME);
        query.append(" = ");
        query.append(" '" +playlistName + "'");
        Cursor cursor = database.rawQuery(query.toString(), null);
        while (cursor.moveToNext()) {
            String songPath = cursor.getString(cursor.getColumnIndex(DatabaseContract.IMusicAppTables.PLAYLIST_SONG_PATH));
            songPathList.add(songPath);
        }
        cursor.close();
        return songPathList;
    }

    public void saveSongsPath(String playlistName, Song song) {
        /*
        * save single song path mapped with single playlist
        * */
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.IMusicAppTables.PLAYLIST_NAME, playlistName);
        values.put(DatabaseContract.IMusicAppTables.PLAYLIST_SONG_PATH, song.getSongPath());
        database.insert(DatabaseContract.IMusicAppTables.PLAYLIST_SONGS_TABLE, null, values);
        database.setTransactionSuccessful();
        database.endTransaction();
        getAllSongsFromThePlaylist(playlistName);
    }


}
