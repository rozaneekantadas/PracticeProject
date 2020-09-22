package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Switch aSwitch;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    public String text;
    public boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        textView = findViewById(R.id.showSavedText);
        editText = findViewById(R.id.editTextSave);
        aSwitch = findViewById(R.id.switch1);

        loadData();
        updatesData();
    }

    public void clickMeToSave(View view){

        if(view.getId() == R.id.applyText){

            textView.setText(editText.getText().toString());
        }

        if(view.getId() == R.id.saveData){
            saveData();
        }

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.putBoolean(SWITCH1, aSwitch.isChecked());

        editor.apply();

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updatesData(){
        textView.setText(text);
        aSwitch.setChecked(switchOnOff);
    }
}
