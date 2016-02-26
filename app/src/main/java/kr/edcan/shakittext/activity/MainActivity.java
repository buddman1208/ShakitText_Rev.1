package kr.edcan.shakittext.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.adapter.MainData;
import kr.edcan.shakittext.adapter.MainListViewAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MainListViewAdapter adatper;
    ArrayList<MainData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();
        setDefault();
        setListView();
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
        View header = getLayoutInflater().inflate(R.layout.main_header, null);
        EditText mainEdit = (EditText) header.findViewById(R.id.tweet_popup_edittext);
        mainEdit.setEnabled(false);
        mainEdit.setFocusable(false);
        listView.addHeaderView(header);
        listView.setAdapter(adatper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    // 계정

                } else {
                    TextView title = (TextView) view.findViewById(R.id.main_listview_title);
                    switch (title.getText().toString()) {
                        case "테마 설정":

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
}
