package com.example.loginactivity.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    TextView homeTextView;
    EditText homeEditText;
    Button submitText;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        homeTextView = v.findViewById(R.id.tv_text);
        homeEditText = v.findViewById(R.id.et_text);
        submitText = v.findViewById(R.id.btn_submitText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Confirmation").setMessage("Are you sure to edit the text?")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                homeTextView.setText(homeEditText.getText().toString());
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Edit text is cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        dialog = builder.create();

        submitText.setOnClickListener(view -> {
            dialog.show();
        });

        return v;
    }
}