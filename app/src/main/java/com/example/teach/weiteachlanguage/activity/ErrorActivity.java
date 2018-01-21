package com.example.teach.weiteachlanguage.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teach.weiteachlanguage.R;

/**
 * Created by gaonqiang on 2018/1/14.
 */

public class ErrorActivity extends AppCompatActivity {
    private  static String TAG="JuniorUnitsActivity",level="";
    //UI对象声明
    private Button btn_back,btn_cancell,btn_next;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_error);
        getParametersFromStartActivity();
        initViews();
        initEvents();
    }

    private void getParametersFromStartActivity(){}

    private void initViews() {
        btn_back=(Button)this.findViewById(R.id.btn_back);
        btn_cancell=(Button)this.findViewById(R.id.btn_cancell);
        btn_cancell.setVisibility(View.INVISIBLE);
        btn_next=(Button)this.findViewById(R.id.btn_next);
        btn_next.setVisibility(View.INVISIBLE);
        tv_title=(TextView)this.findViewById(R.id.tv_title);
        tv_title.setText(R.string.error_title);
    }

    private void initEvents() {
        btn_back.setOnClickListener(new ErrorOnClickListener());
    }

    class ErrorOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_back:
                    finish();
                    break;
            }
        }
    }
}
