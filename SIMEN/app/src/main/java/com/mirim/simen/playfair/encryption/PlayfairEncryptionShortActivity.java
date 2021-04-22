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
import com.mirim.simen.caesar.decode.CaesarDecodeShortActivity;
import com.mirim.simen.caesar.encryption.CaesarEncryptionShortActivity;
import com.mirim.simen.playfair.decode.PlayfairDecodeShortActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayfairEncryptionShortActivity extends AppCompatActivity {

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
    String blankCheck = "";

    char alphabetBoard[][] = new char[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair_encryption_short);

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
                            Toast.makeText(PlayfairEncryptionShortActivity.this, "암호문이 복사되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PlayfairEncryptionShortActivity.this, "암호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_reverse:
                        if(textAfter.getText().toString().length() > 0) {
                            Intent intent = new Intent(PlayfairEncryptionShortActivity.this, PlayfairDecodeShortActivity.class);
                            intent.putExtra("textAfter",textAfter.getText().toString());
                            intent.putExtra("key", textKey.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(PlayfairEncryptionShortActivity.this, "암호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
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
        for(int i = 0; i < 40; i++) {
            fairBeforeTable[i].setText("");
            fairAfterTable[i].setText("");
        }
        if(textBefore.getText().toString().length() > 0) {
            if(textKey.getText().toString().length() > 0) {

                String encryption;
                String str = textBefore.getText().toString().toLowerCase();
                String key = textKey.getText().toString();

                int realStrLength = 0;
                String alphabet = "abcdefghijklmnopqrstuvwxyz";
                for(int i = 0; i < str.length(); i++) {
                    for(int j = 0; j < alphabet.length(); j++) {
                        if(str.charAt(i) == alphabet.charAt(j)) {
                            realStrLength++;
                        }
                    }
                }

                if(realStrLength <= 40) {

                    //암호화에 쓰일 암호판 세팅
                    setBoard(key);

                    // 입력 문자열 정리
                    for(int i = 0 ; i < str.length() ; i++) {
                        // 공백 제거
                        if(str.charAt(i) == ' ') {
                            str = str.substring(0, i) + str.substring(i + 1, str.length());
                        }

                        //z를 q로 바꿔줘서 처리함.
                        if(str.charAt(i) == 'z') {
                            str = str.substring(0, i) + 'q' + str.substring(i + 1, str.length());
                        }
                    }



                    // 암호화
                    encryption = strEncryption(key, str);

                    textAfter.setText(encryption);

                    Toast.makeText(this, "암호화를 완료하였습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "암호화할 수 있는 글자수를 초과하였습니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "암호키를 입력하십시오.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "평문을 입력하십시오.", Toast.LENGTH_SHORT).show();
        }
    }


    public String strEncryption(String key, String str){
        ArrayList<char[]> playFair = new ArrayList<char[]>();
        ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
        int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
        String encStr ="";

        // arraylist 세팅
        for(int i = 0 ; i < str.length() ; i += 2) {
            char[] tmpArr = new char[2];
            tmpArr[0] = str.charAt(i);
            try {
                //글이 반복되면 x추가
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

        // 나눈 문자 테이블에 넣어 출력
        for(int i = 0 ; i < playFair.size() ; i++ ) {
            fairBeforeTable[i].setText(playFair.get(i)[0] +""+ playFair.get(i)[1]);
        }

        for(int i = 0 ; i < playFair.size() ; i++ ) {

            char[] tmpArr = new char[2];
            //쌍자암호의 각각 위치체크
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

            //행이 같은경우
            if(x1==x2) {
                tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
                tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
            } else if(y1==y2) {
                //열이 같은 경우
                tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
                tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
            } else {
                //행, 열 모두 다른경우
                tmpArr[0] = alphabetBoard[x2][y1];
                tmpArr[1] = alphabetBoard[x1][y2];
            }

            encPlayFair.add(tmpArr);

        }

        for(int i = 0 ; i < encPlayFair.size() ; i++) {
            encStr += encPlayFair.get(i)[0] +""+ encPlayFair.get(i)[1];
            fairAfterTable[i].setText(encPlayFair.get(i)[0] +""+ encPlayFair.get(i)[1]);
        }


        return encStr;
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