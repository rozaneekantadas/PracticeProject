package com.suptodas.diu.practiceproject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomPopUpDialog extends AppCompatDialogFragment {

    EditText email, password;
    DialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_pop_up_dialog_layout, null);

        builder.setView(view)
                .setTitle("Log In")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("log in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String uEmail = email.getText().toString();
                String uPassword = password.getText().toString();
                listener.applyTexts(uEmail, uPassword);
            }
        });

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString()+
                    "must bugi jugi");
        }
    }

    public interface DialogListener{
        void applyTexts(String useremail, String userpassword);
    }
}
