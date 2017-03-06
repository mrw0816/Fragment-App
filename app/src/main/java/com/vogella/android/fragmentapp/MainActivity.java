package com.vogella.android.fragmentapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import layout.Display;

import layout.Settings;

public class MainActivity extends AppCompatActivity {


    String stringText = "";
    Display displayFrag = (Display) getFragmentManager().findFragmentById(R.id.fragment_display);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment setFrag = new Settings();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_place, setFrag);

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }


    public void onClickSubmit(View view){

        EditText editText = (EditText) findViewById(R.id.editTextSettings);
        stringText = editText.getText().toString();



    }

    public void ChangeFragment(View view){
        Fragment fragment;

        if( view == findViewById(R.id.settings_button)){
            fragment = new Settings();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
        if( view == findViewById(R.id.display_button)){
            fragment = new Display();
            Bundle bundle = new Bundle();
            bundle.putString("displayText", stringText);
            fragment.setArguments(bundle);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.addToBackStack(null);
            ft.commit();

        }
    }
}
