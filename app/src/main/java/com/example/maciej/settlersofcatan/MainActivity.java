package com.example.maciej.settlersofcatan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import helperClasses.Tuple;
import helperClasses.randomOrder;

public class MainActivity extends AppCompatActivity {

    public int pips = 6;
    randomOrder randomOrder;
    Button button;

    void initialize() {
        randomOrder = new randomOrder(pips);
        button = (Button) findViewById(R.id.button);
        ListView listView = (ListView) findViewById(R.id.list_view);
        //final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, randomOrder.tuples);
        final DicesListAdapter dicesListAdapter = new DicesListAdapter(this, randomOrder.tuples);
        listView.setAdapter(dicesListAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomOrder.shuffle();
                dicesListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setTitle(null);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            toolbar.setLogo(R.drawable.catanlogo);
        }
    }

    protected int getImageResource(int i) {
        switch (i) {
            case 1:
                return R.drawable.dice_1;
            case 2:
                return R.drawable.dice_2;
            case 3:
                return R.drawable.dice_3;
            case 4:
                return R.drawable.dice_4;
            case 5:
                return R.drawable.dice_5;
            case 6:
                return R.drawable.dice_6;
        }
        return R.drawable.dice_1;
    }

    class DicesListAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<Tuple> mTuples;

        public DicesListAdapter(Context c, ArrayList<Tuple> t) {
            mContext = c;
            mTuples = t;
        }

        @Override
        public int getCount() {
            return mTuples.size();
        }

        @Override
        public Object getItem(int position) {
            return mTuples.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.dices_view, null);
            } else {
                view = convertView;
            }
            ImageView first = (ImageView) view.findViewById(R.id.first_dice);
            ImageView second = (ImageView) view.findViewById(R.id.second_dice);
            TextView textView = (TextView) view.findViewById(R.id.result);
            first.setImageResource(getImageResource(mTuples.get(position).x));
            second.setImageResource(getImageResource(mTuples.get(position).y));
            textView.setText(Integer.toString(mTuples.get(position).x+mTuples.get(position).y));
            return view;
        }
    }
}


//14:15