package com.example.softdevfinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        Button toastOneButton = (Button) findViewById(R.id.toastButtonOne);
        toastOneButton.setOnClickListener(this);

        Button toastTwoButton = (Button) findViewById(R.id.toastButtonTwo);
        toastTwoButton.setOnClickListener(this);

        Button alertButton = (Button) findViewById(R.id.alertButton);
        alertButton.setOnClickListener(this);

        Button newActivityButton = (Button) findViewById(R.id.newActivityButton);
        newActivityButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if ( view.getId() == R.id.toastButtonOne) {
           context = getApplicationContext();
           Toast toast = Toast.makeText(context, "Toast One!!", Toast.LENGTH_LONG);
           toast.show();
        } else if ( view.getId() == R.id.toastButtonTwo ) {
           context = getApplicationContext();
           Toast toast = Toast.makeText(context, "Toast Two!!", Toast.LENGTH_SHORT);
           toast.show();
        } else if ( view.getId() == R.id.alertButton ) {
           showAlertDialog();
        } else if ( view.getId() == R.id.newActivityButton ) {
            startActivity(new Intent(context, AnotherActivity.class));
        }
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this).setTitle("Alert Dialog!").setMessage(
           "This is a message.").setNeutralButton("Blah", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // DO NOTHING!!!!
                            }
        }).show();
    }
}
