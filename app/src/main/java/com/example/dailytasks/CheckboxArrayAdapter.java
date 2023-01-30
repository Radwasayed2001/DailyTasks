package com.example.dailytasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.os.Handler;

import com.example.dailytasks.R;

import java.util.ArrayList;
import java.util.List;

public class CheckboxArrayAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private List<String> mItems;
    private Handler mHandler = new Handler();
    public CheckboxArrayAdapter(Context context, int resource, ArrayList<String> items) {
        super(context, resource, items);
        mContext = context;
        mItems = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.style, parent, false);
        }

        String item = mItems.get(position);
        CheckBox checkBox = convertView.findViewById(R.id.tvlist);
        checkBox.setText(item);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mItems.remove(position);
                            notifyDataSetChanged();
                        }
                    }, 1000);  // delay for 1 second
                }
            }
        });
        return convertView;
    }
}
