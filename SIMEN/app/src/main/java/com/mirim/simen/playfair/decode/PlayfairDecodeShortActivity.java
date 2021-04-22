package com.mirim.simen.playfair.decode;

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
import com.mirim.simen.caesar.decode.CaesarDecodeShortActivity;
import com.mirim.simen.playfair.encryption.PlayfairEncryptionShortActivity;

import java.util.ArrayList;

public class PlayfairDecodeShortActivity extends AppCompatActivity {

    ImageView buttonBack;
    Button buttonRun;
    Button buttonCopy;
    Button buttonReverse;

    TextView[][] encryTable;
    TextView[] fairBeforeTable;
    TextView[] fairAfterTable;

    TextView textBefore;
    TextView textAfter;
    TextView textKey;

    char alphabetBoard[][] = new char[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair_decode_short);

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


        fairBeforeTable = new TextView[40];
        fairBeforeTable[0] = findViewById(R.id.fair_before_1);
        fairBeforeTable[1] = findViewById(R.id.fair_before_2);
        fairBeforeTable[2] = findViewById(R.id.fair_before_3);
        fairBeforeTable[3] = findViewById(R.id.fair_before_4);
        fairBeforeTable[4] = findViewById(R.id.fair_before_5);
        fairBeforeTable[5] = findViewById(R.id.fair_before_6);
        fairBeforeTable[6] = findViewById(R.id.fair_before_7);
        fairBeforeTable[7] = findViewById(R.id.fair_before_8);
        fairBeforeTable[8] = findViewById(R.id.fair_before_9);
        fairBeforeTable[9] = findViewById(R.id.fair_before_10);
        fairBeforeTable[10] = findViewById(R.id.fair_before_11);
        fairBeforeTable[11] = findViewById(R.id.fair_before_12);
        fairBeforeTable[12] = findViewById(R.id.fair_before_13);
        fairBeforeTable[13] = findViewById(R.id.fair_before_14);
        fairBeforeTable[14] = findViewById(R.id.fair_before_15);
        fairBeforeTable[15] = findViewById(R.id.fair_before_16);
        fairBeforeTable[16] = findViewById(R.id.fair_before_17);
        fairBeforeTable[17] = findViewById(R.id.fair_before_18);
        fairBeforeTable[18] = findViewById(R.id.fair_before_19);
        fairBeforeTable[19] = findViewById(R.id.fair_before_20);
        fairBeforeTable[20] = findViewById(R.id.fair_before_21);
        fairBeforeTable[21] = findViewById(R.id.fair_before_22);
        fairBeforeTable[22] = findViewById(R.id.fair_before_23);
        fairBeforeTable[23] = findViewById(R.id.fair_before_24);
        fairBeforeTable[24] = findViewById(R.id.fair_before_25);
        fairBeforeTable[25] = findViewById(R.id.fair_before_26);
        fairBeforeTable[26] = findViewById(R.id.fair_before_27);
        fairBeforeTable[27] = findViewById(R.id.fair_before_28);
        fairBeforeTable[28] = findViewById(R.id.fair_before_29);
        fairBeforeTable[29] = findViewById(R.id.fair_before_30);
        fairBeforeTable[30] = findViewById(R.id.fair_before_31);
        fairBeforeTable[31] = findViewById(R.id.fair_before_32);
        fairBeforeTable[32] = findViewById(R.id.fair_before_33);
        fairBeforeTable[33] = findViewById(R.id.fair_before_34);
        fairBeforeTable[34] = findViewById(R.id.fair_before_35);
        fairBeforeTable[35] = findViewById(R.id.fair_before_36);
        fairBeforeTable[36] = findViewById(R.id.fair_before_37);
        fairBeforeTable[37] = findViewById(R.id.fair_before_38);
        fairBeforeTable[38] = findViewById(R.id.fair_before_39);
        fairBeforeTable[39] = findViewById(R.id.fair_before_40);


        fairAfterTable = new TextView[40];
        fairAfterTable[0] = findViewById(R.id.fair_after_1);
        fairAfterTable[1] = findViewById(R.id.fair_after_2);
        fairAfterTable[2] = findViewById(R.id.fair_after_3);
        fairAfterTable[3] = findViewById(R.id.fair_after_4);
        fairAfterTable[4] = findViewById(R.id.fair_after_5);
        fairAfterTable[5] = findViewById(R.id.fair_after_6);
        fairAfterTable[6] = findViewById(R.id.fair_after_7);
        fairAfterTable[7] = findViewById(R.id.fair_after_8);
        fairAfterTable[8] = findViewById(R.id.fair_after_9);
        fairAfterTable[9] = findViewById(R.id.fair_after_10);
        fairAfterTable[10] = findViewById(R.id.fair_after_11);
        fairAfterTable[11] = findViewById(R.id.fair_after_12);
        fairAfterTable[12] = findViewById(R.id.fair_after_13);
        fairAfterTable[13] = findViewById(R.id.fair_after_14);
        fairAfterTable[14] = findViewById(R.id.fair_after_15);
        fairAfterTable[15] = findViewById(R.id.fair_after_16);
        fairAfterTable[16] = findViewById(R.id.fair_after_17);
        fairAfterTable[17] = findViewById(R.id.fair_after_18);
        fairAfterTable[18] = findViewById(R.id.fair_after_19);
        fairAfterTable[19] = findViewById(R.id.fair_after_20);
        fairAfterTable[20] = findViewById(R.id.fair_after_21);
        fairAfterTable[21] = findViewById(R.id.fair_after_22);
        fairAfterTable[22] = findViewById(R.id.fair_after_23);
        fairAfterTable[23] = findViewById(R.id.fair_after_24);
        fairAfterTable[24] = findViewById(R.id.fair_after_25);
        fairAfterTable[25] = findViewById(R.id.fair_after_26);
        fairAfterTable[26] = findViewById(R.id.fair_after_27);
        fairAfterTable[27] = findViewById(R.id.fair_after_28);
        fairAfterTable[28] = findViewById(R.id.fair_after_29);
        fairAfterTable[29] = findViewById(R.id.fair_after_30);
        fairAfterTable[30] = findViewById(R.id.fair_after_31);
        fairAfterTable[31] = findViewById(R.id.fair_after_32);
        fairAfterTable[32] = findViewById(R.id.fair_after_33);
        fairAfterTable[33] = findViewById(R.id.fair_after_34);
        fairAfterTable[34] = findViewById(R.id.fair_after_35);
        fairAfterTable[35] = findViewById(R.id.fair_after_36);
        fairAfterTable[36] = findViewById(R.id.fair_after_37);
        fairAfterTable[37] = findViewById(R.id.fair_after_38);
        fairAfterTable[38] = findViewById(R.id.fair_after_39);
        fairAfterTable[39] = findViewById(R.id.fair_after_40);

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
                            Toast.makeText(PlayfairDecodeShortActivity.this, "복호문이 복사되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PlayfairDecodeShortActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_reverse:
                        if(textAfter.getText().toString().length() > 0) {
                            Intent intent = new Intent(PlayfairDecodeShortActivity.this, PlayfairEncryptionShortActivity.class);
                            intent.putExtra("textAfter",textAfter.getText().toString());
                            intent.putExtra("key", textKey.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(PlayfairDecodeShortActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
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
                if(textBefore.getText().toString().length() % 2 == 0) {
                    String str = textBefore.getText().toString().toLowerCase();
                    String key = textKey.getText().toString();
                    String decryption;


                    setBoard(key);  // 복호화에 쓰일 암호판 세팅

                    Toast.makeText(this, "str", Toast.LENGTH_SHORT).show();
                    for( int i = 0 ; i < str.length() ; i++ )
                    {
                        if(str.charAt(i)==' ') //공백제거
                            str = str.substring(0, i)+str.substring(i + 1, str.length());
                    }

                    decryption = strDecryption(key, str);

                    textAfter.setText(decryption);

                    Toast.makeText(this, "복호화를 완료하였습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "복호화할 수 없는 암호문입니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "암호키를 입력하십시오.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "평문을 입력하십시오.", Toast.LENGTH_SHORT).show();
        }

    }

    public String strDecryption(String key, String str) {
        ArrayList<char[]> playFair = new ArrayList<char[]>(); // 바꾸기 전 쌍자암호를 저장할 곳
        ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); // 바꾼 후의 쌍자암호 저장할 곳
        int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; // 쌍자 암호 두 글자의 각각의 행,열 값
        String decStr ="";

        for( int i = 0 ; i < str.length() ; i+=2 ) {
            char[] tmpArr = new char[2];
            tmpArr[0] = str.charAt(i);
            tmpArr[1] = str.charAt(i+1);
            playFair.add(tmpArr);
        }

        // 나눈 문자 테이블에 넣어 출력
        for(int i = 0 ; i < playFair.size() ; i++ ) {
            fairBeforeTable[i].setText(playFair.get(i)[0] +""+ playFair.get(i)[1]);
        }

        for(int i = 0 ; i < playFair.size() ; i++ ) {
            char[] tmpArr = new char[2];
            for(int j = 0 ; j < alphabetBoard.length ; j++) {
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

            if(x1 == x2)  {
                //행이 같은 경우 각각 바로 아래열 대입
                tmpArr[0] = alphabetBoard[x1][(y1 + 4) % 5];
                tmpArr[1] = alphabetBoard[x2][(y2 + 4) % 5];
            } else if(y1==y2) {
                //열이 같은 경우 각각 바로 옆 열 대입
                tmpArr[0] = alphabetBoard[(x1+4)%5][y1];
                tmpArr[1] = alphabetBoard[(x2+4)%5][y2];
            } else  {
                //행, 열 다른경우 각자 대각선에 있는 곳.
                tmpArr[0] = alphabetBoard[x2][y1];
                tmpArr[1] = alphabetBoard[x1][y2];
            }

            decPlayFair.add(tmpArr);

        }

        // 복호화한 문자 테이블에 넣어 출력
        for(int i = 0 ; i < playFair.size() ; i++ ) {
            fairAfterTable[i].setText(decPlayFair.get(i)[0] +""+ decPlayFair.get(i)[1]);
        }

        //중복 문자열 돌려놓음
        for(int i = 0 ; i < decPlayFair.size() ; i++) {
            if(i != decPlayFair.size() - 1 && decPlayFair.get(i)[1] == 'x'
                    && decPlayFair.get(i)[0] == decPlayFair.get(i + 1)[0]) {
                decStr += decPlayFair.get(i)[0];
            } else {
                decStr += decPlayFair.get(i)[0] + "" + decPlayFair.get(i)[1];
            }
        }

        return decStr;
    }

    public void setBoard(String key) {
        String keyForSet = "";                  // 중복된 문자가 제거된 문자열을 저장할 문자열.
        boolean duplicationFlag = false;        // 문자 중복을 체크하기 위한 flag 변수.

        key += "abcdefghijklmnopqrstuvwxyz"; 	// 키에 모든 알파벳을 추가.


        // 중복처리
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

        //배열에 대입
        for(int i = 0 ; i < alphabetBoard.length ; i++) {
            for( int j = 0; j <alphabetBoard[i].length ; j++ )
            {
                alphabetBoard[i][j] = keyForSet.charAt(i * 5 + j);
            }
        }

        //배열 출력
        for( int i = 0 ; i < alphabetBoard.length ; i++ ) {
            for( int j = 0; j <alphabetBoard[i].length ; j++ ) {
                encryTable[i][j].setText(String.valueOf(alphabetBoard[i][j]));
            }
        }


    }


}