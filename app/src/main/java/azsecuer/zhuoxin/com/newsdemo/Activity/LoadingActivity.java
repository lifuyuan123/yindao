package azsecuer.zhuoxin.com.newsdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import azsecuer.zhuoxin.com.newsdemo.R;
import azsecuer.zhuoxin.com.newsdemo.SharedpreferencesUtil.SharedpreferencesUtil;

public class LoadingActivity extends BaseActivity implements Animation.AnimationListener{
     private ImageView imageView;
     private Animation animation;
     private SharedpreferencesUtil sharedpreferencesUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //在设置布局前先获取版本号判断是否进入引导页面
        sharedpreferencesUtil=new SharedpreferencesUtil(this);
        String versionName=sharedpreferencesUtil.getdata();
        //条件是第一次进入和版本号不同
        if(versionName.equals("")||!versionName.equals(getAppVersionName())){
            startActivity(LeadActivity.class);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        imageView= (ImageView) findViewById(R.id.iv_loading);
        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        animation.setAnimationListener(this);
        imageView.setAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
          startActivity(HomeActivity.class);
          finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
