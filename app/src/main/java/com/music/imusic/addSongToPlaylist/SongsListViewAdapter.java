package com.music.imusic.addSongToPlaylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.music.imusic.R;
import com.music.imusic.model.Song;

import java.util.List;

public class SongsListViewAdapter extends BaseAdapter {

    private List<Song> songList;

    public SongsListViewAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return songList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_listview_view, null);
        TextView song = view1.findViewById(R.id.song);
        song.setText(songList.get(i).getSongTitle());
        return view1;
    }
}
