package com.example.uskovalab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UskovaFragment extends Fragment {

    private EditText uskovaInput;
    private Button uskovaBtn;
    private TextView uskovaText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uskova, container, false);

        uskovaInput = view.findViewById(R.id.uskovaInput);
        uskovaBtn = view.findViewById(R.id.uskovaBtn);
        uskovaText = view.findViewById(R.id.uskovaText);

        uskovaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = uskovaInput.getText().toString();

                if (input.isEmpty()) {
                    uskovaText.setText("Ты ничего не ввел!");
                    Toast.makeText(getActivity(), "Пусто! Введи текст!", Toast.LENGTH_SHORT).show();
                } else {
                    uskovaText.setText("Ты написал: " + input);
                    Toast.makeText(getActivity(), getString(R.string.uskova_toast) + input, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}