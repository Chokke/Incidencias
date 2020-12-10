package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Menu extends Fragment {

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnAfegir = fMenu.findViewById(R.id.btAfegir);
        btnAfegir.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fAgeirIncidencia = new AfegirIncidencia();

                menuTransaction.replace(R.id.framLayout, fAgeirIncidencia);

                menuTransaction.commit();
            }
        });

        Button btLlista = fMenu.findViewById(R.id.btLlista);
        btLlista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //Log.i("Testing", "1");

                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fLlista = new Lista();

                menuTransaction.replace(R.id.framLayout, fLlista);

                menuTransaction.commit();
            }
        });

        Button btEliminar = fMenu.findViewById(R.id.btElimina);
        btEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //Log.i("Testing", "1");

                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fEliminar = new Eliminar();

                menuTransaction.replace(R.id.framLayout, fEliminar);

                menuTransaction.commit();
            }
        });

        Button btLanguage = fMenu.findViewById(R.id.btLanguage);
        btLanguage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //Log.i("Testing", "1");

                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fLanguage = new Language();

                menuTransaction.replace(R.id.framLayout, fLanguage);

                menuTransaction.commit();
            }
        });

        return fMenu;
    }
}
