package com.example.teach.weiteachlanguage.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.teach.weiteachlanguage.R;


/**
 * 这个类用来处理关于ToolBar的所有事件
 * Created by gaonqiang on 2017/11/12.
 */

public class BaseActivity extends AppCompatActivity
{
    private Toolbar mToolbar;
    private TextView toolbar_title;

    public void initToolbar(int recourseId){
        mToolbar = (Toolbar) findViewById(recourseId);
        mToolbar.dismissPopupMenus();
        mToolbar.setTitle("123456");
        setSupportActionBar(mToolbar);
    }

    public void setToolbarTitle(String title) {
        if (mToolbar != null){
            toolbar_title = (TextView) mToolbar.findViewById(R.id.toolbar_title);
            toolbar_title.setVisibility(View.VISIBLE);
            toolbar_title.setText(title);
        }
    }

    public String getToolbarTitle(){
        String ret = null;
        if (mToolbar != null && toolbar_title != null) {
            ret = toolbar_title.getText().toString();
        }
        return ret;
    }

    public void enToolbarBack(View.OnClickListener listener){
        /*if (mToolbar != null) {
            ImageView view = (ImageView) mToolbar.findViewById(R.id.toolbar_back);
            view.setVisibility(View.VISIBLE);
            view.setOnClickListener(listener);
        }*/
    }
}
