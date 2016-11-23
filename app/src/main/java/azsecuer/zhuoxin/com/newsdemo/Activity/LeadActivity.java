package azsecuer.zhuoxin.com.newsdemo.Activity;

import android.animation.Animator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import azsecuer.zhuoxin.com.newsdemo.Adapter.LeadViewPageAdapter;
import azsecuer.zhuoxin.com.newsdemo.R;
import azsecuer.zhuoxin.com.newsdemo.SharedpreferencesUtil.SharedpreferencesUtil;

public class LeadActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<View> views;
    private Button button;
    private Animation animation;
    private LeadViewPageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        viewPager= (ViewPager) findViewById(R.id.lead_viewpaper);
        button= (Button) findViewById(R.id.lead_bt);
        setdata();
    }

    private void setdata(){
        views=new ArrayList<>();
        views.add(getLayoutInflater().inflate(R.layout.lead_one,null));
        views.add(getLayoutInflater().inflate(R.layout.lead_two,null));
        views.add(getLayoutInflater().inflate(R.layout.lead_three,null));
        //设置动画
        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        button.setAnimation(animation);
        //动画监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

          //viewpager的adapter
          adapter=new LeadViewPageAdapter(views);
        Log.i("11111",adapter.toString()+views.size());
          viewPager.setAdapter(adapter);
          viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
              @Override
              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                  if(position==2){
                      button.setVisibility(View.VISIBLE);
                  }else {
                      button.setVisibility(View.GONE);
                  }
              }

              @Override
              public void onPageSelected(int position) {

              }

              @Override
              public void onPageScrollStateChanged(int state) {

              }
          });
        //按钮监听  跳转并保存版本号
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil sharedpreferencesUtil=new SharedpreferencesUtil(LeadActivity.this);
                sharedpreferencesUtil.savedata(getAppVersionName());
                startActivity(LoadingActivity.class);
                finish();
            }
        });
    }


}
