package com.example.stud.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbOpcja1;
    RadioButton rbOpcja2;
    Spinner spinner;
    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rbOpcja1 = findViewById(R.id.rbOpcja1);
        rbOpcja2 = findViewById(R.id.rbOpcja2);
        spinner = findViewById(R.id.spinner);
        String[] planety = { "Merkury" , "Wenus" , "Ziemia" , "Mars" , "Jowisz" , "Saturn" ,
                "Uran" , "Neptun" };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wartosc = "";

                if(view.getId() == R.id.rbOpcja2)
                {
                    wartosc = "Wybrano opcje 1";

                }
                else if (view.getId() == R.id.rbOpcja2)
                {
                    wartosc = "Click!";

                }

                Toast.makeText( MainActivity.this,
                        wartosc,
                        Toast.LENGTH_SHORT).show();

            }
        };
        rbOpcja1.setOnClickListener(listener);
        rbOpcja2.setOnClickListener(listener);


        ArrayAdapter<String> adapter = new ArrayAdapter<>( this ,
                android.R.layout. simple_spinner_item , planety);

        adapter.setDropDownViewResource(android.R.layout. simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] planety = getResources().getStringArray(R.array.planety);

                Toast.makeText(MainActivity.this, planety[i],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void  onNothingSelected(AdapterView<?>) adapterView)
            {
        });
    }
}
