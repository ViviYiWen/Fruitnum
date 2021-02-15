package com.example.win8_user.fruitnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnTouchListener {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        findView();//抓使用者姓名

        Bundle bundle = this.getIntent().getExtras(); //接收資料
        String s = bundle.getString("input");
        t1.setText(s);

        ImageButton page4=(ImageButton)findViewById(R.id.easy);
        ImageButton page7=(ImageButton)findViewById(R.id.normal);
        ImageButton page8=(ImageButton)findViewById(R.id.hard);
        page4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                findView();//抓使用者姓名

                Intent intent=new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("input", t1.getText().toString());
                intent.setClass(Main3Activity.this,Main4Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Main3Activity.this.finish();


            }
        });
        page7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                findView();//抓使用者姓名
                Intent intent=new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("input", t1.getText().toString());
                intent.setClass(Main3Activity.this,Main7Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Main3Activity.this.finish();

            }
        });
        page8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                findView();//抓使用者姓名
                Intent intent=new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("input", t1.getText().toString());
                intent.setClass(Main3Activity.this,Main8Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Main3Activity.this.finish();

            }
        });

    }
    public void findView(){
         t1=(TextView)findViewById(R.id.textView2);
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
