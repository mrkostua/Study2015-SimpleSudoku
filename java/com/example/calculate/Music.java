package com.example.calculate;


import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

public class Music {
    private static MediaPlayer mp = null;

    public static void play( Context kontekst, int zasob)
    {
        stop(kontekst);
        if(Preferencje.wezMusic(kontekst))
        {
            mp = MediaPlayer.create(kontekst, zasob);
            mp.setLooping(true);
            mp.start();

        }

    }
    public static void stop(Context context)
    {
        if(mp != null)
        {
            mp.stop();
            mp.release();
            mp = null;

        }

    }


}
