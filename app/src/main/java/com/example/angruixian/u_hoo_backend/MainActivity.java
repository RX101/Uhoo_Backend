package com.example.angruixian.u_hoo_backend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etUserEmail,etUserPassword;
    TextView tvUserRegister,tvUserForgetPassword;
    Button btnUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Doctor Registration");

        etUserEmail = (EditText)findViewById(R.id.etUserEmail);
        etUserPassword = (EditText)findViewById(R.id.etUserPassword);
        tvUserForgetPassword = (TextView)findViewById(R.id.tvUserForgetPassword);
        tvUserRegister = (TextView)findViewById(R.id.tvUserRegister);
        btnUserLogin = (Button)findViewById(R.id.btnLogin);

        tvUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });

        btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),HomeActivity.class));

            }
        });

    }
}
