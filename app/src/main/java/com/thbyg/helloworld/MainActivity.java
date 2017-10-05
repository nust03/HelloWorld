package com.thbyg.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.*;

import java.io.DataOutputStream;
import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {

    String tag = "Lifecycle Step";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In he onRestart event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In he onResume event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In he onStop event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In he onPause event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In he onDestroy event");
    }

    public void DisplayToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    public void btn_Login_Click(View view) {
        EditText edit_text = (EditText) findViewById(R.id.et_UserName);
        String username = edit_text.getText().toString().trim();
        if(username.length() == 0) {
            DisplayToast("请输入用户名和密码。");
        }
        else {
            DisplayToast("您输入的用户名是：" + username);
        }
    }

    /**
     * 执行shell命令
     *
     * @param cmd
     */
    private void execShellCmd(String cmd) {

        try {
            // 申请获取root权限，这一步很重要，不然会没有作用
            Process process = Runtime.getRuntime().exec("su");
            // 获取输出流
            OutputStream outputStream = process.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(
                    outputStream);
            dataOutputStream.writeBytes(cmd);
            dataOutputStream.flush();
            dataOutputStream.close();
            outputStream.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void btn_Moni_Input_Click(View view) {
        EditText edit_text = (EditText) findViewById(R.id.et_UserName);
        String username = edit_text.getText().toString().trim();
        execShellCmd(username);
    }
}
