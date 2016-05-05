package kr.edcan.shakittext.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

import kr.edcan.shakittext.R;

public class SendActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        setDefault();
    }
    private void setDefault() {
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Twitter.getApiClient().getStatusesService().update(editText.getText().toString().trim(), null, null, null, null, null, null, null, null, new Callback<Tweet>() {
                    @Override
                    public void success(Result<Tweet> result) {
                    }

                    @Override
                    public void failure(TwitterException exception) {
                    }
                });
            }
        });
    }
}
