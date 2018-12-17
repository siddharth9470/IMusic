package com.music.imusic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT ";
    private static final String INT_TYPE = " INTEGER ";
    private static final String ID_TYPE = " INTEGER PRIMARY KEY AUTOINCREMENT ";
    private static final String COMMA = " , ";
    private static final int DATABASE_VERSION = 31;



    private static final String CREATE_PLAYLIST_TABLE = "CREATE TABLE IF NOT EXISTS "
            + DatabaseContract.IMusicAppTables.PLAYLIST_TABLE + " ( "
            + DatabaseContract.IMusicAppTables.ID + ID_TYPE + COMMA
            + DatabaseContract.IMusicAppTables.PLAYLIST_NAME + TEXT_TYPE + " ) ";

    private static final String CREATE_PLAYLIST_SONGS_TABLE = "CREATE TABLE IF NOT EXISTS "
            + DatabaseContract.IMusicAppTables.PLAYLIST_SONGS_TABLE + " ( "
            + DatabaseContract.IMusicAppTables.ID + ID_TYPE + COMMA
            + DatabaseContract.IMusicAppTables.PLAYLIST_NAME + TEXT_TYPE + COMMA
            + DatabaseContract.IMusicAppTables.PLAYLIST_SONG_PATH + TEXT_TYPE + " ) ";


    public static final String DROP_PLAYLIST_TABLE = "DROP TABLE IF EXISTS " +
            DatabaseContract.IMusicAppTables.PLAYLIST_TABLE;

    public static final String DROP_PLAYLIST_SONGS_TABLE= "DROP TABLE IF EXISTS " +
            DatabaseContract.IMusicAppTables.PLAYLIST_SONGS_TABLE;

    public DBOpenHelper(Context context) {
        super(context, DatabaseContract.DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLAYLIST_TABLE);
        db.execSQL(CREATE_PLAYLIST_SONGS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_PLAYLIST_TABLE);
        db.execSQL(DROP_PLAYLIST_SONGS_TABLE);
    }
}
