package edu.temple.lab6;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements FragmentMaster.GetColorInterface {

    FragmentManager fm = getSupportFragmentManager();
    ColorFragment cf;

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setTitle(R.string.title_one);

        //Check to see if container 2 is there (aka landscape mode or big tablet)
        singlePane = findViewById(R.id.container_2) == null;
        cf = ColorFragment.newInstance("White");

        fm.beginTransaction()
                .replace(R.id.container_1, new FragmentMaster())
                .commit();

        if(!singlePane){
            fm.beginTransaction()
                    .replace(R.id.container_2, cf)
                    .commit();
        }
    }

    @Override
    public void colorSelected(String colorName) {

        //If SinglePane then make new colorFragment
        if(singlePane) {
            ColorFragment newColorFragment = ColorFragment.newInstance(colorName);
            fm.beginTransaction()
                    .replace(R.id.container_1, newColorFragment)
                    .addToBackStack(null)
                    .commit();
        } else {//Else just change the colorFragment
            cf.changeColor(colorName);
        }
    }
}
