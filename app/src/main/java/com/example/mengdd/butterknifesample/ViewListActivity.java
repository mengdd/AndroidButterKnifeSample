package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ViewListActivity extends AppCompatActivity {

    @BindViews({R.id.label_first_name, R.id.label_middle_name, R.id.label_last_name})
    List<TextView> labelViews;

    @BindViews({R.id.first_name, R.id.middle_name, R.id.last_name})
    List<EditText> nameViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button_disable)
    void disableEditViews() {
        ButterKnife.apply(nameViews, DISABLE);
    }


    @OnClick(R.id.button_enable)
    void enableEditViews() {
        ButterKnife.apply(nameViews, ENABLED, true);
    }

    @OnClick(R.id.button_alpha_0)
    void labelAlphaTo0() {
        //Property
        ButterKnife.apply(labelViews, View.ALPHA, 0f);
    }

    @OnClick(R.id.button_alpha_1)
    void labelAlphaTo1() {
        ButterKnife.apply(labelViews, View.ALPHA, 1f);
    }

    //Action
    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };

    //Setter
    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };


    //you can bind listener to multiple views
    @OnClick({R.id.button_enable, R.id.button_disable, R.id.button_alpha_0, R.id.button_alpha_1})
    void editViewsClicked() {
        Toast.makeText(this, "You click the Button!", Toast.LENGTH_SHORT).show();
    }

}
