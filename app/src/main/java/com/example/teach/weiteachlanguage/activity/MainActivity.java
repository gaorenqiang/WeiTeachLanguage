package com.example.teach.weiteachlanguage.activity;

//import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.teach.weiteachlanguage.R;
import com.example.teach.weiteachlanguage.service.ProgressBarForMain;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private  static String TAG="MainActivity";
    //UI对象声明
    private TextView tv_top_bar;
    private TextView tab_course;
    private TextView tab_community;
    private TextView tab_activity;
    private TextView tab_profile;
    private FrameLayout fragment_content;
    private ProgressBar bar;

    //Fragment对象声明
    private FragmentCourse fragmentCourse;
    private FragmentCommunity fragmentCommunity;
    private FragmentActivity fragmentActivity;
    private FragmentProfile fragmentProfile;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        getParametersFromStartActivity();
        //启用Android5.1自带的顶部导航栏
        initToolbar(R.id.toolbar_main);
        fragmentManager = this.getFragmentManager();
        bindViews();
        tab_course.performClick();   //模拟一次点击，既进去后选择第一项
        loadingData();
    }

    private void getParametersFromStartActivity() {
        //获得传值对象Activity
        /*Intent intent=getIntent();
        int age=intent.getIntExtra("age",0);
        String name=intent.getStringExtra("name");
        Toast.makeText(this,"passed name is"+name+",age is "+age,Toast.LENGTH_SHORT).show();
        Log.i(TAG, "传递的值为："+name + ", " + age + "!");*/
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        setToolbarTitle("登录");
        enToolbarBack(this);
        tv_top_bar = (TextView) findViewById(R.id.tv_top_bar);
        tab_course = (TextView) findViewById(R.id.tab_course);
        tab_community = (TextView) findViewById(R.id.tab_community);
        tab_activity = (TextView) findViewById(R.id.tab_activity);
        tab_profile = (TextView) findViewById(R.id.tab_profile);
        bar=(ProgressBar)this.findViewById(R.id.bar);
        fragment_content = (FrameLayout) findViewById(R.id.fragment_content);

        tab_course.setOnClickListener(this);
        tab_community.setOnClickListener(this);
        tab_activity.setOnClickListener(this);
        tab_profile.setOnClickListener(this);
    }

    private  void  loadingData(){
        ProgressBarForMain barTask = new ProgressBarForMain(this,bar);
        barTask.execute("start");
    }

    //重置所有文本的选中状态
    private void setDefaultSelected(){
        tab_course.setSelected(false);
        tab_community.setSelected(false);
        tab_activity.setSelected(false);
        tab_profile.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fragmentCourse != null)fragmentTransaction.hide(fragmentCourse);
        if(fragmentCommunity != null)fragmentTransaction.hide(fragmentCommunity);
        if(fragmentActivity != null)fragmentTransaction.hide(fragmentActivity);
        if(fragmentProfile != null)fragmentTransaction.hide(fragmentProfile);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (v.getId()){
            case R.id.tab_course://顶部标题也要相应的发生改变
                setDefaultSelected();
                tab_course.setSelected(true);
                if(fragmentCourse == null){
                    fragmentCourse = new FragmentCourse();
                    fragmentTransaction.add(R.id.fragment_content, fragmentCourse);
                }else{
                    fragmentTransaction.show(fragmentCourse);
                }
                break;

            case R.id.tab_community:
                setDefaultSelected();
                tab_community.setSelected(true);
                if(fragmentCommunity == null){
                    fragmentCommunity = new FragmentCommunity();
                    fragmentTransaction.add(R.id.fragment_content, fragmentCommunity);
                }else{
                    fragmentTransaction.show(fragmentCommunity);
                }
                break;

            case R.id.tab_activity:
                setDefaultSelected();
                tab_activity.setSelected(true);
                if(fragmentActivity == null){
                    fragmentActivity = new FragmentActivity();
                    fragmentTransaction.add(R.id.fragment_content, fragmentActivity);
                }else{
                    fragmentTransaction.show(fragmentActivity);
                }
                break;

            case R.id.tab_profile:
                setDefaultSelected();
                tab_profile.setSelected(true);
                if(fragmentProfile == null){
                    fragmentProfile = new FragmentProfile();
                    fragmentTransaction.add(R.id.fragment_content, fragmentProfile);
                }else{
                    fragmentTransaction.show(fragmentProfile);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理启动一个新的Activity的过程中回传的值或数据
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0x10 :
                    //TODO
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
