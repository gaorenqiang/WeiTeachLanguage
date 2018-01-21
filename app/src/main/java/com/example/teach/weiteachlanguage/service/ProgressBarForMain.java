package com.example.teach.weiteachlanguage.service;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gaonqiang on 2018/1/12.
 */
public class ProgressBarForMain extends AsyncTask<String, Integer, String> {

    private TextView textInfo=null;
    private ProgressBar bar;
    private Context mContext;

    /*
    根据需要，可以设置不同的控件用于将异步处理的结果进行显示或输出
     */
    public ProgressBarForMain(Context context, TextView textInfo, ProgressBar bar) {
        this.textInfo = textInfo;
        this.bar = bar;
        this.mContext=context;
    }

    /*
    只是用于测试进度条
     */
    public ProgressBarForMain(Context context, ProgressBar bar) {
        this.bar = bar;
        this.mContext=context;
    }

    /**
     * 这里的String参数对应AsyncTask中的第一个参数
     * 这里的String返回值对应AsyncTask的第三个参数
     * 该方法并不运行在UI线程当中，主要用于异步操作，所有在该方法中不能对UI当中的空间进行设置和修改
     * 但是可以调用publishProgress方法触发onProgressUpdate对UI进行操作
     */
    @Override
    protected String doInBackground(String... arg0) {
        System.out.println("====================="+arg0[0]);
        for(int i=0; i<=100; i+=5)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "后台执行完成";
    }

    /**
     * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
     * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
     */

    @Override
    protected void onPostExecute(String result) {
        //如果需要文本通知
        if(textInfo!=null) {
            textInfo.setVisibility(View.VISIBLE);
            textInfo.setText(result);
        }
        bar.setVisibility(View.INVISIBLE);
        Toast.makeText(mContext,"数据加载完毕！",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPreExecute() {
        if(textInfo!=null) {
            textInfo.setVisibility(View.INVISIBLE);
        }
        bar.setVisibility(View.VISIBLE);
    }

    /**
     * 这里的Integer参数对应AsyncTask中的第二个参数
     * 在doInBackground方法当中，每次调用publishProgress方法都会触发onProgressUpdate执行
     * onProgressUpdate是在UI线程中执行，所有可以对UI空间进行操作
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        bar.setProgress(progress);
    }

}

