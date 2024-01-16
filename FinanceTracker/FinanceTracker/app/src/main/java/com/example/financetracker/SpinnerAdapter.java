package com.example.financetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter{
    private Context context;
    private List<Spinner_Item> itemList;

    public SpinnerAdapter(Context context, List<Spinner_Item> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.spinner_item, null);

        TextView itemNameTextView = view.findViewById(R.id.itemNameTextView);
        ImageView itemImageView = view.findViewById(R.id.itemImageView);

        Spinner_Item currentItem = itemList.get(position);

        itemNameTextView.setText(currentItem.getItemName());
        itemImageView.setImageResource(currentItem.getItemImageResId());

        return view;
    }
}
