package com.example.win8_user.fruitnum;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    int mons;
    TextView t2;
    // int num1 =1, num2=2, num3=3, result=0;
    int result=0;
     int num1 = (int)(Math.random()*10);//隨機出3個數字
     int num2 = (int)(Math.random()*10);
     int num3 = (int)(Math.random()*10);
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findView();//抓使用者姓名

        Bundle bundle = this.getIntent().getExtras();
        String s = bundle.getString("input");
        t1.setText(s);


        while(num2==num1) num2 = (int)(Math.random()*10);
        while(num3==num2 || num3==num1) num3= (int)(Math.random()*10);
        ShowDialog(num1,num2,num3); //數字解答
        Button sure = (Button)findViewById(R.id.sure);
        ImageButton money = (ImageButton)findViewById(R.id.money);
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView hints = (TextView)findViewById(R.id.hints);
                TextView mon = (TextView)findViewById(R.id.mon);
                LinearLayout layout = (LinearLayout) findViewById(R.id.app); //app->hints區塊
                mons=Integer.parseInt(mon.getText().toString());
                mons=mons-80;
                int ask = (int)(Math.random()*3);//select index number
                if(ask==0){
                    int n=num1;
                    hints.setText("第一個數字為:"+Integer.toString(n));
                    mon.setText(Integer.toString(mons));
                    layout.setVisibility(View.VISIBLE);
                }
                if(ask==1){
                    int n=num2;
                    hints.setText("第二個數字為:"+Integer.toString(n));
                    mon.setText(Integer.toString(mons));
                    layout.setVisibility(View.VISIBLE);
                }
                if(ask==2){
                    int n=num3;
                    hints.setText("第三個數字為:"+Integer.toString(n));
                    mon.setText(Integer.toString(mons));
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Result(num1,num2,num3);

                if(result==1){//全部答對
                    findView();//抓使用者姓名
                    t2 = (TextView) findViewById(R.id.mon); //抓取剩於金幣數
                    int upToDbCoin = 0; //要update至DB的金幣數量
                    String flag = "N"; //是否更新DB資料
                    DBHelper dbHelper = new DBHelper(Main4Activity.this);
                    SQLiteDatabase db=dbHelper.getWritableDatabase();
                    Cursor cs = db.query("Player",null,"_PLAYERNAME=?",new String[]{t1.getText().toString()},null,null,null); //search玩家資料
                    if(cs!=null && cs.getCount() >= 1){ //有查詢到資料(比對金幣數)
                        int rowNum = cs.getCount(); //比數
                        if(rowNum!=0){
                            cs.moveToFirst(); //指標移至第一筆
                            String coin = cs.getString(2); //取得該玩家金幣數
                            if(coin!=null && coin!=""){
                                int coinDb = Integer.parseInt(coin); //玩家金幣數(db資料)
                                int uiCoin = Integer.parseInt(t2.getText().toString()); //UI剩餘金幣數
                                if(uiCoin>coinDb){ //剩餘金幣數大於原本資料庫金幣數->則update至資料庫中,否則不更新資料
                                    upToDbCoin = uiCoin;
                                    flag = "Y";
                                }else{
                                    upToDbCoin = coinDb;
                                    flag = "N";
                                }
                            }
                        }
                    }
                    if(flag=="Y"){
                        ContentValues values = new ContentValues();
                        values.put("_COIN", Integer.toString(upToDbCoin)); //values.put("_COIN", t2.getText().toString());
                        db.update("Player", values, "_PLAYERNAME = ?", new String[] {t1.getText().toString()});
                    }
                    //ContentValues values = new ContentValues();
                    //values.put("_COIN", Integer.toString(upToDbCoin)); //values.put("_COIN", t2.getText().toString());
                    //db.update("Player", values, "_PLAYERNAME = ?", new String[] {t1.getText().toString()});
                    db.close();
                    dbHelper.close();

                    Intent intent=new Intent();
                    intent.setClass(Main4Activity.this,Main5Activity.class);
                    startActivity(intent);
                    Main4Activity.this.finish();

                }

            }
        });

    }
    public void findView(){
        t1=(TextView)findViewById(R.id.textView7);

    }

    //@Override
    public int Result(int num1, int num2, int num3){
        int grape=0, apple=0;
        EditText ed1 = (EditText)findViewById(R.id.editText2);
        EditText ed2 = (EditText)findViewById(R.id.editText3);
        EditText ed3 = (EditText)findViewById(R.id.editText4);
        String re1, re2;
        TextView A = (TextView)findViewById(R.id.apple);
        TextView G = (TextView)findViewById(R.id.grape);
        int a = Integer.parseInt(ed1.getText().toString());
        int b = Integer.parseInt(ed2.getText().toString());
        int c = Integer.parseInt(ed3.getText().toString());
            grape=0;
            apple=0;
            if(a==num1 && b==num2 && c==num3)
                return 1;
            if(a==num2 || a==num3) grape++;
            if(b==num1 || b==num3) grape++;
            if(c==num2 || c==num1) grape++;
            if(a==num1) apple++;
            if(b==num2) apple++;
            if(c==num3) apple++;
            re1 = Integer.toString(apple);
            re2 = Integer.toString(grape);
            A.setText(re1);
            G.setText(re2);
            ed1 = (EditText)findViewById(R.id.editText2);
            ed2 = (EditText)findViewById(R.id.editText3);
            ed3 = (EditText)findViewById(R.id.editText4);
            a = Integer.parseInt(ed1.getText().toString());
            b = Integer.parseInt(ed2.getText().toString());
            c = Integer.parseInt(ed3.getText().toString());
        return 0;

    }
    public void ShowDialog(int num1, int num2, int num3){
        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
        builder.setTitle("Answer");
        builder.setMessage(Integer.toString(num1)+Integer.toString(num2)+Integer.toString(num3));
        //builder.setPositiveButton("OK",builder.show());
        builder.show();
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
