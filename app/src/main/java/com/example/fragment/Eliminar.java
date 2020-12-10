package com.example.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment.DB.IncidenciaDBHelper;

public class Eliminar extends Fragment {

    public static final String TABLE_NAME ="incidencia";

    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;

    public Eliminar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dbHelper = new IncidenciaDBHelper(requireActivity().getApplicationContext());
        db = dbHelper.getWritableDatabase();
        // Inflate the layout for this fragment
        final View fEliminar = inflater.inflate(R.layout.fragment_delete, container, false);

        final EditText IdIncidenciaEliminar = fEliminar.findViewById(R.id.txtIdIncidenciaEliminar);

        final Button deleteIncidencia = fEliminar.findViewById(R.id.btDeleteIncidencia);
        deleteIncidencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setMessage("estas seguro de que quieres borrar").setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                             public void onClick(DialogInterface dialog, int id) {
                                 String idToDelete = IdIncidenciaEliminar.getText().toString();
                                 db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE id = "+idToDelete);
                                 Toast.makeText(getContext(), "Incidencia Eliminada", Toast.LENGTH_SHORT).show();
                            }
                        }); builder.setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        final Button buttonDelAll = fEliminar.findViewById(R.id.buttonDelAll);
        buttonDelAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("estas seguro de que quieres borrar").setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+"1=1");
                        Toast.makeText(getContext(), "Todas las Incidencias Eliminadas", Toast.LENGTH_SHORT).show();
                    }
                }); builder.setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });




       //sqlAejecutar = (SQLiteDatabase db) { db.execSQL(SQL_CREATE_ENTRIES); }


        return fEliminar;
    }
}