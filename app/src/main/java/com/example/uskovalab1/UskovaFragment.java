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

import butterknife.BindView;
import butterknife.ButterKnife;

public class UskovaFragment extends Fragment {

    @BindView(R.id.uskovaInput)
    EditText uskovaInput;

    @BindView(R.id.uskovaBtn)
    Button uskovaBtn;

    @BindView(R.id.uskovaText)
    TextView uskovaText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uskova, container, false);
        ButterKnife.bind(this, view);

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

        return view;
    }
}