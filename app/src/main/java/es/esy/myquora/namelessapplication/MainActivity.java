package es.esy.myquora.namelessapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private ArrayList<Event> eventList;
    private EventLogAdapter adapter;

    //private ArrayAdapter<String> adapter;
    //private ArrayList<String> listItems;

    private EditText mEditTextDate;
    private EditText mEditTextDescription;
    private EditText mEditTextAmount;
    private Spinner mSpinnerTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextDate = (EditText)findViewById(R.id.editTextDate);
        mEditTextDescription = (EditText)findViewById(R.id.editTextDescription);
        mEditTextAmount = (EditText)findViewById(R.id.editTextAmount);
        mSpinnerTag = (Spinner)findViewById(R.id.spinnerTag);

        String[] tags = new String[]{"Food", "Fuel", "House Rent", "Luxury", "Necessities"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tags);
        mSpinnerTag.setAdapter(spinnerAdapter);

        mEditTextDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        mListView = (ListView) findViewById(R.id.logList);

        eventList = new ArrayList<Event>();
        eventList.add(new Event("22/05/2017", "Fruits from market", "Food",300));
        eventList.add(new Event("21/05/2017", "Dinner at Shalimar", "Luxury",1500));
        adapter = new EventLogAdapter(this, eventList);

        mListView.setAdapter(adapter);

    }


    public void buttonClick(View v){

        String tag = mSpinnerTag.getSelectedItem().toString();
        String date = mEditTextDate.getText().toString().trim();
        String description = mEditTextDescription.getText().toString().trim();

        String stringAmount = mEditTextAmount.getText().toString().trim();

        if (TextUtils.isEmpty(date) || TextUtils.isEmpty(description) || TextUtils.isEmpty(stringAmount)){
            Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            adapter.add(new Event(date,description,tag,Float.valueOf(stringAmount)));
        }
    }
}
