package com.feicui.listview_checkbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AAAAA on 2016/6/21.
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<MapBean> mList;

    public MyBaseAdapter(List<MapBean> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);
            viewHolder.item_cb = (CheckBox) convertView.findViewById(R.id.item_cb);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MapBean bean = mList.get(position);
        viewHolder.item_tv.setText(bean.getName());
        viewHolder.item_cb.setChecked(bean.getStatus());
        // 对复选框做监听
        viewHolder.item_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 是在修改list中的MapBean对象的状态
                mList.get(position).setStatus(isChecked);
            }
        });
        return convertView;
    }

    public void RefreashAdapter() {
        notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView item_tv;
        CheckBox item_cb;

    }
}
