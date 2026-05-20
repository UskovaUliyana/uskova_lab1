package com.example.uskovalab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.otto.Subscribe;

public class SecondFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        textView = view.findViewById(R.id.secondText);
        textView.setText("Второй фрагмент\nУскова Ульяна, ИВТ-254");

        Button btnSendEvent = view.findViewById(R.id.btnSendEvent);
        btnSendEvent.setOnClickListener(v -> {
            BusApp.getBus().post(new MessageEvent("Привет из SecondFragment!"));
        });
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.childContainer, new ChildFragment())
                .commit();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        BusApp.getBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusApp.getBus().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getActivity(), "Получено: " + event.message, Toast.LENGTH_SHORT).show();
    }
}