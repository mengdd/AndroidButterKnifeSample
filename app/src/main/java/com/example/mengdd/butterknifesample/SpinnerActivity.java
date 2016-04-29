package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.my_spinner)
    Spinner mSpinner;
    private ArrayAdapter<CharSequence> adapter;
    private List<CharSequence> items;
    private String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        // Create an ArrayAdapter using the string array and a default spinner layout

        //adapter = ArrayAdapter.createFromResource(this,
        // R.array.planets_array, android.R.layout.simple_spinner_item);//in this way, the data can not be changed

        strings = getResources().getStringArray(R.array.planets_array);
        items = new ArrayList<CharSequence>(Arrays.asList(strings));
        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        //Previously, the onItemSelectedListener is set in this way:
        /*
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

    }

    @OnClick(R.id.clear_spinner_data)
    void clearSpinnerData() {
        adapter.clear();
    }

    @OnClick(R.id.set_spinner_data)
    void setSpinnerData() {
        items = new ArrayList<CharSequence>(Arrays.asList(strings));
        adapter.addAll(items);

    }

    @OnItemSelected(R.id.my_spinner)
        //default callback : ITEM_SELECTED
    void onItemSelected(int position) {
        Toast.makeText(this, "position: " + position, Toast.LENGTH_SHORT).show();
    }

    @OnItemSelected(value = R.id.my_spinner, callback = OnItemSelected.Callback.NOTHING_SELECTED)
    void onNothingSelected() {
        Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
    }
}
