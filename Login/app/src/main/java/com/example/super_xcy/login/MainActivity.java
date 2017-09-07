package com.example.super_xcy.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private String[][] users = {{"1234@qq.com","00000000"},{"user1@qq.com","11111111"},{"user2","22222222"},
            {"user3","33333333"},{"user4","44444444"},{"user5","55555555"},
            {"user6","66666666"},{"user7","77777777"},{"user8","88888888"},
            {"user9","99999999"}};

    private EditText login_edit_account;
    private EditText login_edit_passport;
    private Button login_btn_login;
    private boolean equals;
    private boolean aBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildControl();
        setOnClickListener();
    }

    private  void buildControl() {
        login_edit_account = (EditText) findViewById(R.id.login_edit_account);
        login_edit_passport = (EditText) findViewById(R.id.login_edit_pwd);
        login_btn_login = (Button) findViewById(R.id.login_btn_login);
    }

    private void setOnClickListener() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserClicked(v);
            }
        };
            login_edit_account.setOnClickListener(listener);
            login_edit_passport.setOnClickListener(listener);
            login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        });
    }
    private void ButtonClicked(View v) {
        String account = login_edit_account.getText().toString();
        String passport = login_edit_passport.getText().toString();
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[i].length; j++) {
                equals = users[i][0].equals(account);
                aBoolean = users[i][1].equals(passport);
                if (equals && aBoolean) {
                    Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
                } else
            Toast.makeText(this, "用户名或密码不存在，请重新输入！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void UserClicked(View v) {
        String passport = login_edit_passport.getText().toString();
        String account = login_edit_account.getText().toString();
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+" +
                "(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(account);

        if (account.equals("")) {
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }else if (!matcher.matches()) {
            Toast.makeText(this,"邮箱格式有误，请输入正确的邮箱格式",Toast.LENGTH_SHORT).show();
        }
        if (passport.equals("")) {
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();

        }else if (passport.length() >12 || passport.length() < 8) {
            Toast.makeText(this,"请确保密码长度在8~12位",Toast.LENGTH_SHORT).show();
        }
    }


}
