package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {

    EditText to, subject, message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        to = findViewById(R.id.emailTo);
        subject = findViewById(R.id.emailSub);
        message = findViewById(R.id.emailText);
        send = findViewById(R.id.emailSend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String receiverList = to.getText().toString();
                String[] receiver = receiverList.split(",");

                //Single Email Implement
//                Intent intent = new Intent(Intent.ACTION_VIEW
//                , Uri.parse("mailto:"+receiverList));
//                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
//                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
//                startActivity(intent);


                //Multiple Email Implement
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, receiver);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });

    }
}
