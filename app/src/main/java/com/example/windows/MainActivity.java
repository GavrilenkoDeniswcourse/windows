package com.example.windows;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickmorning(View view) {
        Intent intent = new Intent(this, morning.class);
        startActivity(intent);
    }

    public void onClickday(View view) {
        Intent intent = new Intent(this, day.class);
        startActivity(intent);
        Toast toast = Toast.makeText(this, "Скоро конец рабочего дня",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickevening(View view) {
        Intent intent = new Intent(this, evening.class);
        startActivity(intent);
        Toast toast = Toast.makeText(this, "СПАТЬ",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClicknight(View view) {
        Intent intent = new Intent(this, night.class);
        startActivity(intent);
    }
}