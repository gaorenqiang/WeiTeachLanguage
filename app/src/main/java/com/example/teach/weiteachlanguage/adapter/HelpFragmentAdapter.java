package com.example.teach.weiteachlanguage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.teach.weiteachlanguage.application.BaseApplication;
import com.example.teach.weiteachlanguage.R;


/**
 * Created by Weiping on 2016/2/2.
 */

public class HelpFragmentAdapter extends FragmentStatePagerAdapter {

    private int position = 0;

    public HelpFragmentAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    public HelpFragmentAdapter(android.support.v4.app.FragmentManager fm, int position) {
        super(fm);
        this.position = position;
    }

    @Override
    public Fragment getItem(int position) {
        switch (this.position) {
            case 0: return HelpCoCoinFragment.newInstance();
            case 1: return HelpFeedbackFragment.newInstance();
            case 2: return HelpAboutFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (this.position) {
            case 0: return "ViewPager";//BaseApplication.getAppContext().getResources().getString(R.string.app_name)
            case 1: return BaseApplication.getAppContext().getResources().getString(R.string.action_settings);
            case 2: return BaseApplication.getAppContext().getResources().getString(R.string.error_title);
        }
        return "";
    }
}
