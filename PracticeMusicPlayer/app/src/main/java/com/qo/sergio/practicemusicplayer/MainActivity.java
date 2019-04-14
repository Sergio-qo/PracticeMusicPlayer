package com.qo.sergio.practicemusicplayer;

//Import all necessary packages
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    //Here are the variables which I am going to use
    Button play_pause, btn_repeat, btn_next, btn_previos; //Those are the buttons
    MediaPlayer mp; //This is a mediaplayer object
    ImageView iv; //This is the imageview wich contains the songs covers
    int repeat = 2, position = 0; //The repeat variable store the repeat status an "position" the position of the song which is playing

    MediaPlayer mpvector [] = new MediaPlayer [3]; //I create a media player vector with three items to store the songs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Here are the assignments of the variables for the buttons
        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repeat = (Button)findViewById(R.id.btn_repeat);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_previos = (Button)findViewById(R.id.btn_previous);
        iv = (ImageView)findViewById(R.id.imageView);

        //The assignments of the songs in the vector
        mpvector[0] = MediaPlayer.create(this, R.raw.race);
        mpvector[1] = MediaPlayer.create(this, R.raw.sound);
        mpvector[2] = MediaPlayer.create(this, R.raw.tea);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
