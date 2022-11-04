package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {

    private CircleImageView profile;
    private ImageView btn_profile;
    private TextView btn_skip;
    private CardView btn_set;
    private Uri uri_avatar;
    private Intent login, show;
    private String username, email, password;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        profile = findViewById(R.id.profilePic);
        btn_profile = findViewById(R.id.pinkCircle);
        btn_skip = findViewById(R.id.skip_btn);
        btn_set = findViewById(R.id.set_btn);

        login = getIntent();
        show = new Intent(ProfilePicActivity.this, DashboardActivity.class);
        username = login.getStringExtra("username");
        show.putExtra("username", username);
        password = login.getStringExtra("password");
        show.putExtra("password", password);
        if(login.hasExtra("email")) {
            email = login.getStringExtra("email");
            show.putExtra("email", email);
        }


        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(show);
            }
        });

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(uri_avatar, null)) {
                    show.putExtra("uri_avatar", uri_avatar);
                }
                startActivity(show);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED) {
            Toast.makeText(ProfilePicActivity.this,
                    "Batal menambahkan gambar",
                    Toast.LENGTH_SHORT).show();

            return;
        } else if(requestCode == GALLERY_REQUEST_CODE) {
            if(!Objects.equals(data, null)) {
                try {
                    uri_avatar = data.getData();
                    Bitmap bitmap_avatar = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri_avatar);
                    profile.setImageBitmap(bitmap_avatar);
                    btn_skip.setVisibility(View.INVISIBLE);
                    btn_set.setVisibility(View.VISIBLE);
                } catch (IOException e) {
                    Toast.makeText(ProfilePicActivity.this,
                            "Tidak bisa memuat gambar",
                            Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}