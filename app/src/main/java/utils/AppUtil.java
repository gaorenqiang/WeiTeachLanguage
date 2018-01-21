package utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by gaonqiang on 2017/10/10.
 */

public class AppUtil {
    //获取屏幕像素大小
    public static int getAppDimesion(Activity activity)
    {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width=metric.widthPixels;
        return width;
    }

    //获取屏幕像素密度
    public  static float getScreenDensity(Activity activity){
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        float density = metric.density;
        return density;
    }
}
