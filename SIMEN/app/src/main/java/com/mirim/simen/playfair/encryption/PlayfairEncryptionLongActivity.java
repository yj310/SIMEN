package com.mirim.simen.playfair.encryption;

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
import com.mirim.simen.playfair.decode.PlayfairDecodeLongActivity;
import com.mirim.simen.playfair.decode.PlayfairDecodeShortActivity;

import java.util.ArrayList;

public class PlayfairEncryptionLongActivity extends AppCompatActivity {

    ImageView buttonBack;
    Button buttonRun;
    Button buttonCopy;
    Button buttonReverse;

    TextView[][] encryTable;

    TextView textBefore;
    TextView textAfter;
    TextView textKey;

    char alphabetBoard[][] = new char[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair_encryption_long);

        Intent intent = getIntent();

        setViews();
        if(intent.hasExtra("textAfter")) {
            textBefore.setText(intent.getStringExtra("textAfter"));
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
        textBefore = findViewById(R.id.text_before);
        textAfter = findViewById(R.id.text_after);
        textKey = findViewById(R.id.text_key);


        encryTable = new TextView[5][5];
        encryTable[0][0] = findViewById(R.id.table_a);
        encryTable[0][1] = findViewById(R.id.table_b);
        encryTable[0][2] = findViewById(R.id.table_c);
        encryTable[0][3] = findViewById(R.id.table_d);
        encryTable[0][4] = findViewById(R.id.table_e);
        encryTable[1][0] = findViewById(R.id.table_f);
        encryTable[1][1] = findViewById(R.id.table_g);
        encryTable[1][2] = findViewById(R.id.table_h);
        encryTable[1][3] = findViewById(R.id.table_i);
        encryTable[1][4] = findViewById(R.id.table_j);
        encryTable[2][0] = findViewById(R.id.table_k);
        encryTable[2][1] = findViewById(R.id.table_l);
        encryTable[2][2] = findViewById(R.id.table_m);
        encryTable[2][3] = findViewById(R.id.table_n);
        encryTable[2][4] = findViewById(R.id.table_o);
        encryTable[3][0] = findViewById(R.id.table_p);
        encryTable[3][1] = findViewById(R.id.table_q);
        encryTable[3][2] = findViewById(R.id.table_r);
        encryTable[3][3] = findViewById(R.id.table_s);
        encryTable[3][4] = findViewById(R.id.table_t);
        encryTable[4][0] = findViewById(R.id.table_u);
        encryTable[4][1] = findViewById(R.id.table_v);
        encryTable[4][2] = findViewById(R.id.table_w);
        encryTable[4][3] = findViewById(R.id.table_x);
        encryTable[4][4] = findViewById(R.id.table_y);

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
                        Playfair();
                        break;

                    case R.id.button_copy:
                        if(textAfter.getText().toString().length() > 0) {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                            ClipData clipData = ClipData.newPlainText("EncryptionText", textAfter.getText().toString());
                            clipboardManager.setPrimaryClip(clipData);
                            Toast.makeText(PlayfairEncryptionLongActivity.this, "???????????? ?????????????????????.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PlayfairEncryptionLongActivity.this, "???????????? ????????? ????????????.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_reverse:
                        if(textAfter.getText().toString().length() > 0) {
                            Intent intent = new Intent(PlayfairEncryptionLongActivity.this, PlayfairDecodeLongActivity.class);
                            intent.putExtra("textAfter",textAfter.getText().toString());
                            intent.putExtra("key", textKey.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(PlayfairEncryptionLongActivity.this, "???????????? ????????? ????????????.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        };

        buttonBack.setOnClickListener(listener);
        buttonRun.setOnClickListener(listener);
        buttonCopy.setOnClickListener(listener);
        buttonReverse.setOnClickListener(listener);

    }

    public void Playfair() {
        if(textBefore.getText().toString().length() > 0) {
            if(textKey.getText().toString().length() > 0) {

                String encryption;
                String str = textBefore.getText().toString().toLowerCase();
                String key = textKey.getText().toString();

                boolean isEng;
                String alphabet = "abcdefghijklmnopqrstuvwxyz";

                // ?????? ????????? ??????
                for(int i = 0 ; i < str.length() ; i++) {
                    // ?????? ?????? ?????? ??????
                    isEng = false;
                    for(int j = 0; j < 26; j++) {
                        if(str.charAt(i) == alphabet.charAt(j)) {
                            isEng = true;
                        }
                    }
                    if(!isEng) {
                        str = str.substring(0, i) + str.substring(i + 1, str.length());
                        i--;
                        continue;
                    }

                    //z??? q??? ???????????? ?????????.
                    if(str.charAt(i) == 'z') {
                        str = str.substring(0, i) + 'q' + str.substring(i + 1, str.length());
                    }
                }


                //???????????? ?????? ????????? ??????
                setBoard(key);

                // ?????????
                encryption = strEncryption(key, str);

                textAfter.setText(encryption);

                Toast.makeText(this, "???????????? ?????????????????????.", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "???????????? ??????????????????.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "????????? ??????????????????.", Toast.LENGTH_SHORT).show();
        }
    }


    public String strEncryption(String key, String str){
        ArrayList<char[]> playFair = new ArrayList<char[]>();
        ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
        int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
        String encStr ="";

        // arraylist ??????
        for(int i = 0 ; i < str.length() ; i += 2) {
            char[] tmpArr = new char[2];
            tmpArr[0] = str.charAt(i);
            try {
                //?????? ???????????? x??????
                if( str.charAt(i) == str.charAt(i+1)) {
                    tmpArr[1] = 'x';
                    i--;
                } else {
                    tmpArr[1] = str.charAt(i+1);
                }
            } catch(StringIndexOutOfBoundsException e) {
                tmpArr[1] = 'x';
            }
            playFair.add(tmpArr);
        }


        for(int i = 0 ; i < playFair.size() ; i++ ) {

            char[] tmpArr = new char[2];
            //??????????????? ?????? ????????????
            for( int j = 0 ; j < alphabetBoard.length ; j++ ) {
                for( int k = 0 ; k < alphabetBoard[j].length ; k++ ) {
                    if(alphabetBoard[j][k] == playFair.get(i)[0]) {
                        x1 = j;
                        y1 = k;
                    }
                    if(alphabetBoard[j][k] == playFair.get(i)[1]) {
                        x2 = j;
                        y2 = k;
                    }
                }
            }

            //?????? ????????????
            if(x1==x2) {
                tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
                tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
            } else if(y1==y2) {
                //?????? ?????? ??????
                tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
                tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
            } else {
                //???, ??? ?????? ????????????
                tmpArr[0] = alphabetBoard[x2][y1];
                tmpArr[1] = alphabetBoard[x1][y2];
            }

            encPlayFair.add(tmpArr);

        }

        for(int i = 0 ; i < encPlayFair.size() ; i++) {
            encStr += encPlayFair.get(i)[0] +""+ encPlayFair.get(i)[1];
        }


        return encStr;
    }

    public void setBoard(String key) {
        String keyForSet = "";                  // ????????? ????????? ????????? ???????????? ????????? ?????????.
        boolean duplicationFlag = false;        // ?????? ????????? ???????????? ?????? flag ??????.

        key += "abcdefghijklmnopqrstuvwxyz"; 	// ?????? ?????? ???????????? ??????.


        // ????????????
        for(int i = 0 ; i < key.length() ; i++) {
            for(int j = 0 ; j < keyForSet.length() ; j++) {
                if(key.charAt(i) == keyForSet.charAt(j)) {
                    duplicationFlag = true;
                    break;
                }
            }
            if(!(duplicationFlag))
                keyForSet += key.charAt(i);
            duplicationFlag = false;
        }

        //????????? ??????
        for(int i = 0 ; i < alphabetBoard.length ; i++) {
            for( int j = 0; j <alphabetBoard[i].length ; j++ )
            {
                alphabetBoard[i][j] = keyForSet.charAt(i * 5 + j);
            }
        }

        //?????? ??????
        for( int i = 0 ; i < alphabetBoard.length ; i++ ) {
            for( int j = 0; j <alphabetBoard[i].length ; j++ ) {
                encryTable[i][j].setText(String.valueOf(alphabetBoard[i][j]));
            }
        }


    }


}