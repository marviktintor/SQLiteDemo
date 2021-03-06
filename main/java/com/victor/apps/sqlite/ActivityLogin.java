package com.victor.apps.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by victor on 3/19/2016.
 */
public class ActivityLogin extends Activity implements View.OnClickListener {

    Button btLogin;
    Button btSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
    }

    void findViews() {
        btLogin = (Button) findViewById(R.id.activity_login_button_login);
        btSignup = (Button) findViewById(R.id.activity_login_button_signup);

        btLogin.setOnClickListener(this);
        btSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btLogin) {
            //Navigate user to login

            Intent intent = new Intent(getApplicationContext(), RegisterInformation.class);
            startActivity(intent);
        }
        if (view == btSignup) {
            //Navigate user to item details

            Intent intent = new Intent(getApplicationContext(), ActivitySignup.class);
            startActivity(intent);
        }
    }
}
