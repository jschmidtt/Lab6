package edu.temple.lab6;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.temple.lab5.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMaster extends Fragment {

    ListView listView;
    Context parent;

    public FragmentMaster() {
        // Required empty public constructor
    }

    //Grab a hold of the context aka the parent
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (! (context instanceof GetColorInterface)){}
        this.parent = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        listView = v.findViewById(R.id.listView);

        //Sets the list view using the ColorAdapter and the parents resource strings
        listView.setAdapter(new ColorAdapter(parent, parent.getResources().getStringArray(R.array.colors_array),
                parent.getResources().getStringArray(R.array.colors_array_display)));

        //Control what happens when color is clicked
        //Get Picked Color -> String
        //Send that to parent/interface 
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String colorName = (String) parentView.getItemAtPosition(position);
                ((GetColorInterface) parent).colorSelected(colorName);
            }
        });

        return v;
    }

    //Color Interface for Palette Activity to control what happens when a color is pressed.
    interface GetColorInterface {
        void colorSelected(String colorName);
    }

}
