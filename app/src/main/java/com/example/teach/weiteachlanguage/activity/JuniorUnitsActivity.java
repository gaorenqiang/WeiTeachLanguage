package com.example.teach.weiteachlanguage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teach.weiteachlanguage.R;
import com.example.teach.weiteachlanguage.adapter.ListUnitsAdapter;
import com.example.teach.weiteachlanguage.bean.ListUnits;

import java.util.ArrayList;
import java.util.List;

public class JuniorUnitsActivity extends BaseActivity{

    private  static String TAG="JuniorUnitsActivity",level="";
    //UI对象声明
    private ListView lv_course_junior=null;
    private Button btn_back,btn_cancell,btn_next;
    private TextView tv_title;
    private List<ListUnits> mData=null;
    private ListUnitsAdapter listUnitsAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_units_junior);
        getParametersFromStartActivity();
        initViews();
        initEvents();
    }

    private void getParametersFromStartActivity() {
        //获得传值对象Activity
        Intent intent=getIntent();
        level=intent.getStringExtra("level");
        Toast.makeText(this,"course level is"+level,Toast.LENGTH_SHORT).show();
        Log.i(TAG, "选择的课程类别为："+level+"!");
    }

    //UI组件初始化
    private void initViews() {
        btn_back=(Button)this.findViewById(R.id.btn_back);
        btn_cancell=(Button)this.findViewById(R.id.btn_cancell);
        btn_cancell.setVisibility(View.INVISIBLE);
        btn_next=(Button)this.findViewById(R.id.btn_next);
        btn_next.setVisibility(View.INVISIBLE);
        tv_title=(TextView) this.findViewById(R.id.tv_title);
        tv_title.setText(level);
        lv_course_junior=(ListView)this.findViewById(R.id.lv_course_junior);
        mData= new ArrayList<>(10);
        mData.add(new ListUnits("第一单元","Guten Tag!",false));
        mData.add(new ListUnits("第二单元","Woher kommst du?",true));
        mData.add(new ListUnits("第三单元","Meine Familie!",false));
        mData.add(new ListUnits("第四单元","Hello World!",false));
        listUnitsAdapter=new ListUnitsAdapter(mData,this);
        lv_course_junior.setAdapter(listUnitsAdapter);
    }

    //UI组件与事件绑定
    private void initEvents() {
        btn_back.setOnClickListener(new JuniorUnitsOnClickListener());
        lv_course_junior.setOnItemClickListener(new JuniorUnitsOnItemClickListener());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    class JuniorUnitsOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back://顶部标题也要相应的发生改变
                    finish();
                    break;

            }
        }
    }


    class JuniorUnitsOnItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int position, long id){
            Toast.makeText(JuniorUnitsActivity.this, "listview的item被点击了！", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent();
            switch (position) {
                case 0:
                    intent.setClass(JuniorUnitsActivity.this, CourseOneActivity.class);
                    startActivity(intent);
                    break;
                default:
                    intent.setClass(JuniorUnitsActivity.this, ErrorActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
