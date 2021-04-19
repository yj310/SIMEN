package com.mirim.simen.caesar.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mirim.simen.R;

public class CaesarEncryptionSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_encryption_select);


        Button buttonShort = (Button)findViewById(R.id.button_short);
        Button buttonLong = (Button)findViewById(R.id.button_long);
        ImageView buttonBack = findViewById(R.id.button_back);



        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_short:
                        Intent intent1 = new Intent(CaesarEncryptionSelectActivity.this, CaesarEncryptionShortActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_long:
                        Intent intent2 = new Intent(CaesarEncryptionSelectActivity.this, CaesarEncryptionShortActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.button_back:
                        finish();
                        break;
                }
            }
        };

        buttonShort.setOnClickListener(listener);
        buttonLong.setOnClickListener(listener);
        buttonBack.setOnClickListener(listener);



    }
}