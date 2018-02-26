package com.silent.fiveghost.guide.tools;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.silent.fiveghost.guide.ui.activitys.LoginActivity;

import java.util.regex.Pattern;

/**
 * Created by 84682 on 2018/1/26.
 */

public class Tools {

    //手机号表达式
    private final static Pattern phone_pattern = Pattern.compile("^(13|15|18)\\d{9}$");
    /**
     * 验证手机号是否正确
     * @param phone 手机号码
     * @return boolean
     */
    public static boolean isPhone(String phone) {
        return phone_pattern.matcher(phone).matches();
    }

    public static void setAlpha(Window window, AppCompatActivity activity){
        View decorview = window.getDecorView();
        if(Build.VERSION.SDK_INT>=21){//5.0以上的系统支持
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;//表示让应用主题内容占据系统状态栏的空间
            decorview.setSystemUiVisibility(option);
            window.setStatusBarColor(Color.parseColor("#00ffffff"));//设置状态栏颜色为透明
            ActionBar actionBar  = activity.getSupportActionBar();
            actionBar.hide();
        }
    }
    private static ProgressDialog dialog;

    /**
     * 显示AlertDialog
     *
     * @param context 上下文
     * @param title   标题
     * @param message 内容
     */
    public static void showAlertDialog(Context context, String title, String message) {
        dialog = ProgressDialog.show(context, title, message, true, false, null);
    }

    /**
     * 取消显示AlertDialog
     */
    public static void cancleAlertDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    public static void showNetWork(Context context, String message,
                                   String posiTiveText, DialogInterface.OnClickListener posiTivelistener) {

        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(posiTiveText, posiTivelistener)
                .show();

    }

    public static int queryWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();//屏幕宽度
        return width;
    }
    public static int queryHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();//屏幕高度
        return height;
    }

    /**
     *  获取IMEI码
     * @param context
     * @return IMEI码
     */
    @SuppressLint("MissingPermission")
    public static String getPhoneIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "cuo";
            }
            return telephonyManager.getDeviceId();
        } else {
            return "cuo";

        }
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
