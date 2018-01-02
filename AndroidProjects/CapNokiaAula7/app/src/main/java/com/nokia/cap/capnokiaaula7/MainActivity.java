package com.nokia.cap.capnokiaaula7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nokia.cap.nokiacaplibrary.NokiaCapModule;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, NokiaCapModule.class);
        startActivity(intent);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        findViewById(R.id.nokia_cap_button);

        switch (id) {
            case R.id.nokia_cap_button:

                Intent intent = new Intent(this, NokiaCapModule.class);
                startActivity(intent);
                break;
        }


    }
}
