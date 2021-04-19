package com.mirim.simen.single;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mirim.simen.R;
import com.mirim.simen.playfair.PlayfairSelectActivity;
import com.mirim.simen.playfair.decode.PlayfairDecodeSelectActivity;
import com.mirim.simen.playfair.encryption.PlayfairEncryptionSelectActivity;
import com.mirim.simen.single.decode.SingleDecodeSelectActivity;
import com.mirim.simen.single.encryption.SingleEncryptionSelectActivity;

public class SingleSelectActivity extends AppCompatActivity {
    LinearLayout buttonEncryption;
    LinearLayout buttonDecode;
    ImageView buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_select);

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
                        Intent intent1 = new Intent(SingleSelectActivity.this, SingleEncryptionSelectActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_decode:
                        Intent intent2 = new Intent(SingleSelectActivity.this, SingleDecodeSelectActivity.class);
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