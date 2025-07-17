package com.bynaric.internshipcodealpha;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class EventListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Event> events = Arrays.asList(
                new Event("📝", "Math Exam", "July 19, 10:00 AM"),
                new Event("🎉", "Cultural Fest", "July 20, 6:00 PM"),
                new Event("📢", "Holiday Notice", "College closed on July 21"),
                new Event("🔔", "AI Seminar", "July 22, 2:00 PM")
        );

        adapter = new EventAdapter(events);
        recyclerView.setAdapter(adapter);
    }
}

