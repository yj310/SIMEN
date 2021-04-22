package com.mirim.simen.playfair.decode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mirim.simen.R;
import com.mirim.simen.caesar.encryption.CaesarEncryptionSelectActivity;
import com.mirim.simen.caesar.encryption.CaesarEncryptionShortActivity;

public class PlayfairDecodeSelectActivity extends AppCompatActivity {

    LinearLayout buttonShort;
    LinearLayout buttonLong;
    ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair_decode_select);

        setButton();
    }

    public void setButton() {

        buttonShort = findViewById(R.id.button_short);
        buttonLong = findViewById(R.id.button_long);
        buttonBack = findViewById(R.id.button_back);



        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_short:
                        Intent intent1 = new Intent(PlayfairDecodeSelectActivity.this, PlayfairDecodeShortActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.button_long:
                        Intent intent2 = new Intent(PlayfairDecodeSelectActivity.this, PlayfairDecodeLongActivity.class);
                        startActivity(intent2);
                        finish();
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