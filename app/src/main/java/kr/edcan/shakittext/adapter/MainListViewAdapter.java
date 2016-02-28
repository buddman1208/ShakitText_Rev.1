package kr.edcan.shakittext.adapter;

/**
 * Created by Junseok on 2016. 1. 10..
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rey.material.widget.Switch;

import java.util.ArrayList;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.data.DeveloperData;


/**
 * Created by kotohana5706 on 2015. 11. 21.
 * Copyright by Sunrin Internet High School EDCAN
 * All rights reversed.
 */
public class MainListViewAdapter extends ArrayAdapter<MainData> {
    String[] themeType = new String[]{"트위터 블루", "느와르 핑크", "서티나인 민트", "소프트 핑크"};
    SharedPreferences sharedPreferences = getContext().getSharedPreferences("ShakitText", 0);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    private LayoutInflater mInflater;

    public MainListViewAdapter(Context context, ArrayList<MainData> object) {
        super(context, 0, object);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = null;
        final MainData data = this.getItem(position);
        if(data.isHasHeader()) {
            view = mInflater.inflate(R.layout.main_listview_content_header, null);
        } else view = mInflater.inflate(R.layout.main_listview_content, null);

        if (data != null) {
            if (!data.isHasHeader()) {
                ImageView profile = (ImageView) view.findViewById(R.id.main_listview_image);
                TextView title = (TextView) view.findViewById(R.id.main_listview_title);
                TextView content = (TextView) view.findViewById(R.id.main_listview_content);
                TextView rightText = (TextView) view.findViewById(R.id.main_listview_right_text);
                TextView profileChange = (TextView) view.findViewById(R.id.main_listview_right_profile_change);
                Switch sw = (Switch) view.findViewById(R.id.main_listview_right_switch);
                sw.setVisibility(View.GONE);
                profileChange.setVisibility(View.GONE);
                rightText.setVisibility(View.GONE);
                profile.setVisibility(View.GONE);
                switch (data.getListType()) {
                    case 0:
                        profile.setVisibility(View.VISIBLE);
                        profileChange.setVisibility(View.VISIBLE);
                        title.setText(data.getHeaderTitle());
                        content.setText(data.getSubText());
                        rightText.setText("변경");
                        break;
                    case 1:
                        rightText.setVisibility(View.VISIBLE);
                        title.setText(data.getMainText());
                        content.setText(data.getSubText());
                        if (data.getMainText().equals("테마 설정")) {
                            rightText.setText(themeType[sharedPreferences.getInt("theme", 0)]);
                        } else {
                            rightText.setText("감도 " + sharedPreferences.getInt("sensibility", 0));
                        }
                        break;
                    case 2:
                        sw.setVisibility(View.VISIBLE);
                        title.setText(data.getMainText());
                        content.setText(data.getSubText());
                        switch (data.getMainText()) {
                            case "가로모드에서 사용":
                                if (sharedPreferences.getBoolean("onOrientation", true)) {
                                    sw.setChecked(true);
                                    editor.putBoolean("onOrientation", true);
                                    editor.commit();
                                } else sw.setChecked(false);
                                break;
                            case "부팅시 자동 실행":
                                if (sharedPreferences.getBoolean("onBoot", true)) {
                                    sw.setChecked(true);
                                    editor.putBoolean("onBoot", true);
                                    editor.commit();
                                } else sw.setChecked(false);
                                break;
                            case "햅틱 반응":
                                if (sharedPreferences.getBoolean("vibrate", true)) {
                                    sw.setChecked(true);
                                    editor.putBoolean("vibrate", true);
                                    editor.commit();
                                } else sw.setChecked(false);
                                break;
                        }
                        break;
                    case 3:
                        title.setText(data.getMainText());
                        content.setText(data.getSubText());
                        break;
                }
            } else{
                TextView headerTitle = (TextView) view.findViewById(R.id.main_listview_header);
                headerTitle.setVisibility(View.VISIBLE);
                headerTitle.setText(data.getHeaderTitle());
            }
        }
        return view;
    }
}

