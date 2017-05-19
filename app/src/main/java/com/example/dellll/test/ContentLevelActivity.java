package com.example.dellll.test;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.US;

public class ContentLevelActivity extends AppCompatActivity {

    private TextView txtSpeechInput;
    private TextView txtWord;
    private TextView txtStatus;
    private TextView txtVersion;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private int pos;
    public static final String contentPostion = "key";
    private Button btn_prev;
    private Button btn_next;
    private Button btn_test;
    private Button btn_playaudio;
    private MediaPlayer myPlayerSound;
    private int dem = 0;
    Ringtone ringtone;
    Database db = new Database(this);

    ArrayList<Word> arrchude1 = new ArrayList<>();
    private static final int REQUEST_CODE_RECORD_VIDEO = 1001;
    private static final String[] PERMISSIONS_RECORD = {
            Manifest.permission.RECORD_AUDIO
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentlevel);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        txtVersion = (TextView) findViewById(R.id.version);
        txtWord = (TextView) findViewById(R.id.word);
        txtStatus = (TextView) findViewById(R.id.status);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        btn_prev = (Button) findViewById(R.id.btn_prev);
        btn_next = (Button) findViewById(R.id.btn_next);
        //btn_test = (Button) findViewById(R.id.btn_test);
        btn_playaudio = (Button) findViewById(R.id.btn_playaudio);
        // hide the action bar
        //getActionBar().hide();

//        btn_test.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Cursor kq = db.DELl_GetData("SELECT * FROM tbWORD");
//                while (kq.moveToNext()) {
//                    Toast.makeText(ContentLevelActivity.this, kq.getString(5), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               if (verifyRecordPermissions()){
                   promptSpeechInput();
               }
            }
        });
        Postion();
        AddListTu();
        settext();


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dem >= arrchude1.size() - 1) {

                } else {
                    dem++;
                    settext();
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dem == 0) {


                } else {
                    dem--;
                    settext();
                }
            }
        });

        btn_playaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNotificationSound();
            }
        });
    }

    private boolean verifyRecordPermissions() {
        // Check if we have read or write permission
        int readPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_RECORD,
                    REQUEST_CODE_RECORD_VIDEO
            );

            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case REQUEST_CODE_RECORD_VIDEO:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    promptSpeechInput();
                }
                break;
        }
    }


    public void playNotificationSound() {
        try {
            Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/raw/" + arrchude1.get(dem).getW_audio());

            ringtone = RingtoneManager.getRingtone(this, alarmSound);
            ringtone.play();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void settext() {
        txtWord.setText(arrchude1.get(dem).getW_word());
        txtStatus.setText("Bạn đã nói được từ này "+ arrchude1.get(dem).getW_status()+ " lần.");
        txtVersion.setText(arrchude1.get(dem).getW_consonant());
        txtSpeechInput.setText("");
    }

    public void AddListTu() {
        Cursor works = db.DELl_GetData("SELECT * FROM tbWORD WHERE tbWORD.tb2_level ='" + pos + "'");
        while (works.moveToNext()) {
            arrchude1.add(new Word(works.getString(1), works.getString(2), works.getString(3), works.getString(4), works.getString(5),works.getString(6)));
        }

    }

    public void Postion() {
        Intent inten = getIntent();
        pos = inten.getIntExtra(MainActivity.Mainpostion, 1);
    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, ENGLISH);
        String word = arrchude1.get(dem).getW_word();
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                word +"\n" + arrchude1.get(dem).getW_consonant());


        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText("Từ bạn vừa nói: " + result.get(0));

                    if (result.get(0).toLowerCase().equals(arrchude1.get(dem).getW_word())) {
                        int temp =Integer.parseInt(arrchude1.get(dem).getW_status()) + 1;
                        //update lai status trong database
                        db.DELL_QueryData("UPDATE tbWORD SET tb2_status = '"+temp+"' WHERE tb2_word = '" + arrchude1.get(dem).getW_word() + "'");
                        //thong bao
                        Toast.makeText(ContentLevelActivity.this, "CHÍNH XÁC!", Toast.LENGTH_SHORT).show();
                        txtSpeechInput.setText(result.get(0));
                    }
                    else
                    {
                        Toast.makeText(ContentLevelActivity.this,"Chưa chính xác! " + arrchude1.get(dem).getW_huongdan(), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            }

        }
    }
}
