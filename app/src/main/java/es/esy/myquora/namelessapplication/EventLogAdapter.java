package es.esy.myquora.namelessapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by praneet on 14/05/17.
 */

public class EventLogAdapter extends ArrayAdapter<Event> {

    public EventLogAdapter(Context context, ArrayList<Event> events){
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Event event = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_layout, parent, false);
        }

        // Lookup view for data population
        TextView textViewEventHead = (TextView) convertView.findViewById(R.id.textViewEventHead);
        TextView textViewEventAmount = (TextView) convertView.findViewById(R.id.textViewEventAmount);
        TextView textViewEventDescription = (TextView) convertView.findViewById(R.id.textViewEventDescription);
        TextView textViewEventDate = (TextView) convertView.findViewById(R.id.textViewEventDate);


        // Populate the data into the template view using the data object
        textViewEventHead.setText(String.valueOf(event.mTag.charAt(0)));
        textViewEventAmount.setText(Float.toString(event.mAmount));
        textViewEventDescription.setText(event.mDescription);
        textViewEventDate.setText(event.mDate);

        // Return the completed view to render on screen
        return convertView;
    }


}
