package kr.edcan.shakittext.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import java.lang.ref.WeakReference;

/**
 * Created by KOHA_CLOUD on 16. 5. 5..
 */
public class LoginButton extends TwitterLoginButton {

    public LoginButton(Context context) {
        this(context, null);
    }

    public LoginButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, null);
    }

    LoginButton(Context context, AttributeSet attrs, int defStyle,
                TwitterAuthClient authClient) {
        super(context, attrs, defStyle);
        setupButton();
    }

    private void setupButton() {
        Drawable d = getResources().getDrawable(com.twitter.sdk.android.core.R.drawable.tw__ic_logo_default);
        d.setColorFilter(getResources().getColor(com.twitter.sdk.android.core.R.color.tw__blue_default), PorterDuff.Mode.MULTIPLY);
        super.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
        super.setBackgroundColor(Color.WHITE);
        super.setTextColor(getResources().getColor(com.twitter.sdk.android.core.R.color.tw__blue_default));

    }
}
