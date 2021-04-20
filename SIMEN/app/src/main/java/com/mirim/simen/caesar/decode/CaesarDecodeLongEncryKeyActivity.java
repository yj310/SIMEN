package com.mirim.simen.caesar.decode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirim.simen.R;

public class CaesarDecodeLongEncryKeyActivity extends AppCompatActivity {

    ImageView buttonBack;
    TextView buttonAnotherKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_decode_long_encry_key);

        setButton();
    }

    public void setButton(){
        buttonBack = findViewById(R.id.button_back);
        buttonAnotherKey = findViewById(R.id.button_another_key);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_back:
                        finish();
                        break;
                    case R.id.button_another_key:
                        Intent intent = new Intent(CaesarDecodeLongEncryKeyActivity.this, CaesarDecodeLongActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                }
            }
        };

        buttonBack.setOnClickListener(listener);
        buttonAnotherKey.setOnClickListener(listener);

    }
}