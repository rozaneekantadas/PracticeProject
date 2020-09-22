package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButton extends AppCompatActivity {

    RadioGroup radioGroup;
    android.widget.RadioButton radioButton;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = findViewById(R.id.radioGroup);
        apply = findViewById(R.id.apply);
        final TextView textView = findViewById(R.id.showRadioButtonText);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Your Selection: "+radioButton.getText());
            }
        });
    }

    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Your are slected: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
