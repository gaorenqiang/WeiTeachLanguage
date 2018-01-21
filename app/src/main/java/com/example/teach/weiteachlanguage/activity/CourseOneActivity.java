package com.example.teach.weiteachlanguage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teach.weiteachlanguage.R;
import com.example.teach.weiteachlanguage.service.ProgressBarForCourseOne;

/**
 * Created by gaonqiang on 2018/1/6.
 */

public class CourseOneActivity extends AppCompatActivity {

    private Button toolbar_back,toolbar_next;
    private TextView toolbar_title,tv_desc;
    private ProgressBar bar;
    private String TAG="CourseOneActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_course_one);
        getParametersFromStartActivity();
        initView();
        initEvents();
        loadingData();
    }

    private void getParametersFromStartActivity() {
        //获得传值对象Activity
        Intent intent=getIntent();
        int age=intent.getIntExtra("age",0);
        String name=intent.getStringExtra("name");
        Toast.makeText(this,"passed name is"+name+",age is "+age,Toast.LENGTH_SHORT).show();
        Log.i(TAG, "传递的值为："+name + ", " + age + "!");
    }

    /*
     *初始化布局
     */
    private void initView() {
        toolbar_back=(Button)this.findViewById(R.id.toolbar_back);
        toolbar_next=(Button)this.findViewById(R.id.toolbar_next);
        toolbar_title=(TextView)this.findViewById(R.id.toolbar_title);
        tv_desc=(TextView)this.findViewById(R.id.tv_desc);
        bar=(ProgressBar)this.findViewById(R.id.bar);
        bar.setProgress(0);
        toolbar_title.setText("词汇练习");
    }

    private  void  loadingData(){
        ProgressBarForCourseOne barTask = new ProgressBarForCourseOne(this,tv_desc,bar);
        barTask.execute("start");
    }

    /*
     *绑定事件
     */
    private void initEvents() {
        toolbar_back.setOnClickListener(new CourseOnclickListener());
    }

    private class CourseOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toolbar_back :
                    Intent intent=new Intent();
                    intent.putExtra("recall_value","successful deliver value!");
                    setResult(RESULT_OK,intent);
                    finish();
                    break;

                default:
                    break;
            }
        }
    }

}
