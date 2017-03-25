package com.dujiang.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    //倒计时控件声明

    private TextView textView ;

    private int count = 5 ;

    private Animation animation ;
    // private Button btnGoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.tv_advt);

        //先声明Handler，再书写下面的延迟。

        handler.sendEmptyMessageDelayed(0,500) ;

        animation= AnimationUtils.loadAnimation(this,R.anim.animation_text);


        new Handler().sendEmptyMessageDelayed(0,500);
        //5秒钟自动进入登录界面
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);*/


       /* this.btnGoLogin = (Button) findViewById(R.id.btn_go_login);

        this.btnGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // 设置跳转参数
                intent.setClass(SplashActivity.this, MainActivity.class);
                // 进行跳转
                startActivity(intent);
                // 销毁当前Activity
                finish();
            }
        });*/
         /*   @Override
            public void onClick(View v) {
               // String msg = "你好呀";
                // 跳转到主界面
                // 实例化意图
                Intent intent = new Intent();
                // 设置跳转参数
                intent.setClass(FirstActivity.this, LoginActivity.class);

                // 放置传递的数据
               // intent.putExtra("message",msg);

                // 进行跳转
                startActivity(intent);
                // 销毁当前Activity
                finish();
            }
        });*/
    }
    private int getCount(){
        count-- ;
        if (count == 0){
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return count;
    }
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
            if (msg.what == 0){
                textView.setText(getCount()+"");
                handler.sendEmptyMessageDelayed(0,500) ;
                animation.reset();
                textView.startAnimation(animation);
            }
        }
    };

}
