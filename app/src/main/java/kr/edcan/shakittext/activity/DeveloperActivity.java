package kr.edcan.shakittext.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.adapter.DeveloperListViewAdapter;
import kr.edcan.shakittext.data.DeveloperData;


public class DeveloperActivity extends AppCompatActivity {

    ListView listView;
    View header;
    DeveloperListViewAdapter adapter;
    ArrayList<DeveloperData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        try {
            setDefault();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        setActionBar(getSupportActionBar());

    }

    private void setDefault() throws PackageManager.NameNotFoundException {
        header = getLayoutInflater().inflate(R.layout.developer_header, null);
        listView = (ListView) findViewById(R.id.developer_listview);
        arrayList = new ArrayList<>();
        arrayList.add(new DeveloperData("Version", getPackageManager().getPackageInfo(getPackageName(), 0).versionName));
        arrayList.add(new DeveloperData("User Support", "kotohana5706@edcan.kr"));
        arrayList.add(new DeveloperData("Homepage", "http://edcan.kr"));
        arrayList.add(new DeveloperData("Main Programmer", "KOTOHANA (http://malang.moe)"));
        arrayList.add(new DeveloperData("Main UI Designer", "Luminon (http://itsuka.me)"));
        adapter = new DeveloperListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);
        listView.addHeaderView(header);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:kotohana5706@edcan.kr"));
                        startActivity(Intent.createChooser(emailIntent, "이메일 전송"));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://edcan.kr")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://malang.moe")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://itsuka.me")));
                        break;
                    case 5:
                        break;
                }
            }
        });
    }

    private void setActionBar(ActionBar actionBar) {
        actionBar.setTitle("About ShakitText");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setElevation(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
