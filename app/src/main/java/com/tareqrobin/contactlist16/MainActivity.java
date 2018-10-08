package com.tareqrobin.contactlist16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.lv);
        button=findViewById(R.id.btadd);

        MyDB db=new MyDB(getApplicationContext());
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),db.getAllData());
        listView.setAdapter(customAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddContact.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
