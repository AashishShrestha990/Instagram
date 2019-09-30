package com.test.instagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    LinearLayout container1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        databaseHelper = new DatabaseHelper(this);
        container1 = findViewById(R.id.container1);
        populateData();
    }

    public void populateData() {
        ArrayList<UserInfo> list = databaseHelper.getUserList();
//
//        for (int i = 0; i < list.size(); i++) {
//            UserInfo info = list.get(i);
//        }
        for (UserInfo info : list) {
//            TextView textView = new TextView(this);
//            textView.setText(info.name + "\n" + info.address);

            View view = LayoutInflater.from(this).inflate(R.layout.item_layout,null);

            TextView name = view.findViewById(R.id.name);
            TextView password = view.findViewById(R.id.password);
            TextView like = view.findViewById(R.id.like);
            TextView caption = view.findViewById(R.id.caption);
            TextView time = view.findViewById(R.id.time);

            name.setText(info.name);
            password.setText(info.password);
            like.setText(info.like);
            caption.setText(info.caption);
            time.setText(info.time);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageBitmap(RegisterActivity.gotBitmap(info.ppic));

            container1.addView(view);
        }
    }
}
