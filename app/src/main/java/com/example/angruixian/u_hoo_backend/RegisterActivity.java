package com.example.angruixian.u_hoo_backend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegisterDoctorName, etRegisterDoctorEmail,etRegisterDoctorMobileNumber, etRegisterDoctorAddress,etRegisterDoctorSpecialization,etRegisterDoctorRegistrationNumber,etRegisterDoctorInsurance,etRegisterDoctorDescription,etRegisterDoctorRate,etRegisterDoctorLanguage;
    Button btnUploadImage,btnTakePhoto,btnDoctorRegister;
    ImageView imgViewDoctor;
    private static final int PICK_IMAGE_REQUEST = 71;
    private Uri filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Doctor Registration");

        etRegisterDoctorName = (EditText)findViewById(R.id.etRegisterDoctorName);
        etRegisterDoctorEmail = (EditText)findViewById(R.id.etRegisterDoctorEmail);
        etRegisterDoctorMobileNumber = (EditText)findViewById(R.id.etRegisterDoctorMobileNumber);
        etRegisterDoctorAddress = (EditText)findViewById(R.id.etRegisterDoctorAddress);
        etRegisterDoctorSpecialization = (EditText)findViewById(R.id.etRegisterDoctorSpecialization);
        etRegisterDoctorRegistrationNumber = (EditText)findViewById(R.id.etRegisterDoctorRegistrationNumber);
        etRegisterDoctorDescription = (EditText)findViewById(R.id.etRegisterDoctorDescription);
        etRegisterDoctorInsurance = (EditText)findViewById(R.id.etRegisterDoctorInsurance);
        etRegisterDoctorRate = (EditText)findViewById(R.id.etRegisterDoctorRate);
        etRegisterDoctorLanguage = (EditText)findViewById(R.id.etRegisterDoctorLanguage);
        btnUploadImage = (Button)findViewById(R.id.btnUploadImage);
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        btnDoctorRegister = (Button)findViewById(R.id.btnDoctorRegister);
        imgViewDoctor = (ImageView)findViewById(R.id.imgViewDoctor);

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent,PICK_IMAGE_REQUEST);
            }
        });

        btnDoctorRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctorName = etRegisterDoctorName.getText().toString();
                String doctorEmail = etRegisterDoctorEmail.getText().toString();
                String doctorMobileNumber = etRegisterDoctorMobileNumber.getText().toString();
                String doctorAddress = etRegisterDoctorAddress.getText().toString();
                String doctorSpecialization =  etRegisterDoctorSpecialization.getText().toString();
                String doctorRegistrationNumber = etRegisterDoctorRegistrationNumber.getText().toString();
                String doctorDescription = etRegisterDoctorDescription.getText().toString();
                String doctorInsurance = etRegisterDoctorInsurance.getText().toString();
//                double doctorRate = Double.parseDouble(etRegisterDoctorRate.getText().toString());
                String doctorLanguage = etRegisterDoctorLanguage.getText().toString();
                String doctorImage = "image123";
                if (doctorName.isEmpty()){
                    etRegisterDoctorName.setError("Name field is empty");
                }else if (doctorEmail.isEmpty()){
                    etRegisterDoctorEmail.setError("Email field is empty");
                }else if (Patterns.EMAIL_ADDRESS.matcher(doctorEmail).matches()){
                    etRegisterDoctorAddress.setError("Email Format is in correct");
                } else if (doctorMobileNumber.isEmpty()){
                    etRegisterDoctorMobileNumber.setError("Mobile Number field is empty");
                }else if(doctorAddress.isEmpty()){
                    etRegisterDoctorAddress.setError("Address field is empty");
                }else if(doctorSpecialization.isEmpty()){
                    etRegisterDoctorSpecialization.setError("Specialization field is empty");
                }else if(doctorRegistrationNumber.isEmpty()){
                    etRegisterDoctorRegistrationNumber.setError("Registration Number field is empty");
                }else if(doctorDescription.isEmpty()){
                    etRegisterDoctorDescription.setError("Description field is empty");
                }else if(doctorInsurance.isEmpty()){
                    etRegisterDoctorInsurance.setError("Insurance field is empty");
                }else if(doctorLanguage.isEmpty()) {
                    etRegisterDoctorLanguage.setError("Language field is empty");
                } else{
                    disclaimer();
                }

            }
        });

    }

    private void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                imgViewDoctor.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void disclaimer(){
        AlertDialog.Builder adb = new AlertDialog.Builder(RegisterActivity.this);
        adb.setTitle("Disclaimer");
        adb.setMessage("");
        adb.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {





                Toast.makeText(getBaseContext(),"Proceed to Next Page",Toast.LENGTH_SHORT).show();

            }
        });
        adb.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = adb.create();
        dialog.show();
    }
}
