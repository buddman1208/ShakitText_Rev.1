package kr.edcan.shakittext.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.rey.material.widget.Switch;

import java.util.ArrayList;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.adapter.MainData;
import kr.edcan.shakittext.adapter.MainListViewAdapter;

public class MainActivity extends AppCompatActivity {

    View header;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ListView listView;
    MainListViewAdapter adatper;
    ArrayList<MainData> arrayList;
    String[] themeName = {"트위터 블루", "느와르 핑크", "서티나인 민트", "소프트 핑크"};
    int[] headerbg = {R.drawable.cardview_header_blue_bg, R.drawable.cardview_header_npink_bg, R.drawable.cardview_header_mint_bg, R.drawable.cardview_header_spink_bg};
    int[] footerbg = {R.drawable.cardview_footer_blue_bg, R.drawable.cardview_footer_npink_bg, R.drawable.cardview_footer_mint_bg, R.drawable.cardview_footer_spink_bg};
    int[] styles = {R.style.AppTheme_Blue, R.style.AppTheme_nPink, R.style.AppTheme_Mint, R.style.AppTheme_sPink};
    int[] actionBarColor = {R.color.blueThemeTitle, R.color.noirPinkThemeTitle, R.color.mintThemeTitle, R.color.softPinkThemeTitle};
    int[] actionBarColorDark = {R.color.blueThemeTitleDark, R.color.noirPinkThemeTitleDark, R.color.mintThemeTitleDark, R.color.softPinkThemeTitleDark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBar();
        pref = getSharedPreferences("ShakitText", 0);
        editor = pref.edit();
        setContentView(R.layout.activity_main);
        setDefault();
        setListView();
        loadMainTheme(pref.getInt("theme", 0));
    }

    private void setActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    private void setDefault() {
        listView = (ListView) findViewById(R.id.main_listview);
        arrayList = new ArrayList<>();
    }

    private void setListView() {
        arrayList.add(new MainData("계정"));
        arrayList.add(new MainData(0, 0, "더일해라 루미논!", "@misaca_network"));
        arrayList.add(new MainData("Shakit 플로팅 위젯 설정"));
        arrayList.add(new MainData(1, "테마 설정", "플로팅 위젯의 테마를 변경할 수 있습니다"));
        arrayList.add(new MainData(2, "흔들어 보내기", "트윗을 작성하고 다시 흔들어 트윗을 보냅니다."));
        arrayList.add(new MainData("세부 기능 설정"));
        arrayList.add(new MainData(1, "감도 설정", "흔드는 감도를 세부적으로 조절합니다."));
        arrayList.add(new MainData(2, "가로모드에서 사용", "휴대전화가 가로모드일때 사용할지 설정합니다."));
        arrayList.add(new MainData(3, "위젯 작동 제한", "특정 앱에서 ShakitText가 켜지지 않게 설정합니다."));
        arrayList.add(new MainData(2, "부팅시 자동 실행", "휴대전화가 켜질때 자동으로 ShakitText를 시작합니다."));
        arrayList.add(new MainData(2, "햅틱 반응", "위젯이 등장할 때 햅틱 피드백을 합니다."));
        arrayList.add(new MainData(3, "앱 종료", "앱을 완전히 종료합니다."));
        arrayList.add(new MainData("기타"));
        arrayList.add(new MainData(3, "앱 정보 보기", "Shakit Text의 앱 정보를 확인합니다."));
        arrayList.add(new MainData(3, "튜토리얼 다시보기", "튜툐리얼을 다시한번 확인합니다."));
        adatper = new MainListViewAdapter(getApplicationContext(), arrayList);
        header = getLayoutInflater().inflate(R.layout.main_header, null);
        EditText mainEdit = (EditText) header.findViewById(R.id.tweet_popup_edittext);
        mainEdit.setEnabled(false);
        mainEdit.setFocusable(false);
        listView.addHeaderView(header);
        listView.setAdapter(adatper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                else if (position == 2) {
                    // 계정

                } else {
                    TextView title = (TextView) view.findViewById(R.id.main_listview_title);
                    Switch sw = (Switch) view.findViewById(R.id.main_listview_right_switch);
                    final TextView right = (TextView) view.findViewById(R.id.main_listview_right_text);
                    switch (title.getText().toString()) {
                        case "테마 설정":
                            new MaterialDialog.Builder(MainActivity.this)
                                    .title("테마 설정")
                                    .items(themeName)
                                    .itemsCallback(new MaterialDialog.ListCallback() {
                                        @Override
                                        public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                                            editor.putInt("theme", which);
                                            editor.commit();
                                            loadMainTheme(which);
                                            right.setText(themeName[which]);
                                        }
                                    })
                                    .show();
                            break;
                        case "흔들어 보내기":
                            break;
                        case "감도 설정":
                            break;
                        case "가로모드에서 사용":
                            break;
                        case "위젯 작동 제한":
                            break;
                        case "부팅시 자동 실행":
                            break;
                        case "햅틱 반응":
                            break;
                        case "앱 종료":
                            break;
                        case "앱 정보 보기":
                            startActivity(new Intent(getApplicationContext(), DeveloperActivity.class));
                            break;
                        case "튜토리얼 다시보기":
                            break;
                    }
                }
            }
        });
    }

    private void loadMainTheme(int resValue) {
        RelativeLayout headLayout = (RelativeLayout) header.findViewById(R.id.cardview_header);
        LinearLayout footLayout = (LinearLayout) header.findViewById(R.id.cardview_footer);
        headLayout.setBackgroundResource(headerbg[resValue]);
        footLayout.setBackgroundResource(footerbg[resValue]);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(actionBarColor[resValue])));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(actionBarColorDark[resValue]));
    }
}
