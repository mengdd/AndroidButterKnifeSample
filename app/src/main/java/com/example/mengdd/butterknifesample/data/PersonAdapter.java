package com.example.mengdd.butterknifesample.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mengdd.butterknifesample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonAdapter extends BaseAdapter {
    private LayoutInflater mInflater;

    private List<Person> data;

    public PersonAdapter(Context context, List<Person> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != data) {
            count = data.size();
        }
        return count;
    }

    @Override
    public Person getItem(int position) {
        Person person = null;
        if (null != data) {
            person = data.get(position);
        }
        return person;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.person_item_layout, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.

        Person person = getItem(position);
        if (null != person) {
            holder.name.setText(person.getName());
            holder.age.setText(String.valueOf(person.getAge()));
            holder.location.setText(person.getLocation());
            holder.work.setText(person.getWork());
        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.person_name)
        TextView name;
        @BindView(R.id.person_age)
        TextView age;
        @BindView(R.id.person_location)
        TextView location;
        @BindView(R.id.person_work)
        TextView work;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
