package com.example.poczta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radioList, radioPaczka, radioPocztowka;
    ImageView imageView;
    TextView textCena;
    EditText editUlica, editKod, editMiasto;
    Button btnSprawdz, btnZatwierdz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioList = findViewById(R.id.radioList);
        radioPaczka = findViewById(R.id.radioPaczka);
        radioPocztowka = findViewById(R.id.radioPocztowka);
        imageView = findViewById(R.id.imageView);
        textCena = findViewById(R.id.textCena);
        editUlica = findViewById(R.id.editUlica);
        editKod = findViewById(R.id.editKod);
        editMiasto = findViewById(R.id.editMiasto);
        btnSprawdz = findViewById(R.id.buttonSprawdz);
        btnZatwierdz = findViewById(R.id.buttonZatwierdz);

        btnSprawdz.setOnClickListener(v -> {
            if (!radioList.isChecked() && !radioPaczka.isChecked() && !radioPocztowka.isChecked()) {
                Toast.makeText(MainActivity.this,
                        "Wybierz rodzaj przesyłki", Toast.LENGTH_SHORT).show();
                return;
            }

            if (radioPocztowka.isChecked()) {
                imageView.setImageResource(R.drawable.pocztowka); //  obrazek pocztowki
                textCena.setText("Cena: 1 zł");
            } else if (radioList.isChecked()) {
                imageView.setImageResource(R.drawable.list); //  obrazek listu
                textCena.setText("Cena: 1.5 zł");
            } else {
                imageView.setImageResource(R.drawable.paczka); //  obrazek paczki
                textCena.setText("Cena: 12 zł");

            }
        });

        btnZatwierdz.setOnClickListener(v -> {
            String kod = editKod.getText().toString();

// Kod musi mieć 5 cyfr
            if (kod.length() != 5 || !kod.matches("\\d{5}")) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Błąd")
                        .setMessage("Kod pocztowy musi mieć dokładnie 5 cyfr.")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Sukces")
                    .setMessage("Przesyłka została nadana.")
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}


