package edu.temple.lab5;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity {

    Spinner spinner;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.title_one);

        //Set Colors
        Resources res = getResources();
        final String myColorsDisplay[] = res.getStringArray(R.array.colors_array_display); //For Spanish Display
        final String myColors[] = res.getStringArray(R.array.colors_array); //For colorParse (aka cant parse blanco -> white)
        //Log.e(LOG_TAG,myColors[0]);

        fm.beginTransaction()
                .replace(R.id.container_1, new FragmentMaster())
                .commit();
    }
}
