package com.example.win8_user.fruitnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements View.OnTouchListener{

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Button page3=(Button)findViewById(R.id.again);
        page3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(Main5Activity.this,MainActivity.class);
                startActivity(intent);
                Main5Activity.this.finish();

            }
        });

        Button page6=(Button)findViewById(R.id.honor);
        page6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent=new Intent();
                intent.setClass(Main5Activity.this,Main6Activity.class);
                startActivity(intent);
                Main5Activity.this.finish();

            }
        });

        Button Exit = (Button)findViewById(R.id.end);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
    /*public void findView(){
        t1=(TextView)findViewById(R.id.textView15);
    }*/
    /*public void onClick(View v){
        if(v==findViewById(R.id.start)){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            MainActivity.this.finish();
        }
    }*/
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
