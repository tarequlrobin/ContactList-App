package com.tareqrobin.contactlist16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {

    EditText etName, etPhone;
    Button save;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName=findViewById(R.id.etname);
        etPhone=findViewById(R.id.etphone);
        save=findViewById(R.id.add);

        db=new MyDB(getApplicationContext());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString();
                String phone=etPhone.getText().toString();

                db.insertData(name,phone);

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}