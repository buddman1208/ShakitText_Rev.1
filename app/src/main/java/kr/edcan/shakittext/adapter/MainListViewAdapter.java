package kr.edcan.shakittext.adapter;

/**
 * Created by Junseok on 2016. 1. 10..
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.data.DeveloperData;


/**
 * Created by kotohana5706 on 2015. 11. 21.
 * Copyright by Sunrin Internet High School EDCAN
 * All rights reversed.
 */
public class MainListViewAdapter extends ArrayAdapter<MainData> {
    private LayoutInflater mInflater;

    public MainListViewAdapter(Context context, ArrayList<MainData> object) {
        super(context, 0, object);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = null;
        if (v == null) {
            view = mInflater.inflate(R.layout.main_listview_content, null);
        } else {
            view = v;
        }
        final MainData data = this.getItem(position);
        if (data != null) {
            //화면 출력

        }
        return view;
    }
}

