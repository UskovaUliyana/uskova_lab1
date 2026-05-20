package com.example.uskovalab1;

import android.content.Context;
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
    private Button btnSettings;
    private Button btnAbout;
    private Button btnSecond;
    private OnFragmentActionListener callback;

    public interface OnFragmentActionListener {
        void onOpenSettingsClick();
        void onOpenAboutClick();
        void onOpenDetailsClick();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uskova, container, false);

        uskovaInput = view.findViewById(R.id.uskovaInput);
        uskovaBtn = view.findViewById(R.id.uskovaBtn);
        uskovaText = view.findViewById(R.id.uskovaText);
        btnSettings = view.findViewById(R.id.btnSettings);
        btnAbout = view.findViewById(R.id.btnAbout);
        btnSecond = view.findViewById(R.id.btnSecond);

        uskovaBtn.setOnClickListener(v -> {
            String input = uskovaInput.getText().toString();
            if (input.isEmpty()) {
                uskovaText.setText("Пустая строка!");
                Toast.makeText(getActivity(), "Пусто! Введи текст!", Toast.LENGTH_SHORT).show();
            } else {
                uskovaText.setText("Результат: " + input);
                Toast.makeText(getActivity(), "Вы ввели: " + input, Toast.LENGTH_SHORT).show();
            }
        });

        btnSettings.setOnClickListener(v -> {
            if (callback != null) callback.onOpenSettingsClick();
        });

        btnAbout.setOnClickListener(v -> {
            if (callback != null) callback.onOpenAboutClick();
        });

        btnSecond.setOnClickListener(v -> {
            if (callback != null) callback.onOpenDetailsClick();
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentActionListener) {
            callback = (OnFragmentActionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}