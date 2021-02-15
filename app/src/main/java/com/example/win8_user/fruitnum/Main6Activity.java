package com.example.win8_user.fruitnum;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class
Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        int count=0;
        /*去資料庫抓資料，並顯示在listView上面*/
        //ListView listView = (ListView)findViewById(R.id.listView);
       /* MyDBHelper myDBHelper = new MyDBHelper(this, "玩家", null , 1);
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        Cursor cursor = db.query("玩家", new String[]{"玩家" ,, "金幣數"}, null, null, null, null, "金幣數desc");
        cursor.moveToFirst();
        /*if(cursor!=null&&cursor.getCount()>=0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[]{"player","coins"},new int[]{Fruir})
        }*/
        /*cursor.requery();
        listView.setAdapter(adapter);
        listView.setOnClickListener(itemClickListener);*/

        DBHelper myDBHelper = new DBHelper(this);
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        Cursor cursor = db.query("Player", new String[]{"_PLAYERNAME ,_COIN"}, null, null, null, null, "_COIN  desc");
        cursor.moveToFirst();
        TextView textView1 = (TextView) findViewById(R.id.No1);
        TextView textView2 = (TextView) findViewById(R.id.No2);
        TextView textView3 = (TextView) findViewById(R.id.No3);
        TextView textView4 = (TextView) findViewById(R.id.No4);
        TextView textView5 = (TextView) findViewById(R.id.No5);


        for(int i=0;i<cursor.getCount();i++,cursor.moveToNext()){
            if(count==5)
                break;
            if(i==0){
                textView1.setText("姓名:  "+cursor.getString(0)+"\t"+"分數:  "+cursor.getInt(1));
                count++;
            }
            if(i==1){
                textView2.setText("姓名:  "+cursor.getString(0)+"\t"+"分數:  "+cursor.getInt(1));
                count++;
            }
            if(i==2){
                textView3.setText("姓名:  "+cursor.getString(0)+"\t"+"分數:  "+cursor.getInt(1));
                count++;
            }
            if(i==3){
                textView4.setText("姓名:  "+cursor.getString(0)+"\t"+"分數:  "+cursor.getInt(1));
                count++;
            }
            if(i==4){
                textView5.setText("姓名:  "+cursor.getString(0)+"\t"+"分數:  "+cursor.getInt(1));
                count++;
            }
        }
        /*db = openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        cursor = db.rawQuery("select '玩家, 金幣數 from Player",null);/**/
        /*if (cursor != null && cursor.getCount() >= 0) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[]{"玩家", "金幣數"}, new int[]{android.R.id.text1, android.R.id.text2}, 0);
            listView.setAdapter(adapter);
        }*/

        Button Return = (Button)findViewById(R.id.button8);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Main6Activity.this,Main5Activity.class);
                startActivity(intent);
                Main6Activity.this.finish();
            }
        });
    }
    //@Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
