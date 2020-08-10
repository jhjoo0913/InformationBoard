package com.kepco.informationboard.HomeMenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kepco.informationboard.ConstructionMenu.ConstructionFragment;
import com.kepco.informationboard.R;
import com.kepco.informationboard.TroubleCaseMenu.TroubleCaseFragment;

public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private ConstructionFragment constructionFragment;
    private TroubleCaseFragment troubleCaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        constructionFragment = new ConstructionFragment();
        troubleCaseFragment = new TroubleCaseFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, mainFragment)
                    .commit();
        }
    }

    public void onFragmentChange(int index) {
        if (index == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, mainFragment)
                    .commit();
        }
        else if (index == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, constructionFragment)
                    .commit();
        }
        else if (index == 2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, troubleCaseFragment)
                    .commit();
        }
    }

}