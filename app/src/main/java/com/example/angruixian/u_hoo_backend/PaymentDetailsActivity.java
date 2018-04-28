package com.example.angruixian.u_hoo_backend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentDetailsActivity extends AppCompatActivity {

    TextView tvPaymentAmount, tvPaymentDate, tvPaymentTime, tvPaymentDuration, tvPaymentWithdrawDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        tvPaymentAmount = (TextView)findViewById(R.id.tvPaymentAmount);
        tvPaymentDate = (TextView)findViewById(R.id.tvPaymentDate);
        tvPaymentTime = (TextView)findViewById(R.id.tvPaymentTime);
        tvPaymentDuration = (TextView)findViewById(R.id.tvPaymentDuration);
        tvPaymentWithdrawDateTime = (TextView)findViewById(R.id.tvPaymentWithdrawDateTime);

        Intent i = getIntent();
        Payment paymentData = (Payment) i.getSerializableExtra("paymentData");
        tvPaymentAmount.setText(paymentData.getPaymentAmount());
        tvPaymentDate.setText(paymentData.getDate());
        tvPaymentTime.setText(paymentData.getTime());
        tvPaymentDuration.setText(paymentData.getDuration());
        tvPaymentWithdrawDateTime.setText(paymentData.getWithdrawDateTime());

    }
}
