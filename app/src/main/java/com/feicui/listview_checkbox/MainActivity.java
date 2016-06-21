package com.feicui.listview_checkbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<MapBean> list;
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        //  对lv进行数据绑定
        list = getLoadData();

        adapter = new MyBaseAdapter(list);
        lv.setAdapter(adapter);
    }

    public List<MapBean> getLoadData() {

        List<MapBean> list = new ArrayList<MapBean>();

        for (int i = 0; i < 40; i++) {
            MapBean bean = new MapBean("Uname_" + i, false);
            list.add(bean);
        }

        return list;
    }

    public void btnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel://取消按钮
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStatus(false);
                }
                //notifyDataSetChanged意思是不用刷新listview
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_selectall://全选按钮
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStatus(true);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_reverse://反选按钮
                for (int i = 0; i < list.size(); i++) {
                    boolean flag = list.get(i).getStatus();
                    if (flag) {
                        list.get(i).setStatus(false);
                    } else {
                        list.get(i).setStatus(true);
                    }
                }
                adapter.RefreashAdapter();
                break;
            case R.id.btn_delete:  //删除按钮
                List<MapBean> templist = new ArrayList<MapBean>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getStatus()) {
                        templist.add(list.get(i));
                    }
                }
                list.removeAll(templist);

                adapter.notifyDataSetChanged();
                break;
        }
    }
}
