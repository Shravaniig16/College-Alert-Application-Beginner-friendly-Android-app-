package com.bynaric.internshipcodealpha;



import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView eventTitle = findViewById(R.id.eventTitle);
        TextView eventDesc = findViewById(R.id.eventDesc);

        // Get data passed from MainActivity
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        eventTitle.setText(title);
        eventDesc.setText(desc);
    }
}

