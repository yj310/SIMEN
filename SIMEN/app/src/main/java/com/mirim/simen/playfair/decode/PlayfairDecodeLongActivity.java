package com.mirim.simen.playfair.decode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mirim.simen.R;

public class PlayfairDecodeLongActivity extends AppCompatActivity {

    ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair_decode_long);

        setButton();
    }

    public void setButton(){
        buttonBack = findViewById(R.id.button_back);

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
                }
            }
        };

        buttonBack.setOnClickListener(listener);

    }

}