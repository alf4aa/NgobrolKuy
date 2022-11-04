package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgetPassActivity extends AppCompatActivity {

    private ImageView btn_back;
    private CardView btn_submit;
    private Intent submit, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        btn_submit = findViewById(R.id.submit_btn);
        btn_back = findViewById(R.id.back_btn);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back = new Intent(ForgetPassActivity.this, LoginActivity.class);

                startActivity(back);
            }
        });
    }
}