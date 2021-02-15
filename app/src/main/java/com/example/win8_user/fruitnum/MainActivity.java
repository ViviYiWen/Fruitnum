package com.example.win8_user.fruitnum;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    EditText edt1;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findView();
        Button page2=(Button)findViewById(R.id.start);//開始button
        page2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText na=(EditText)findViewById(R.id.editText);
                String name=na.getText().toString();
                if(name.equals("")||name==null){ //Toast.makeText:畫面上彈出一個短暫訊息 Toast.LENGTH_SHORT持續2秒
                    Toast.makeText(MainActivity.this,"姓名不能為空!",Toast.LENGTH_SHORT).show();
                }
                /*if(ifExist(name)){
                    Toast.makeText(MainActivity.this,"姓名已存在!",Toast.LENGTH_SHORT).show();
                }*/
                else{//新增資料
                    //DBHelper dbHelper = new DBHelper(MainActivity.this, "Player", null, 1); //建立Player table
                    DBHelper dbHelper = new DBHelper(MainActivity.this); //建立Player table
                    SQLiteDatabase db = dbHelper.getWritableDatabase(); //getWritableDatabase:取得SQLiteDatabase 物件即可利用該物件進行資料存取
                    Cursor cs = db.query("Player",null,"_PLAYERNAME=?",new String[]{name},null,null,null);
                    if(cs!=null && cs.getCount() >= 1){ //有查詢到資料則不再新增

                    }else{ //無該玩家資料
                        ContentValues content = new ContentValues(); //建立ContentValues物件
                        content.put("_PLAYERNAME", name);
                        content.put("_COIN", 0);
                        db.insert("Player", null, content);
                        db.close();
                    }
                    /*ContentValues content = new ContentValues(); //建立ContentValues物件
                    content.put("_PLAYERNAME", name);
                    content.put("_COIN", 0);
                    db.insert("Player", null, content);
                    db.close();*/

                    findView();//抓使用者姓名
                    Bundle bundle = new Bundle(); //Bundle&Intent 傳遞參數
                    bundle.putString("input", edt1.getText().toString()); //傳遞String物件:input
                    Intent intent=new Intent(); //new一個intent物件，並指定Activity切換的class(setClass)
                    intent.setClass(MainActivity.this,Main2Activity.class);
                    intent.putExtras(bundle); //將Bundle物件傳給intent
                    startActivity(intent);  //開始跳往要去的Activity
                    MainActivity.this.finish(); //結束目前Activity
                }
            }
        });

    }
    public void findView(){
        edt1 = (EditText) this.findViewById(R.id.editText);
    }
    /*public void Click(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("input", edt1.getText().toString());
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("abc", edt1.getText().toString());
        //把字串傳到第二個Activity
        startActivity(intent);
    }*/
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    /*public boolean ifExist(String account)
    {
        DBHelper dbHelper = new DBHelper(this, "Player", null, 1);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("Player",new String[]{"玩家"},"玩家=?",new String[]{account},null,null,null);
        if(cursor!=null&&cursor.getCount()>0)
            return true;
        return false;
    }*/
}
