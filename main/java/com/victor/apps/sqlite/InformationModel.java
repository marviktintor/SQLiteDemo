package com.victor.apps.sqlite;

/**
 * Created by victor on 3/19/2016.
 */
public class InformationModel {

    String itemTitle;
    String itemDescription;

    public InformationModel(String itemTitle, String itemDescription) {
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
