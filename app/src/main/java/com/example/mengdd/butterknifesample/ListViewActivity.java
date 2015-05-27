package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mengdd.butterknifesample.data.MockDataUtils;
import com.example.mengdd.butterknifesample.data.PersonAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ListViewActivity extends AppCompatActivity {

    @InjectView(R.id.my_list_view)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.inject(this);

        PersonAdapter adapter = new PersonAdapter(this, MockDataUtils.getPersons());
        mListView.setAdapter(adapter);

    }

}
