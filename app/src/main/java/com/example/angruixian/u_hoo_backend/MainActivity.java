package com.example.angruixian.u_hoo_backend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Random;

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
        Random rand = new Random();
        final Integer n = rand.nextInt(8999)+1000;
        final String code = n.toString();

        tvUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });

        tvUserForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email  = etUserEmail.getText().toString().trim();
                if (etUserEmail.equals("")) {
                    etUserEmail.setError("Please enter user email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etUserEmail.setError("Email format is incorrect");
                } else if (etUserPassword.equals("")) {
                    etUserPassword.setError("Please enter password.");
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("5554", null,"UHoo: OTP: " + code, null, null);
                    //Inflate the input.xml layout file
                    LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewDialog = inflater.inflate(R.layout.passcodeverification,null);

                    //Obtain th UI component in the input.xml layout
                    final EditText etPasscodeVerification = (EditText)viewDialog.findViewById(R.id.editTextPasscodeVerification);
                    //Create the Dialog Builder
                    final AlertDialog.Builder myBuilderCheckCode = new AlertDialog.Builder(MainActivity.this);
                    //Set the view of the dialog
                    myBuilderCheckCode.setView(viewDialog);
                    myBuilderCheckCode.setTitle("Passcode verification");
                    myBuilderCheckCode.setMessage("Enter the passcode: ");
                    myBuilderCheckCode.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Extract the Text entered by the user
                            String passcode = etPasscodeVerification.getText().toString();

                            //Update the Text entered by the user
                            if(passcode.equals("")){
                                Toast.makeText(getBaseContext(),"Please enter the passcode",Toast.LENGTH_SHORT).show();
                            }else if (passcode.equals(code)) {
                                Toast.makeText(getBaseContext(), "Successfully", Toast.LENGTH_SHORT).show();
                                Intent intentToSetPassWord = new Intent(getBaseContext(),HomeActivity.class);
                                startActivity(intentToSetPassWord);
//                                    //Inflate the input.xml layout file
//                                                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                                        View viewDialog = inflater.inflate(R.layout.resetpassword,null);
//
//                                        //Obtain th UI component in the input.xml layout
//                                        final EditText etResetNewPassword = (EditText)viewDialog.findViewById(R.id.editTextResetNewPassword);
//                                        final EditText etResetConfirmPassword = (EditText)viewDialog.findViewById(R.id.editTextResetConfirmPassword);
//                                        final String resetPassword = etResetNewPassword.getText().toString();
//                                        //Create the Dialog Builder
//                                        final AlertDialog.Builder myBuilderResetPassword = new AlertDialog.Builder(MainActivity.this);
//                                        //Set the view of the dialog
//                                        myBuilderResetPassword.setView(viewDialog);
//                                        myBuilderResetPassword.setTitle("Reset Password:");
//                                        myBuilderResetPassword.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
//                                            @Override
//                                        public void onClick(DialogInterface dialogInterface, int i) {
//                                            password2 = resetPassword ;
//                                        }
//                                    });
//                                    myBuilderResetPassword.setNeutralButton("cancel",null);
//                                    //Create and display the Dialog
//                                    AlertDialog myDialogRP = myBuilderResetPassword.create();
//                                    myDialogRP.show();


                            }else if(!passcode.equals(code)){
                                Toast.makeText(getBaseContext(),"OTP is incorrect. Please Try Again.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    myBuilderCheckCode.setNeutralButton("cancel",null);
                    //Create and display the Dialog
                    AlertDialog myDialogCC = myBuilderCheckCode.create();
                    myDialogCC.show();

                }
            }
        });

    }
}
