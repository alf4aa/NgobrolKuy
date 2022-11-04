package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class DashboardActivity extends AppCompatActivity {

    private ImageView btn_settings;
    private Intent data, settings;
    private String username, email, password;
    private Uri uri_avatar;
    private FloatingActionButton keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_settings = findViewById(R.id.settings_btn);
        keluar = findViewById(R.id.fabKeluar);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = getIntent();

                settings = new Intent(DashboardActivity.this, SettingsActivity.class);

                username = data.getStringExtra("username");
                settings.putExtra("username", username);

                password = data.getStringExtra("password");
                settings.putExtra("password", password);

                email = data.getStringExtra("email");
                settings.putExtra("email", email);

                if(data.hasExtra("uri_avatar")) {
                    uri_avatar = data.getParcelableExtra("uri_avatar");
                    settings.putExtra("uri_avatar", uri_avatar);
                }

                startActivity(settings);
            }

        });
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        }

    }
