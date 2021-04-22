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
import com.mirim.simen.playfair.encryption.PlayfairEncryptionLongActivity;
import com.mirim.simen.playfair.encryption.PlayfairEncryptionShortActivity;

import java.util.ArrayList;

public class PlayfairDecodeLongActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_playfair_decode_long);

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
                            Toast.makeText(PlayfairDecodeLongActivity.this, "복호문이 복사되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PlayfairDecodeLongActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.button_reverse:
                        if(textAfter.getText().toString().length() > 0) {
                            Intent intent = new Intent(PlayfairDecodeLongActivity.this, PlayfairEncryptionLongActivity.class);
                            intent.putExtra("textAfter",textAfter.getText().toString());
                            intent.putExtra("key", textKey.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(PlayfairDecodeLongActivity.this, "복호화된 문장이 없습니다.", Toast.LENGTH_SHORT).show();
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