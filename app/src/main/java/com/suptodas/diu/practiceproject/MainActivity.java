package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button snackBar;
    FloatingActionButton floatingActionButton;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snackBar = findViewById(R.id.button);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        coordinatorLayout = findViewById(R.id.containSnackbar);

        snackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Snackbar snackbar = Snackbar.make(coordinatorLayout, "This is a snackbar", Snackbar.LENGTH_LONG);
                snackbar.setDuration(10000);
//                snackbar.setAnchorView(floatingActionButton);
                snackbar.setAction("Okay", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackBar.setText("Hi..");
                    }
                });
                snackbar.show();
            }
        });
    }
}
