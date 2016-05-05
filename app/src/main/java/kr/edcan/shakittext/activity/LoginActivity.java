package kr.edcan.shakittext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import kr.edcan.shakittext.R;
import kr.edcan.shakittext.utils.LoginButton;

public class LoginActivity extends AppCompatActivity {
    LoginButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (LoginButton) findViewById(R.id.loginButton);
        button.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Toast.makeText(LoginActivity.this, result.data.getUserName() + " 계정으로 로그인에 성공했습니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(LoginActivity.this, exception.getMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        button.onActivityResult(requestCode, resultCode, data);
    }

}
