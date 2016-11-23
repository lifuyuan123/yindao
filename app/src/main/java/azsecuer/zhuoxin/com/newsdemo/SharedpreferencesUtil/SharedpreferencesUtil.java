package azsecuer.zhuoxin.com.newsdemo.SharedpreferencesUtil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/11/23.
 */

public class SharedpreferencesUtil {
    private Context context;
    private String old1="old";
    private String new1="new";

    public SharedpreferencesUtil(Context context) {
        this.context = context;
    }
    //保存版本信息
    public void savedata(String name){
        SharedPreferences sharedPreferences=context.getSharedPreferences(old1,Context.MODE_APPEND);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("versionName",name);
        editor.commit();//提交信息
    }
    //获取版本信息
    public String getdata(){
        return context.getSharedPreferences(old1,Context.MODE_APPEND).getString("versionName","");
    }
}
