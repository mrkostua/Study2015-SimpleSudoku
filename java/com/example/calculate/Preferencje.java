
package com.example.calculate;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;

public class Preferencje extends PreferenceActivity {
    private static final String OPC_MUZYKA = "muzyka";
    private static final boolean OPC_MUZYKA_DOM  = true;
    private static final String OPC_PODPOWIEDZI = "podpowiedzi";
    private static final boolean OPC_PODPOWIEDZI_DOM  = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ustawienia);
    }
   public static boolean wezMusic (Context kontekst)
   {
       return PreferenceManager.getDefaultSharedPreferences(kontekst).getBoolean(OPC_MUZYKA, OPC_MUZYKA_DOM);

   }

    public static boolean wezPodpowiedz (Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPC_PODPOWIEDZI, OPC_PODPOWIEDZI_DOM);

    }

}

