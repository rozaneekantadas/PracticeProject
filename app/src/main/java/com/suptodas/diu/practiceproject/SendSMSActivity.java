 package com.suptodas.diu.practiceproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class SendSMSActivity extends AppCompatActivity {
     
     static final int REQUEST_CODE = 1;
     EditText phoneNumber, messageText;
     Button sendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        phoneNumber = findViewById(R.id.userPhoneNumber);
        messageText = findViewById(R.id.userMsgText);
        sendSms = findViewById(R.id.sendSms);

        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int permissionCheck = ContextCompat.checkSelfPermission(SendSMSActivity.this, Manifest.permission.SEND_SMS);
                int phoneStatePemission = ContextCompat.checkSelfPermission(SendSMSActivity.this, Manifest.permission.READ_PHONE_STATE);


                if(permissionCheck == PackageManager.PERMISSION_GRANTED && phoneStatePemission == PackageManager.PERMISSION_GRANTED){

                    sendMessage();
                }
                else {

                    ActivityCompat.requestPermissions(SendSMSActivity.this,
                            new String[] {Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE);
                }

            }
        });
        
    }

     private void sendMessage() {

        String number = phoneNumber.getText().toString().trim();
        String msg = messageText.getText().toString();

        if(!number.isEmpty() || !msg.isEmpty()){

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, msg, null, null);

            Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }
     }

     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE){

            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                sendMessage();
            }else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
     }
 }
