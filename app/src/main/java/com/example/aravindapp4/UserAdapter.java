package com.example.aravindapp4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    Context context;
    List<UserModel> userModelList=new ArrayList<>();
    LayoutInflater layoutInflater;

    public UserAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.custom_layout,null);
        TextView name=root.findViewById(R.id.user_name);
        ImageView phone=root.findViewById(R.id.user_phone);
        ImageView loc=root.findViewById(R.id.user_loc);
        ImageView whatsapp=root.findViewById(R.id.user_whatsApp);
        ImageView browser=root.findViewById(R.id.user_website);

        name.setText(userModelList.get(i).getName());

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+userModelList.get(i).getMobile()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String label = "AndroBIM";

                String uriBegin = "geo:" + userModelList.get(i).getLat() + "," + userModelList.get(i).getLng();

                String query = userModelList.get(i).getLat() + "," + userModelList.get(i).getLng() + "(" + label + ")";

                String encodedQuery = Uri.encode(query);

                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";


                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });

        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(""+userModelList.get(i).getWeb()));
                context.startActivity(Intent.createChooser(intent, "Title"));
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data="https://api.whatsapp.com/send?phone="+userModelList.get(i).getWhatsapp()+"Content";
                Uri uri = Uri.parse(data); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

               /* PackageManager packageManager = context.getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);
                try {
                    String url = "https://api.whatsapp.com/send?phone=" + number + "&text=" + URLEncoder.encode(CommonStrings.SHARING_APP_MSG, "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        context.startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
            }
        });


        return root;
    }
}
