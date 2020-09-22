package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void clickMe(View view){

        if (view.getId() == R.id.webViewShow){
            Intent intent = new Intent(this, WebView.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.popUpDialogShow){
            Intent intent = new Intent(this, CustomProgressBar.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.progressBarShow){
            Intent intent = new Intent(this, ProgressbarActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.snackbarShow){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.checkboxShow){
            Intent intent = new Intent(this, CheckBoxActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.emailShow){
            Intent intent = new Intent(this, SendEmailActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.phoneCallShow){
            Intent intent = new Intent(this, PhoneCallActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.smsSendShow){
            Intent intent = new Intent(this, SendSMSActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.radioButtonShow){
            Intent intent = new Intent(this, RadioButton.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.imageCaptureUsingCamera){
            Intent intent = new Intent(this, CaptureImage.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.sharedPreferancesTask){
            Intent intent = new Intent(this, SharedPreferencesActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.musicPlayerOpen){
            Intent intent = new Intent(this, MusicPlayerActivity.class);
            startActivity(intent);
        }
    }
}
