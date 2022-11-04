package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username, et_email, et_password, et_conf_pass;
    private String username, email, password, conf_pass;
    private CardView btn_register;
    private TextView btn_login;
    private Intent register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.username_et);
        et_email = findViewById(R.id.email_et);
        et_password = findViewById(R.id.password_et);
        et_conf_pass = findViewById(R.id.conf_pass_et);

        btn_register = findViewById(R.id.register_btn);
        btn_login = findViewById(R.id.login_btn);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString();
                email = et_email.getText().toString();
                password = et_password.getText().toString();
                conf_pass = et_conf_pass.getText().toString();

                if(Objects.equals(password, conf_pass)) {
                    register = new Intent(RegisterActivity.this, LoginActivity.class);

                    register.putExtra("username", username);
                    register.putExtra("email", email);
                    register.putExtra("password", password);

                    startActivity(register);
                } else {
                    Toast.makeText(RegisterActivity.this,
                            "konfirmasi password tidak sesuai",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(login);
            }
        });

    }
}