package com.mirim.simen.caesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mirim.simen.R;
import com.mirim.simen.caesar.encryption.CaesarEncryptionSelectActivity;
import com.mirim.simen.caesar.decode.CaesarDecodeSelectActivity;
import com.mirim.simen.playfair.PlayfairSelectActivity;
import com.mirim.simen.playfair.decode.PlayfairDecodeSelectActivity;
import com.mirim.simen.playfair.encryption.PlayfairEncryptionSelectActivity;

public class CaesarSelectActivity extends AppCompatActivity {

    LinearLayout buttonEncryption;
    LinearLayout buttonDecode;
    ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_select);

        setButton();

    }

    public void setButton(){
        buttonEncryption = findViewById(R.id.button_encryption);
        buttonDecode = findViewById(R.id.button_decode);
        buttonBack = findViewById(R.id.button_back);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_encryption:
                        Intent intent1 = new Intent(CaesarSelectActivity.this, CaesarEncryptionSelectActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.button_decode:
                        Intent intent2 = new Intent(CaesarSelectActivity.this, CaesarDecodeSelectActivity.class);
                        startActivity(intent2);
                        finish();
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