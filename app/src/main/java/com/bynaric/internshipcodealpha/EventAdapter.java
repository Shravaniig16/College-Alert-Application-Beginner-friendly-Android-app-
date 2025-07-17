package com.bynaric.internshipcodealpha;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Event> eventList;

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView icon, title, time;

        public EventViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.eventIcon);
            title = itemView.findViewById(R.id.eventTitle);
            time = itemView.findViewById(R.id.eventTime);
        }
    }

    public EventAdapter(List<Event> events) {
        this.eventList = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.icon.setText(event.getIcon());
        holder.title.setText(event.getTitle());
        holder.time.setText(event.getTime());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}

