
package com.example.calculate;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

public class Sudoku extends Activity implements OnClickListener {

	private static final String ZNACZNIK = "Sudoku" ;
	
	
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);


	    // Konfigurujemy obiekty nas�uchuj�ce klikni�� dla wszystkich przycisk�w
	    View przyciskKontynuacja = findViewById(R.id.przycisk_kontuacja);
	    przyciskKontynuacja.setOnClickListener(this);
	    View przyciskNowa = findViewById(R.id.przycisk_nowa_gra);
	    przyciskNowa.setOnClickListener(this);
	    View przyciskInformacje = findViewById(R.id.przycisk_informacja);
	    przyciskInformacje.setOnClickListener(this);
	    View przyciskWyjscie = findViewById(R.id.przycisk_wyjscie);
	    przyciskWyjscie.setOnClickListener(this);
	}
	
	// ...
    public void onClick(View v) {

        switch (v.getId()) {
        case R.id.przycisk_informacja:
            Intent i = new Intent(this, Informacje.class);
            startActivity(i);
            break;
        // Tutaj definiujemy wi�cej klawiszy (je�li s� jakie�)�
            
        case R.id.przycisk_nowa_gra:
        	otworzDialogNowaGra();
        	break;
        	
        case R.id.przycisk_wyjscie:

            finish();
            break;
            case R.id.przycisk_kontuacja:
                uruchomGre(Gra.TRUDNOSC_KONTYNUACJA);
                break;


        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater wypelniacz = getMenuInflater();
        wypelniacz.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem element) {
        switch (element.getItemId()) {
        case R.id.ustawienia:
            startActivity(new Intent(this, Preferencje.class));
            return true;
        // Wstawiamy tutaj pozosta�e elementy (je�li jakie� b�d�) ...
        }
        return false;
    }
    
    
    /** Pytamy u�ytkownika o poziom trudno�ci */
    private void otworzDialogNowaGra() {
        new AlertDialog.Builder(this)
            .setTitle(R.string.tytul_nowa_gra)
            .setItems(R.array.trudnosc,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialoginterface, int i) {
                    uruchomGre(i);
                }
            })
            .show();
    }


    private void uruchomGre(int i) {
        Log.d(ZNACZNIK, "klikni�to " + i);
        Intent intencja = new Intent(Sudoku.this, Gra.class);
        intencja.putExtra(Gra.TRUDNOSC_KLUCZ, i);
        startActivity(intencja);
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

	
