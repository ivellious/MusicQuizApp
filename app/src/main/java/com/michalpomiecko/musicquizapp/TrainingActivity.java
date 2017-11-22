package com.michalpomiecko.musicquizapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by michal on 20.11.17.
 */

public class TrainingActivity extends AppCompatActivity implements View.OnClickListener{

    Button a, as, b, c, cs, d, ds, e,f,fs,g,gs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_training);

        a = (Button) findViewById(R.id.Aid);
        a.setOnClickListener(this);
        as = (Button) findViewById(R.id.Asid);
        as.setOnClickListener(this);
        b = (Button) findViewById(R.id.Bid);
        b.setOnClickListener(this);
        c = (Button) findViewById(R.id.Cid);
        c.setOnClickListener(this);
        cs = (Button) findViewById(R.id.Csid);
        cs.setOnClickListener(this);
        d = (Button) findViewById(R.id.Did);
        d.setOnClickListener(this);
        ds = (Button) findViewById(R.id.Dsid);
        ds.setOnClickListener(this);
        e= (Button) findViewById(R.id.Eid);
        e.setOnClickListener(this);
        f = (Button) findViewById(R.id.Fid);
        f.setOnClickListener(this);
        fs = (Button) findViewById(R.id.Fsid);
        fs.setOnClickListener(this);
        g = (Button) findViewById(R.id.Gid);
        g.setOnClickListener(this);
        gs = (Button) findViewById(R.id.Gsid);
        gs.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        playSound(id);
    }

    private void playSound(int id) {
        switch (id) {
            case R.id.Aid:
                play(R.raw.a);
                break;
            case R.id.Asid:
                play(R.raw.as);
                break;
            case R.id.Bid:
                play(R.raw.b);
                break;
            case R.id.Cid:
                play(R.raw.c);
                break;
            case R.id.Csid:
                play(R.raw.cs);
                break;
            case R.id.Did:
                play(R.raw.d);
                break;
            case R.id.Dsid:
                play(R.raw.ds);
                break;
            case R.id.Eid:
                play(R.raw.e);
                break;
            case R.id.Fid:
                play(R.raw.f);
                break;
            case R.id.Fsid:
                play(R.raw.fs);
                break;
            case R.id.Gid:
                play(R.raw.g);
                break;
            case R.id.Gsid:
                play(R.raw.gs);
                break;
            default:
                break;
        }
    }

    private void play(int id) {
        final MediaPlayer mMediaPlayer =MediaPlayer.create(this, id);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mMediaPlayer.release();
            }
        });
        mMediaPlayer.start();
    }
}
