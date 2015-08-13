package com.example.kyounghee.oz_now_ver1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class OZ_nowwActivity extends Activity {
    private EditText contentEt;
    private Button todoWriteBtn;
    private Button noteWriteBtn;
    private LinearLayout linearLayout;
    private EditText todoEt;
    private EditText noteEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oz_write);
        //contentEt=(EditText)findViewById(R.id.editText_todo);
        Button saveBtn=(Button)findViewById(R.id.button_save);
        todoWriteBtn=(Button)findViewById(R.id.button_todoWrite);
        noteWriteBtn=(Button)findViewById(R.id.button_noteWrite);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
                // 자장 후 전체 리스트로 돌아가도록 설정
                Intent intent=new Intent(OZ_nowwActivity.this,AllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        todoWriteBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 linearLayout=(LinearLayout)findViewById(R.id.dynamicArea);
                 todoEt=new EditText(OZ_nowwActivity.this);
                 todoEt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                 linearLayout.addView(todoEt);
             }
         });
        noteWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout=(LinearLayout)findViewById(R.id.dynamicArea);
                noteEt=new EditText(OZ_nowwActivity.this);
                noteEt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(noteEt);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();


    }

    public void saveFile(){
        /*String content=null;
        if(todoEt.getText().toString()==null){
            content=noteEt.getText().toString();
        }else{
            content=todoEt.getText().toString();
        }*/
        String content=contentEt.getText().toString();
        try {
            FileOutputStream fos=openFileOutput(content,MODE_PRIVATE);// 후에 카테고리 네임으로
            PrintWriter pw= new PrintWriter(fos);
            pw.println(content);
            pw.close();
            Toast.makeText(this,"todo 저장 ok",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
