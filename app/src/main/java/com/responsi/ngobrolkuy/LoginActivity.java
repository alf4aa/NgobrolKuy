package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username, et_password;
    private String username, password, acc_user, acc_pass, email;
    private CardView btn_login;
    private TextView btn_register, btn_forgetpass;
    private Intent login, register, account, forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.username_et);
        et_password = findViewById(R.id.password_et);

        btn_login = findViewById(R.id.login_btn);
        btn_register = findViewById(R.id.register_btn);
        btn_forgetpass = findViewById(R.id.forgetpass_btn);

        account = getIntent();

        if(!Objects.equals(account, null)) {
            acc_user = account.getStringExtra("username");
            acc_pass = account.getStringExtra("password");
            email = account.getStringExtra("email");
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account = getIntent();

                if(!Objects.equals(account, null)) {
                    acc_user = account.getStringExtra("username");
                    acc_pass = account.getStringExtra("password");
                    email = account.getStringExtra("email");
                }

                username = et_username.getText().toString();
                password = et_password.getText().toString();

                if(!Objects.equals(account, null)) {
                    if(Objects.equals(username, acc_user) && Objects.equals(password, acc_pass)) {
                        login = new Intent(LoginActivity.this, ProfilePicActivity.class);
                        login.putExtra("username", username);
                        login.putExtra("password", password);
                        login.putExtra("email", email);
                        startActivity(login);
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Akun anda tidak terdaftar",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Silahkan Registrasi Dahulu",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        btn_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetpass = new Intent(LoginActivity.this, ForgetPassActivity.class);
                startActivity(forgetpass);
            }
        });
    }
}