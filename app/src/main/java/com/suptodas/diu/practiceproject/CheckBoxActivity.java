package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    TextView ordershow, orderItemShow;
    Button orderButton;
    CheckBox burger, pasta, pizza, fry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        ordershow = findViewById(R.id.orderShow);
        orderItemShow = findViewById(R.id.orderItemShow);

        orderButton = findViewById(R.id.orderButton);

        burger = findViewById(R.id.burgerItem);
        pasta = findViewById(R.id.pastaItem);
        pizza = findViewById(R.id.pizzaItem);
        fry = findViewById(R.id.fryItem);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder builder = new StringBuilder();

                if (burger.isChecked()){
                    builder.append(burger.getText().toString()+"\n");
                }
                if (pasta.isChecked()){
                    builder.append(pasta.getText().toString()+"\n");
                }
                if (pizza.isChecked()){
                    builder.append(pizza.getText().toString()+"\n");
                }
                if (fry.isChecked()){
                    builder.append(fry.getText().toString());
                }

                ordershow.setVisibility(View.VISIBLE);
                orderItemShow.setVisibility(View.VISIBLE);
                orderItemShow.setText(builder);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStar", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
