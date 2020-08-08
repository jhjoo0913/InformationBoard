package com.kepco.informationboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private Button staffBtn;
    private Button visitorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        staffBtn = findViewById(R.id.button_staff);
        staffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StaffMenuActivity.class);
                startActivityForResult(intent, 1000);
            }
        });
        visitorBtn = findViewById(R.id.button_visitor);
        visitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisitorMenuActivity.class);
                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* if (requestCode == 1000) {
            Toast.makeText(getApplicationContext(), "call : staff", Toast.LENGTH_SHORT)
                    .show();
        } else if (requestCode == 1001) {
            Toast.makeText(getApplicationContext(), "call : visitor", Toast.LENGTH_SHORT)
                    .show();
        }*/
    }
}