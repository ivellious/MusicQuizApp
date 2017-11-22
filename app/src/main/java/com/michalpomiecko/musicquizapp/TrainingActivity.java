package com.michalpomiecko.musicquizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

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
        Toast.makeText(this, "Playing sound : " + ((Button) findViewById(id)).getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
