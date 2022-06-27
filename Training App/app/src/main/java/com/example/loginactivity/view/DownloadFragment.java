package com.example.loginactivity.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.loginactivity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DownloadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DownloadFragment extends Fragment {

    Button downloadBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_download, container, false);

        downloadBtn = v.findViewById(R.id.btn_download);

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("File");
        progressDialog.setMessage("Downloading...");
        progressDialog.setCancelable(true);

        downloadBtn.setOnClickListener(view -> {
            progressDialog.show();
        });

        return v;
    }
}