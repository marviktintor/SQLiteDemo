package com.victor.apps.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity that register informarion into the datbate....
 * Created by victor on 3/19/2016.
 */
public class RegisterInformation extends Activity {
    EditText etItemTitle;
    EditText etItemDescription;
    Button btSaveInformation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_information);

        findViews();
    }

    void findViews() {

        //finding the views in the latoutys...
        etItemTitle = (EditText) findViewById(R.id.editText_item_title);
        etItemDescription = (EditText) findViewById(R.id.editText_item_description);
        btSaveInformation = (Button) findViewById(R.id.buttonSave);

        btSaveInformation.setOnClickListener(saveInformationClickListener);

        findViewById(R.id.buttonRegisteredInformation).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisteredInformation.class));
            }
        });
    }

    View.OnClickListener saveInformationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btSaveInformation) {
                saveInformation();
            }
        }
    };

    private void saveInformation() {
        String itemTitle = etItemTitle.getText().toString();
        String itemDescription = etItemDescription.getText().toString();

        boolean valid = true;
        if (itemTitle.equals("")) {
            valid = false;
            etItemTitle.setError("Cannot be null");
        }
        if (itemDescription.equals("")) {
            valid = false;
            etItemDescription.setError("Cannot be null");
        }

        if (valid) {
            DatabaseEngine databaseEngine = new DatabaseEngine(RegisterInformation.this);
            SQLiteDatabase sqLiteDatabase = databaseEngine.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TableSchemas.Information.ITEM_TITLE, itemTitle);
            values.put(TableSchemas.Information.ITEM_DESCRIPTION, itemDescription);
            sqLiteDatabase.insert(TableSchemas.Information.TABLE_NAME, null, values);

            resetEditTexts();
        }
    }

    private void resetEditTexts() {
        etItemDescription.setText("");
        etItemTitle.setText("");
        Toast.makeText(RegisterInformation.this, "Data Saved", Toast.LENGTH_SHORT).show();
    }


}
