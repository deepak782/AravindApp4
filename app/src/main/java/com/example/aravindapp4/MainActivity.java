package com.example.aravindapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText MobileNumber;
    Button Call11,CAM,Brow,Contacts,MAP,Gallery;

    double latitude=17.43190937210369;
    double longitude=78.44631825712314;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileNumber=findViewById(R.id.Enter_Phonenumber);

        findViewById(R.id.Call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+MobileNumber.getText().toString()));
                startActivity(intent);
            }
        });

        Brow=  findViewById(R.id.Browser);
        Brow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/"));
                startActivity(Intent.createChooser(intent, "Title"));

            }
        });
        Contacts= (Button) findViewById(R.id.Contacts);

        Contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);

            }
        });

        MAP= (Button) findViewById(R.id.Map);
        MAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String label = "AndroBIM";

                String uriBegin = "geo:" + latitude + "," + longitude;

                String query = latitude + "," + longitude + "(" + label + ")";

                String encodedQuery = Uri.encode(query);

                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";


                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}