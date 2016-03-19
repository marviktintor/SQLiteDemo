package com.victor.apps.sqlite;

/**
 * Created by victor on 3/19/2016.
 */
public class TableSchemas {


    public class Information {

        public static final String ITEM_TITLE = "item_title";
        public static final String ITEM_DESCRIPTION = "item_description";
        public static final String TABLE_NAME = "info_table";
        public static final String SQL = "CREATE TABLE " + TABLE_NAME
                + "(" + ITEM_TITLE + " text not null, " + ITEM_DESCRIPTION + " text not null);";
//CREATE TABLE info_table ( item_title text not null, item description text not null);
    }
}
