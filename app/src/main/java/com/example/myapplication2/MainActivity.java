package com.example.myapplication2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String SAVED_TEXT = "asd";
    Button btnLoad;
    Button btnSave;
    Button btnOk;
    Button btnCansel;
    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        etText = findViewById(R.id.etText);
        loadText();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    void saveText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    void loadText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
// по id определяем кнопку, вызвавшую этот обработчик
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (v.getId()) {
            case R.id.btnSave:
                // кнопкаОК
                //Log.d(TAG, "кнопкаОК");
                saveText();
                //tvOut.setText("НажатакнопкаОК");
                //Toast.makeText(this, "Нажата кнопка Save", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnLoad:
                // кнопка Cancel
                //Log.d(TAG, "кнопка Cancel");
                loadText();
                //tvOut.setText("Нажатакнопка Cancel");
                //Toast.makeText(this, "Нажата кнопка Load", Toast.LENGTH_LONG).show();
                break;

        }
    }
}