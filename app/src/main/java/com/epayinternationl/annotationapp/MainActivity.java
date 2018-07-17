package com.epayinternationl.annotationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Helper.Binder;
import Helper.BinderClass;
import Helper.FieldsValidator;
import Helper.Validator;
@Binder(binder = "anno_")
public class MainActivity extends AppCompatActivity {
    @Validator(min_length = 4,id = R.id.firstname)
    EditText anno_firstname;
    @Validator(min_length = 5,id = R.id.lastname)
    EditText anno_lastname;
    @Validator(required = true,min_length = 5,id = R.id.username)
    EditText anno_username;
    @Validator(required = true, is_trimable = false)
    EditText anno_password;
    @Validator(required = true, is_email = true)
    EditText anno_email;
    @Validator(required = true, only_numeric = true)
    EditText anno_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BinderClass(MainActivity.this).bind();
        final Button validate = (Button)findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FieldsValidator validator = new FieldsValidator(MainActivity.this);
                String response = validator.validate();
                if(!response.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                }
            }
        });

        if(anno_firstname != null){
            anno_firstname.setText("Ramy");
            Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"fail",Toast.LENGTH_LONG).show();
        }

    }
}
