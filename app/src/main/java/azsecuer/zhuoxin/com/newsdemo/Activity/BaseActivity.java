package azsecuer.zhuoxin.com.newsdemo.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/11/23.
 */

public  class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }


    //跳转
    protected void startActivity(Class<?> aclass){
        Intent intent=new Intent(this,aclass);
        startActivity(intent);
    }
    //获取版本名
    protected String getAppVersionName(){
        String name="";
        try {
            name=getPackageManager().getPackageInfo(getPackageName(),0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return name;
    }
    //获取版本号
    protected int getAppVersionCode(){
        int code=0;
        try {
            code=getPackageManager().getPackageInfo(getPackageName(),0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }
}
