package com.example.aravindapp4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    AlertDialog alertDialog;

    ListView listView;
    String[] names={"Deepak","Aravind","Kiran","Prasad"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        listView=findViewById(R.id.simple_list);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                simpleMethod1(""+names[i]);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                customMethod1(""+names[i]);
                return true;
            }
        });

        findViewById(R.id.simpleAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                simpleMethod();
            }
        });

        findViewById(R.id.customAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customMethod();
            }
        });
    }

    private void customMethod1(String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
        View root=getLayoutInflater().inflate(R.layout.custom_alert,null);
        builder.setView(root);
        builder.setCancelable(false);

        Button cancel=root.findViewById(R.id.cancel);
        Button confirm=root.findViewById(R.id.confirm);
        TextView username=root.findViewById(R.id.User_text);

        username.setText(""+s+" Please Share your loaction");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AlertActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();

            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AlertActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });


        alertDialog=builder.create();
        alertDialog.show();
    }

    private void simpleMethod1(String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
        builder.setTitle("This is Simple Alert");
        builder.setMessage("Hi welcome to Android Studio "+s);
        builder.setIcon(R.drawable.ic_baseline_location_on_24);
        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(AlertActivity.this, "You Clicked ok", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "You Clicked Cancel", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "You Clicked Help", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.create();
        builder.show();

    }

    private void customMethod() {

        AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
        View root=getLayoutInflater().inflate(R.layout.custom_alert,null);
        builder.setView(root);
        builder.setCancelable(false);

        Button cancel=root.findViewById(R.id.cancel);
        Button confirm=root.findViewById(R.id.confirm);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AlertActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();

            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AlertActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });


        alertDialog=builder.create();
        alertDialog.show();

    }

    private void simpleMethod() {

        AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
        builder.setTitle("This is Simple Alert");
        builder.setMessage("Hi welcome to Android Studio");
        builder.setIcon(R.drawable.ic_baseline_location_on_24);
        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(AlertActivity.this, "You Clicked ok", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "You Clicked Cancel", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertActivity.this, "You Clicked Help", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.create();
        builder.show();
    }
}