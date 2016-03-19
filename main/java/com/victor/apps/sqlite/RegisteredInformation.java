package com.victor.apps.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 3/19/2016.
 */
public class RegisteredInformation extends Activity {

    ListView lvRegisteredInformation;
    List<InformationModel> informationModelList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered_information);

        findViews();
    }

    private void findViews() {
        lvRegisteredInformation = (ListView) findViewById(R.id.listView_registered_items);
        populateListData();
    }

    /**
     * Reads the data in the databse and  populate a list
     */
    private void populateListData() {

        DatabaseEngine databaseEngine = new DatabaseEngine(RegisteredInformation.this);
        SQLiteDatabase sqLiteDatabase = databaseEngine.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TableSchemas.Information.TABLE_NAME, null, null, null, null, null, null);

        informationModelList = new ArrayList<>(cursor.getCount());

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            String title = cursor.getString(cursor.getColumnIndex(TableSchemas.Information.ITEM_TITLE));
            String description = cursor.getString(cursor.getColumnIndex(TableSchemas.Information.ITEM_DESCRIPTION));

            informationModelList.add(new InformationModel(title, description));

        }

        //Add data to listview

        createCustomListView();

    }

    private void createCustomListView() {

        InformationAdapter informationAdaper = new InformationAdapter(RegisteredInformation.this,R.layout.list_registered_info,informationModelList);
        lvRegisteredInformation.setAdapter(informationAdaper);

    }

    private void createSimpleListView() {

        List<String> infoModelList = new ArrayList<>();
        for (InformationModel informationModel : informationModelList) {
            infoModelList.add(informationModel.getItemTitle());
        }
        ArrayAdapter<String>listAdapter = new ArrayAdapter<String>(RegisteredInformation.this,android.R.layout.simple_list_item_1,infoModelList);
        lvRegisteredInformation.setAdapter(listAdapter);
    }


}
