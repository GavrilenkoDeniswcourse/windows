package com.example.windows;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

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

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "WORKDAY_CHANNEL_ID",
                    "Рабочие уведомления",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    public void onClickmorning(View view) {
        Intent intent = new Intent(this, morning.class);
        startActivity(intent);
    }

    public void onClickday(View view) {
        Intent intent = new Intent(this, day.class);
        startActivity(intent);

                showNotification();

    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "WORKDAY_CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Рабочий день")
                .setContentText("Скоро конец рабочего дня!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat.from(this).notify(1, builder.build());
    }




    public void onClickevening(View view) {
        Intent intent = new Intent(this, evening.class);
        startActivity(intent);
        showEveningNotification();
    }

    private void showEveningNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "WORKDAY_CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Вечер")
                .setContentText("Пора спать!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat.from(this).notify(2, builder.build()); // Используем другой ID (2)
    }


    public void onClicknight(View view) {
        Intent intent = new Intent(this, night.class);
        startActivity(intent);
    }
}
