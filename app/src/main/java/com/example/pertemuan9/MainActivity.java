package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button clickButton;
    Button validate;
    EditText username_et;
    EditText password_et;
    Snackbar main_snackbar;
    CoordinatorLayout activity_main_coordinator;

    protected View.OnClickListener onclick_validate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String temp = "";
            boolean flag = false;
            if(username_et.getText().toString().length() == 0){
                temp = temp + "Username tidak boleh kosong\n";
                flag = true;
            }else if(username_et.getText().toString().length() < 5){
                temp = temp + "Username harus lebih dari 5 character\n";
                flag = true;
            }

            if(password_et.getText().toString().length() == 0){
                temp = temp + "Password tidak boleh kosong\n";
                flag = true;
            }else if(password_et.getText().toString().length() < 8){
                temp = temp + "Password harus lebih dari 8 character\n";
                flag = true;
            }

            if(flag == false){
                Toast.makeText(getApplicationContext(), "Selamat, tidak ada error", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
            }

        }
    };

    protected View.OnClickListener button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();
        }
    };

    protected View.OnClickListener button2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Hello World2", Toast.LENGTH_SHORT).show();
        }
    };

    protected View.OnLongClickListener longButton = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast taost = Toast.makeText(getApplicationContext(), "Helloooooooooooo Wooooooooorlddddd", Toast.LENGTH_SHORT);
            taost.setGravity(Gravity.TOP, 0, 0);
            taost.show();
            main_snackbar.show();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickButton = findViewById(R.id.main_btn);
        validate = findViewById(R.id.validate_btn);
        username_et = findViewById(R.id.username_et);
        password_et = findViewById(R.id.password_et);

        clickButton.setOnClickListener(button);
        clickButton.setOnLongClickListener(longButton);

        validate.setOnClickListener(onclick_validate);

        activity_main_coordinator = findViewById(R.id.main_coordinator);

        main_snackbar = Snackbar.make(activity_main_coordinator, "Hallo, ini snackbar", BaseTransientBottomBar.LENGTH_SHORT).setAction("Action", button2);

    }
}