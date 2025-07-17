package com.bynaric.internshipcodealpha;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSeminar, btnExam, btnFest, btnNotice, btnViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSeminar = findViewById(R.id.btnSeminar);
        btnExam = findViewById(R.id.btnExam);
        btnFest = findViewById(R.id.btnFest);
        btnNotice = findViewById(R.id.btnNotice);
        btnViewEvents = findViewById(R.id.btnViewEvents);

        createNotificationChannel();

        btnSeminar.setOnClickListener(v -> {
            showInstantNotification("Seminar Alert", "AI Seminar at 3 PM");
            openEventScreen("Seminar", "AI Seminar at 3 PM in Hall A.");
        });
        
        btnExam.setOnClickListener(v -> {
            scheduleNotification("Exam Reminder", "Your Math Exam starts soon!", 10);
            openEventScreen("Exam", "Math Exam at 9:00 AM in Room 102.");
        });

        btnFest.setOnClickListener(v -> {
            showInstantNotification("Fest Update", "Cultural Fest tonight!");
            openEventScreen("Fest", "Cultural Fest: Singing, Dance, Food stalls.");
        });

        btnNotice.setOnClickListener(v -> {
            showInstantNotification("Important Notice", "Holiday tomorrow!");
            openEventScreen("Notice", "Tomorrow is declared a holiday due to weather.");
        });



        // Optional: Show full event list
        btnViewEvents.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EventListActivity.class);
            startActivity(intent);
        });
    }

    // ✅ FIXED: This method should be outside onCreate()
    private void openEventScreen(String title, String desc) {
        Intent intent = new Intent(MainActivity.this, EventDetailsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        startActivity(intent);
    }

    private void showInstantNotification(String title, String message) {
        Intent intent = new Intent(this, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        sendBroadcast(intent);
    }

    private void scheduleNotification(String title, String message, int delaySeconds) {
        Intent intent = new Intent(this, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                (int) System.currentTimeMillis(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerTime = System.currentTimeMillis() + delaySeconds * 1000L;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CampusEventsChannel";
            String description = "Channel for campus event notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("campus_events_channel", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
