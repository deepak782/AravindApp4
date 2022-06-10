package com.example.aravindapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    ListView listView;
    UserAdapter userAdapter;
    UserModel userModel;
    List<UserModel> userModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        listView=findViewById(R.id.user_list);

        loadData();
    }

    private void loadData() {
        userModel=new UserModel("Deepak","9000733771","+919000733771","https://developer.android.com/",17.43190937210369,78.44631825712314);
        userModelList.add(userModel);

        userModel=new UserModel("Kiran","9493094950","+919493094950","https://developer.android.com/",17.485251979099733, 78.38847010582663);
        userModelList.add(userModel);

        userModel=new UserModel("Prasad","9494872785","+9194948727885","https://developer.android.com/",17.435786846897553, 78.44467269826208);
        userModelList.add(userModel);

        userModel=new UserModel("Aravind","9182792904","+99182792904","https://developer.android.com/",17.407316947170873, 78.37365710382315);
        userModelList.add(userModel);

        userAdapter=new UserAdapter(getApplicationContext(),userModelList);
        listView.setAdapter(userAdapter);

    }

}