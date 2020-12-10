package com.example.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fragment.DB.IncidenciaDBHelper;
import com.example.fragment.model.Incidencia;


public class AfegirIncidencia extends Fragment {
    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    Spinner spinner;

    public AfegirIncidencia() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbHelper = new IncidenciaDBHelper(requireActivity().getApplicationContext());
        db = dbHelper.getWritableDatabase();

        final View fAfegir = inflater.inflate(R.layout.fragment_add_incidence, container, false);

        spinner = fAfegir.findViewById(R.id.Spinner1);
        ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(fAfegir.getContext(), R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        final Button button1 = fAfegir.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText textIncidencia = fAfegir.findViewById(R.id.txtIncidencia);
                String spinerItem = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                Incidencia incidencia = new Incidencia(1,textIncidencia.getText().toString(), spinerItem);
                dbHelper.insertIncidencia(db, incidencia);

            }
        });


        // Inflate the layout for this fragment
        return fAfegir;
    }

    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

}
