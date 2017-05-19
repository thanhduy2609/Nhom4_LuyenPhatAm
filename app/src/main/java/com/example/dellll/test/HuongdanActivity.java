package com.example.dellll.test;

import android.content.ContentResolver;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/**
 * Created by DELLLL on 5/11/2017.
 */

public class HuongdanActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button btn_playaudio;
    Ringtone ringtone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huongdan);

        this.imageView = (ImageView) this.findViewById(R.id.imageView);
        this.btn_playaudio = (Button) findViewById(R.id.btn_playaudio);

        imageView.setImageResource(R.drawable.r112rev);

        btn_playaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    playNotificationSound();
            }
        });
    }

    public void playNotificationSound() {
        try {
            Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/raw/" + "u32");

            ringtone = RingtoneManager.getRingtone(this, alarmSound);
            ringtone.play();

        } catch (Exception e) {
            e.getMessage();
        }
    }

}
