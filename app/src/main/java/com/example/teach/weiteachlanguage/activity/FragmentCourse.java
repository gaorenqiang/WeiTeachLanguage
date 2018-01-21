package com.example.teach.weiteachlanguage.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.teach.weiteachlanguage.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by gaonqiang on 2017/10/11.
 */

public class FragmentCourse extends Fragment {
    private String content;
    private Button btn_unit_exercise,btn_unit_test,btn_words,btn_quick_review,btn_test;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_course,container,false);
        btn_unit_exercise=view.findViewById(R.id.btn_unit_exercise);
        btn_unit_test=view.findViewById(R.id.btn_unit_test);
        btn_words=view.findViewById(R.id.btn_words);
        btn_quick_review=view.findViewById(R.id.btn_quick_review);
        btn_test=view.findViewById(R.id.btn_test);

        initEvents();

        return view;
    }

    /**
     * 初始化事件
     */
    private void initEvents() {
        btn_unit_exercise.setOnClickListener(new CourseOnclickListener());
        btn_unit_test.setOnClickListener(new CourseOnclickListener());
        btn_words.setOnClickListener(new CourseOnclickListener());
        btn_quick_review.setOnClickListener(new CourseOnclickListener());
        btn_test.setOnClickListener(new CourseOnclickListener());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //处理启动一个新的Activity的过程中回传的值或数据
        if(resultCode == RESULT_OK) {
            Log.i("info","fragment requestCode:"+requestCode);
            switch (requestCode) {
                case 0x10 :
                    String result_value = data.getStringExtra("return_value");
                    Toast.makeText(getActivity(),result_value,Toast.LENGTH_LONG).show();
                    break;
                case 0x11 :
                    String recall_value = data.getStringExtra("recall_value");
                    Toast.makeText(getActivity(),recall_value,Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class CourseOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()) {
                case R.id.btn_unit_exercise :
                    showListDialog();
                    break;
                case R.id.btn_unit_test :
                    intent=new Intent();
                    intent.setClass(getActivity(), AboutActivity.class);
                    //这种情况不会从activity中接收消息
                    startActivity(intent);
                    break;
                case R.id.btn_words :
                    intent=new Intent();
                    intent.setClass(getActivity(), ErrorActivity.class);
                    //这种情况不会从activity中接收消息
                    startActivity(intent);
                    break;
                case R.id.btn_quick_review :
                    intent=new Intent();
                    intent.setClass(getActivity(), ErrorActivity.class);
                    //这种情况不会从activity中接收消息
                    startActivity(intent);
                    break;
                case R.id.btn_test :
                    intent=new Intent();
                    intent.putExtra("age",21);
                    intent.putExtra("name","grq");
                    intent.setClass(getActivity(), CourseOneActivity.class);
                    //这种情况会从跳转的activity中接收消息
                    startActivityForResult(intent,0x11);
                    break;

                default:
                    intent=new Intent();
                    intent.setClass(getActivity(), ErrorActivity.class);
                    //这种情况不会从activity中接收消息
                    startActivity(intent);
                    break;
            }
        }

        private void showListDialog() {
            final String[] items = { "初级","中级","高级"};
            final AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
            dialog.setIcon(R.drawable.ic_grade);
            dialog.setTitle("请选择类别");
            dialog.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent=null;
                    switch (i)
                    {
                        case 0:
                            intent=new Intent();
                            intent.putExtra("level",items[i]);
                            intent.setClass(getActivity(),JuniorUnitsActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent=new Intent();
                            intent.putExtra("level",items[i]);
                            //intent.setClass(getActivity(),MiddleUnitsActivity.class);
                            intent.setClass(getActivity(),ErrorActivity.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent=new Intent();
                            intent.putExtra("level",items[i]);
                            //intent.setClass(getActivity(),AdvancedUnitsActivity.class);
                            intent.setClass(getActivity(),ErrorActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            intent=new Intent();
                            intent.setClass(getActivity(),ErrorActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            });
            dialog.show();
        }
    }
}
