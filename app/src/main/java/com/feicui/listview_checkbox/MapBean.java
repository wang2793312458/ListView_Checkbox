package com.feicui.listview_checkbox;

/**
 * Created by AAAAA on 2016/6/21.
 */
public class MapBean {
    private String name;
    private boolean status;

    public MapBean(String name,boolean status){
        this.name=name;
        this.status=status;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
