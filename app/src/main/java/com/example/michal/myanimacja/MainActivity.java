package com.example.michal.myanimacja;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Handler;
import android.os.HandlerThread;



public class MainActivity extends Activity {

    Button b;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView)findViewById(R.id.anim);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.muve_up);
        t.setAnimation(animation);


        b = (Button)findViewById(R.id.buton);
        Animation a = AnimationUtils.loadAnimation(this,R.anim.but_anim);
        b.setAnimation(a);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation aa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clic_anim);
                view.startAnimation(aa);
                t.startAnimation(aa);
                

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            startActivity(new Intent(getApplicationContext(), Dwa_Activ.class));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();





            }

        });


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
