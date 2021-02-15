package com.example.win8_user.fruitnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener {

    TextView name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
        //接收姓名
        Bundle bundle = this.getIntent().getExtras(); //getIntent().getExtras()->接收資料
        String s = bundle.getString("input");
        name1.setText(s);



        ImageButton page3=(ImageButton)findViewById(R.id.game);
        page3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                findView();//抓使用者姓名
                Bundle bundle = new Bundle();
                bundle.putString("input", name1.getText().toString());
                Intent intent=new Intent();
                intent.setClass(Main2Activity.this,Main3Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                Main2Activity.this.finish();

            }
        });

    }
    public void findView(){
        name1 = (TextView) this.findViewById(R.id.name);
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
