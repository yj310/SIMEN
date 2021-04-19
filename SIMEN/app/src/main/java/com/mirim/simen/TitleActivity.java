package com.mirim.simen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.mirim.simen.caesar.CaesarSelectActivity;
import com.mirim.simen.playfair.PlayfairSelectActivity;
import com.mirim.simen.single.SingleSelectActivity;

public class TitleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);


        Button buttonCaesar = (Button)findViewById(R.id.button_caesar);
        Button buttonSingle = (Button)findViewById(R.id.button_single);
        Button buttonPlayfair = (Button)findViewById(R.id.button_playfair);
        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.button_caesar:
                        Intent intent1 = new Intent(TitleActivity.this, CaesarSelectActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button_single:
                        Intent intent2 = new Intent(TitleActivity.this, SingleSelectActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.button_playfair:
                        Intent intent3 = new Intent(TitleActivity.this, PlayfairSelectActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        };

        buttonCaesar.setOnClickListener(listener);
        buttonSingle.setOnClickListener(listener);
        buttonPlayfair.setOnClickListener(listener);


    }
}