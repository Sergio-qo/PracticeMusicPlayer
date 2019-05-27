package com.qo.sergio.practicemusicplayer;

//Import all necessary packages
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.*;
import android.view.View;
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

    //Play Pause method
    public void PlayPause(View view)
    {

        if(mpvector[position].isPlaying())
        {
            mpvector[position].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }
        else
        {
            mpvector[position].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }

    }

    //Stop method

    public void Stop(View view)
    {
        if(mpvector[position] != null)
        {
            mpvector[position].stop();
            mpvector[0] = MediaPlayer.create(this, R.raw.race);
            mpvector[1] = MediaPlayer.create(this, R.raw.sound);
            mpvector[2] = MediaPlayer.create(this, R.raw.tea);
            position = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }


    //Repeat method

    public void Repeat(View view)
    {
        if(repeat == 1)
        {
            btn_repeat.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repeat", Toast.LENGTH_SHORT).show();
            mpvector[position].setLooping(false);
            repeat = 2;
        }
        else
        {
            btn_repeat.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repeat", Toast.LENGTH_SHORT).show();
            mpvector[position].setLooping(true);
            repeat = 1;
        }
    }

    //Next song method

    public void NextSong(View view)
    {
        if(position < mpvector.length - 1)
        {
            if(mpvector[position].isPlaying())
            {
                mpvector[position].stop();
                position++;
                mpvector[position].start();

                switch (position)
                {
                    case 1:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.portada3);
                        break;
                }
            }
            else
            {
                position++;
            }
        }
        else
        {
            Toast.makeText(this, "No more songs", Toast.LENGTH_SHORT).show();
        }
    }


    //back method

    public void Back(View view)
    {
        if(position >= 1)
        {
            if(mpvector[position].isPlaying())
            {
                mpvector[position].stop();
                mpvector[0] = MediaPlayer.create(this, R.raw.race);
                mpvector[1] = MediaPlayer.create(this, R.raw.sound);
                mpvector[2] = MediaPlayer.create(this, R.raw.tea);
                position--;
                switch (position)
                {
                    case 1:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.portada3);
                        break;
                }
                mpvector[position].start();
            }
            else
            {
                switch (position)
                {
                    case 1:
                        iv.setImageResource(R.drawable.portada1);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.portada2);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.portada3);
                        break;
                }
                position--;
            }
        }
        else
        {
            Toast.makeText(this, "There aren't songs", Toast.LENGTH_SHORT).show();
        }
    }
}
