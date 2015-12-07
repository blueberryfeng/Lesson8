package com.example.blue.lesson6;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity implements View.OnTouchListener {

    private GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        gv = new GameView(this);
        gv.setOnTouchListener(this);
//        gv.setBackgroundColor(Color.WHITE);
        setContentView(gv);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gv.killThread(); //Notice this reaches into the GameView object and runs the killThread mehtod.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gv.onDestroy();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gv.onTouch(v, event);
    }
}
