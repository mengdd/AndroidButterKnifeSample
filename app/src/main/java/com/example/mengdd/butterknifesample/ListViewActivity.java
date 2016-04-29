package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mengdd.butterknifesample.data.MockDataUtils;
import com.example.mengdd.butterknifesample.data.PersonAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;


public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.my_list_view)
    ListView mListView;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        adapter = new PersonAdapter(this, MockDataUtils.getPersons());
        mListView.setAdapter(adapter);

    }

    @OnItemClick(R.id.my_list_view)
    void onItemClick(int position) {//though there are 4 parameters, you can just write the one you want to use
        Toast.makeText(this, "You clicked: " + adapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @OnItemLongClick(R.id.my_list_view)
    boolean onItmeLongClick(int position) {
        Toast.makeText(this, "You Long Click: " + adapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
        return true; //if return false, the onItemClick() will be invoked when touch up
    }

}
