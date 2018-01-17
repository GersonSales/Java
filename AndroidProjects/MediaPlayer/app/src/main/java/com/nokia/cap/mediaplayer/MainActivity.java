package com.nokia.cap.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewHolder.playPauseButton = findViewById(R.id.playPause_button);
        viewHolder.mediaPlayer = MediaPlayer.create(this, R.raw.musica);
        viewHolder.setupOnClickListener(this);

    }



    private void play() {
        if (viewHolder.mediaPlayer != null) {
            viewHolder.mediaPlayer.start();
            viewHolder.playPauseButton.setText(R.string.pause_song);
        }
    }

    private void pause() {
        if ( viewHolder.mediaPlayer != null ) {
            viewHolder.mediaPlayer.pause();
            viewHolder.playPauseButton.setText(R.string.play_song);
        }
    }


    private void stop() {
        if (viewHolder.mediaPlayer != null) {
            viewHolder.mediaPlayer.stop();
        }
    }


    private void release() {
        if (viewHolder.mediaPlayer != null) {
            viewHolder.mediaPlayer.release();
        }
    }

    private boolean isPlaying() {
        if (viewHolder.mediaPlayer != null) {
            return viewHolder.mediaPlayer.isPlaying();
        }

        return false;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.playPause_button:
                if (isPlaying()) {
                    pause();
                }else {
                    play();
                }

                break;
            default:break;
        }
    }

    private void setMediaPlayerAsNull() {
        if (viewHolder.mediaPlayer != null) {
            viewHolder.mediaPlayer = null;
        }
    }


    @Override
    protected void onDestroy() {
        if (isPlaying()) {
            stop();
            release();
            setMediaPlayerAsNull();
        }

        super.onDestroy();
    }

    private class ViewHolder {
        private Button playPauseButton;
        private MediaPlayer mediaPlayer;


        private void setupOnClickListener(View.OnClickListener listener) {
            playPauseButton.setOnClickListener(listener);
        }
    }
}
