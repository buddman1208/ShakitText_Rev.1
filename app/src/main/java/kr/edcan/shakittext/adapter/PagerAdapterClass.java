package kr.edcan.shakittext.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import kr.edcan.shakittext.R;

/**
 * Created by KOHA_CLOUD on 16. 5. 5..
 */
public class PagerAdapterClass extends PagerAdapter {
    private LayoutInflater mInflater;

    public PagerAdapterClass(Context c) {
        super();
        mInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object instantiateItem(final View pager, int position) {
        View v = null;
        switch (position){
            case 0:
                v = mInflater.inflate(R.layout.tutorial_page1, null);
                break;
            case 1:
                v = mInflater.inflate(R.layout.tutorial_page2, null);
                break;
            case 2:
                break;
            case 3:
                break;
        }
        ((ViewPager) pager).addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(View pager, int position, Object view) {
        ((ViewPager) pager).removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View pager, Object obj) {
        return pager == obj;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }

    @Override
    public void finishUpdate(View arg0) {
    }
}
