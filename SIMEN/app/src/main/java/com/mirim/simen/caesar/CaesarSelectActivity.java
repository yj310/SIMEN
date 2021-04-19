package com.mirim.simen.caesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mirim.simen.R;
import com.mirim.simen.caesar.encryption.CaesarEncryptionSelectActivity;
import com.mirim.simen.caesar.decode.CaesarDecodeSelectActivity;

public class CaesarSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_select);


        Button buttonEncryption = (Button)findViewById(R.id.button_caesar_encryption);
        Button buttonDecode = (Button)findViewById(R.id.button_caesar_decode);
        ImageView buttonBack = findViewById(R.id.button_back);



        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_caesar_encryption:
                        Intent intent1 = new Intent(CaesarSelectActivity.this, CaesarEncryptionSelectActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_caesar_decode:
                        Intent intent2 = new Intent(CaesarSelectActivity.this, CaesarDecodeSelectActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.button_back:
                        finish();
                        break;
                }
            }
        };

        buttonEncryption.setOnClickListener(listener);
        buttonDecode.setOnClickListener(listener);
        buttonBack.setOnClickListener(listener);




    }
}