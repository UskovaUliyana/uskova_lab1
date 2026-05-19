package com.example.uskovalab1;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
public class MainActivity extends AppCompatActivity implements UskovaFragment.OnFragmentActionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UskovaFragment fragment = new UskovaFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.uskova_container, fragment);
        transaction.commit();
    }
    @Override
    public void onOpenSettingsClick() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    @Override
    public void onOpenAboutClick() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}