package edu.temple.lab6;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import edu.temple.lab5.R;

public class PaletteActivity extends AppCompatActivity implements FragmentMaster.GetColorInterface {

    Spinner spinner;
    FragmentManager fm = getSupportFragmentManager();
    ColorAdapter adapter;

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

        adapter = new ColorAdapter(this, myColors, myColorsDisplay);

        fm.beginTransaction()
                .replace(R.id.container_1, new FragmentMaster())
                .commit();
    }

    @Override
    public void colorSelected(String colorName) {
        ColorFragment newColorFragment = ColorFragment.newInstance(colorName);
        fm.beginTransaction()
                .replace(R.id.container_1, newColorFragment)
                .addToBackStack(null)
                .commit();
    }
}
