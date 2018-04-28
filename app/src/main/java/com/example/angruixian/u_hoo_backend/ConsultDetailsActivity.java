package com.example.angruixian.u_hoo_backend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConsultDetailsActivity extends AppCompatActivity {

    TextView tvPatientName,tvDate, tvTime,tvMedicineDetails, tvPastHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_details);

        tvPatientName = (TextView)findViewById(R.id.tvPatientName);
        tvDate = (TextView)findViewById(R.id.tvDate);
        tvTime = (TextView)findViewById(R.id.tvTime);
        tvMedicineDetails = (TextView)findViewById(R.id.tvMedicalDetails);
        tvPastHistory = (TextView)findViewById(R.id.tvPastHistory);

        Intent i = getIntent();
        Consult consultData = (Consult) i.getSerializableExtra("consultData");
        tvPatientName.setText("Patient Name"+consultData.getPatientName());
        tvDate.setText("Consult Date: " + consultData.getConsultDate());
        tvTime.setText("Consult Time" + consultData.getConsultTime());
        tvMedicineDetails.setText("Medicine Details" + consultData.getMedicineDetails());
        tvPastHistory.setText("Past History: " + consultData.getPastHistory());


    }
}
