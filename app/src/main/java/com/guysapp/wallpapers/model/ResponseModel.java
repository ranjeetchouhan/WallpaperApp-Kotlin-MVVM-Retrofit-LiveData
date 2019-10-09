package com.guysapp.wallpapers.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("data")
    List<DataItem> dataItem;

    public List<DataItem> getDataItem() {
        return dataItem;
    }

    public void setDataItem(List<DataItem> dataItem) {
        this.dataItem = dataItem;
    }
}
