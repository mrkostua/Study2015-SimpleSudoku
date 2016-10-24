
package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;

public class Informacje extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacje);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Music.stop(this);
    }

    @Override
    protected void onResume() {
        Music.play(this, R.raw.glowna);
        super.onResume();
    }
}

