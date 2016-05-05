package kr.edcan.shakittext.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.edcan.shakittext.R;

public class TutorialActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        setDefault();
    }

    private void setDefault() {
        viewPager = (ViewPager) findViewById(R.id.tutorial_viewpager);
    }
}
