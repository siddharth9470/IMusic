package com.music.imusic.playlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.music.imusic.R;

import java.util.List;

public class PlaylistAdapter extends BaseAdapter {

    private List<String> playlistList;

    public PlaylistAdapter(List<String> playlistList) {
        this.playlistList = playlistList;
    }

    @Override
    public int getCount() {
        return playlistList.size();
    }

    @Override
    public Object getItem(int position) {
        return playlistList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_listview_view, null);
        TextView playlist = view.findViewById(R.id.playlist);
        playlist.setText(playlistList.get(position));
        return view;
    }
}
