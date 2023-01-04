package edu.cs.birzeit.inclassactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2,edt3;
    Button btn1,btn2;
    Switch sw ;
    private Boolean save = false;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String NAME = "NAME";
    public static final String AUTHER = "AUTHER";
    public static final String PAGES = "PAGES";
    private boolean FLAG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.Edt2);
        edt3 = findViewById(R.id.Edt3);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        sw = findViewById(R.id.switch1);
        setupViews();
        setupSharedPrefs();
        checkData();



    }



    private void checkData() {
        Books[] books = new Books[50];
        boolean f =prefs.getBoolean("FLAG",false);
        if(f) {
            String name = prefs.getString(NAME, "");
            String auther = prefs.getString(AUTHER, "");
            String pages = prefs.getString(PAGES, "");

            edt1.setText(name);
            edt2.setText(auther);
            edt3.setText(pages);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!save){
            String name = edt1.getText().toString();
            String auther = edt2.getText().toString();
            String pages = edt3.getText().toString();


            editor.putString(NAME,name);
            editor.putString(AUTHER,auther);
            editor.putString(PAGES,pages);
            editor.putBoolean("FLAG",FLAG);
            editor.commit();
        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }


    private void setupViews(){
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.Edt2);
        edt3 = findViewById(R.id.Edt3);
        btn2 = findViewById(R.id.button2);
        Books[] books = new Books[50];
        int i;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save = false;


            }
        });
    }


}