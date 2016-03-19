package com.victor.apps.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by victor on 3/19/2016.
 */
public class InformationAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<InformationModel> informationModelList;

    public InformationAdapter(Context context, int layout, List<InformationModel> informationModelList) {
        this.context = context;
        this.layout = layout;
        this.informationModelList = informationModelList;
    }

    @Override
    public int getCount() {
        return informationModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();
        viewHolder.setData(position);
        return view;
    }

    class ViewHolder {
        TextView tvItemTitle;
        TextView tvItemDescription;

        public ViewHolder(View view) {
            tvItemDescription = (TextView) view.findViewById(R.id.list_registered_item_description);
            tvItemTitle = (TextView) view.findViewById(R.id.list_registered_item_title);
        }

        public void setData(int position) {
            tvItemDescription.setText(informationModelList.get(position).getItemDescription());
            tvItemTitle.setText(informationModelList.get(position).getItemTitle());
        }
    }
}
