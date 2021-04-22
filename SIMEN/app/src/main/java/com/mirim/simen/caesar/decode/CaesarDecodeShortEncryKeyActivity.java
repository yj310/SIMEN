package com.mirim.simen.caesar.decode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mirim.simen.R;
import com.mirim.simen.caesar.encryption.CaesarEncryptionShortActivity;

public class CaesarDecodeShortEncryKeyActivity extends AppCompatActivity {

    ImageView buttonBack;
    Button buttonRun;
    Button buttonCopy;
    Button buttonReverse;
    TextView buttonAnotherKey;

    TextView[] encryTable;

    TextView textBefore;
    TextView textAfter;
    TextView textKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_decode_short_encry_key);

        Intent intent = getIntent();

        setViews();
        if(intent.hasExtra("textAfter")) {
            textBefore.setText(intent.getStringExtra("textAfter"));
        } else if(intent.hasExtra("textBefore")){
            textBefore.setText(intent.getStringExtra("textBefore"));
        }
        if(intent.hasExtra("key")) {
            textKey.setText(intent.getStringExtra("key"));
        }
        setButtons();
    }

    public void setViews() {
        buttonBack = findViewById(R.id.button_back);
        buttonRun = findViewById(R.id.button_run);
        buttonCopy = findViewById(R.id.button_copy);
        buttonReverse = findViewById(R.id.button_reverse);
        buttonAnotherKey = findViewById(R.id.button_another_key);

        textBefore = findViewById(R.id.text_before);
        textAfter = findViewById(R.id.text_after);
        textKey = findViewById(R.id.text_key);
        encryTable = new TextView[26];

        encryTable[0] = findViewById(R.id.table_a);
        encryTable[1] = findViewById(R.id.table_b);
        encryTable[2] = findViewById(R.id.table_c);
        encryTable[3] = findViewById(R.id.table_d);
        encryTable[4] = findViewById(R.id.table_e);
        encryTable[5] = findViewById(R.id.table_f);
        encryTable[6] = findViewById(R.id.table_g);
        encryTable[7] = findViewById(R.id.table_h);
        encryTable[8] = findViewById(R.id.table_i);
        encryTable[9] = findViewById(R.id.table_j);
        encryTable[10] = findViewById(R.id.table_k);
        encryTable[11] = findViewById(R.id.table_l);
        encryTable[12] = findViewById(R.id.table_m);
        encryTable[13] = findViewById(R.id.table_n);
        encryTable[14] = findViewById(R.id.table_o);
        encryTable[15] = findViewById(R.id.table_p);
        encryTable[16] = findViewById(R.id.table_q);
        encryTable[17] = findViewById(R.id.table_r);
        encryTable[18] = findViewById(R.id.table_s);
        encryTable[19] = findViewById(R.id.table_t);
        encryTable[20] = findViewById(R.id.table_u);
        encryTable[21] = findViewById(R.id.table_v);
        encryTable[22] = findViewById(R.id.table_w);
        encryTable[23] = findViewById(R.id.table_x);
        encryTable[24] = findViewById(R.id.table_y);
        encryTable[25] = findViewById(R.id.table_z);

    }

    public void setButtons() {

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

                    case R.id.button_run:
                        Caesar();
                        break;

                    case R.id.button_copy:
                        if(textAfter.getText().toString().length() > 0) {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                            ClipData clipData = ClipData.newPlainText("EncryptionText", textAfter.getText().toString());
                            clipboardManager.setPrimaryClip(clipData);
                            Toast.makeText(CaesarDecodeShortEncryKeyActivity.this, "복호문이 복사되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CaesarDecodeShortEncryKeyActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_reverse:
                        if(textAfter.getText().toString().length() > 0) {
                            Intent intent = new Intent(CaesarDecodeShortEncryKeyActivity.this, CaesarEncryptionShortActivity.class);
                            intent.putExtra("textAfter",textAfter.getText().toString());
                            if(textKey.getText().toString().length() > 0)
                                intent.putExtra("key", textKey.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(CaesarDecodeShortEncryKeyActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_another_key:
                        Intent intent = new Intent(CaesarDecodeShortEncryKeyActivity.this, CaesarDecodeShortActivity.class);
                        if(textBefore.getText().toString().length() > 0)
                            intent.putExtra("textBefore", textBefore.getText().toString());
                        if(textKey.getText().toString().length() > 0)
                            intent.putExtra("key", String.valueOf(Integer.parseInt(textKey.getText().toString()) * -1));
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                }
            }
        };

        buttonBack.setOnClickListener(listener);
        buttonRun.setOnClickListener(listener);
        buttonCopy.setOnClickListener(listener);
        buttonReverse.setOnClickListener(listener);
        buttonAnotherKey.setOnClickListener(listener);

    }

    public void Caesar() {

        if(textBefore.getText().toString().length() > 0) {
            if(textKey.getText().toString().length() > 0) {

                String str = textBefore.getText().toString().toUpperCase();
                String keyStr = textKey.getText().toString();
                String newStr = "";
                int key = Integer.parseInt(keyStr);
                char[] ch1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G'
                        , 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'
                        , 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                int AlphabetLength = 26;
                boolean isChange;

                while(key > 0) {
                    key -= AlphabetLength;
                }


                for(int i = 0; i < str.length(); i++) {
                    isChange = false;
                    for(int j = 0; j < AlphabetLength; j++) {
                        if(str.charAt(i) == ch1[j]) {
                            newStr += ch1[(j - key) % AlphabetLength];
                            isChange = true;
                            break;
                        }
                    }
                    if(!isChange) {
                        newStr += str.charAt(i);
                    }
                }

                for(int i = 0; i < AlphabetLength; i++) {
                    encryTable[i].setText(String.valueOf(ch1[(i - key) % AlphabetLength]));
                }

                textAfter.setText(newStr);

                Toast.makeText(CaesarDecodeShortEncryKeyActivity.this, "복호화를 완료하였습니다.", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "암호키를 입력하십시오.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "암호문을 입력하십시오.", Toast.LENGTH_SHORT).show();
        }

    }

}