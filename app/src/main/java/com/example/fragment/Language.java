package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

public class Language extends Fragment {

    public Language() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fLanguaje = inflater.inflate(R.layout.fragment_language, container, false);

//        SharedPreferences prefs =
//                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        final Button buttEn = fLanguaje.findViewById(R.id.bttEng);
        buttEn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Locale localizacionEN = new Locale("en", "EN");

                Locale.setDefault(localizacionEN);
                Configuration config = new Configuration();
                config.locale = localizacionEN;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Success();
            }
        });

        final Button buttEs = fLanguaje.findViewById(R.id.bttEs);
        buttEs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Locale localizacionEs = new Locale("es", "ES");

                Locale.setDefault(localizacionEs);
                Configuration config = new Configuration();
                config.locale = localizacionEs;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Success();
            }
        });

//        final Button deleteDatos = fLanguaje.findViewById(R.id.deleteDatos);
//        deleteDatos.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                editor.putString("user", "");
//                editor.putString("pass", "");
//                editor.commit();
//                Success();
//            }
//        });


        return fLanguaje;
    }

    public void Success() {
        Intent goMain = new Intent(getContext(), MainActivity.class);
        startActivity(goMain);
    }
}