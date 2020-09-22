package com.suptodas.diu.practiceproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneCallActivity extends AppCompatActivity {

    static final int REQUEST_CALL = 1;
    EditText phoneNumber;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        phoneNumber = findViewById(R.id.phoneNumber);
        call = findViewById(R.id.callButton);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
    }

    public void makePhoneCall(){

        if(phoneNumber.getText().toString().trim().length() > 0){

            if(ContextCompat.checkSelfPermission(PhoneCallActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(PhoneCallActivity.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else {
                String number = "tel:" +phoneNumber.getText().toString().trim();
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(number)));
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
