package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class SimpleActivity extends AppCompatActivity {

    //ButterKnife can be used to findViews

    @BindView(R.id.simple_activity_text_view)
    TextView mTextView;
    //this field should not be declared private or static


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        // ButterKnife.inject(this) should be called after setContentView()
        ButterKnife.bind(this);

        //you do not need to write:
        //mTextView = (TextView)findViewById(R.id.simple_activity_text_view);
        //mTextView can be used directly
        mTextView.setText("TextView is found!");
    }

    @OnClick(R.id.simple_activity_button)
    void onButtonClick(View view) {
        //this method handle the onClick event for the View specified by id
        //the method should not be declared private or static
        //you can write the parameter (View view) as above or just write onButtonClick() leave parameters empty, both are ok

        Toast.makeText(this, "Button Click!", Toast.LENGTH_SHORT).show();

        //Without ButterKnife, you may write things like that:

        //        Button button = (Button) findViewById(R.id.simple_activity_button);
        //        button.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast.makeText(SimpleActivity.this, "Button Click!", Toast.LENGTH_SHORT).show();
        //            }
        //        });

        //now it's unnecessary.


    }

    //bind event to CheckBox
    @OnCheckedChanged(R.id.simple_activity_checkbox)
    void onCheckedChanged(CompoundButton button, boolean checked) {
        Toast.makeText(this, "CheckBox Changed! " + checked, Toast.LENGTH_SHORT).show();
    }

}
