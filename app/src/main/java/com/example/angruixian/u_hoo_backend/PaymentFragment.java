package com.example.angruixian.u_hoo_backend;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {
    ListView lvPayment;
    ArrayList<Payment> alPayment = new ArrayList<Payment>();
    ArrayAdapter aaPayment;


    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        lvPayment = (ListView) view.findViewById(R.id.lvPayment);
        Payment payment1 = new Payment("12/12/2017","12:12:12pm","20mins","20SGD","13/12/2018");
        Payment payment2 = new Payment("12/12/2017","12:12:12pm","20mins","20SGD","13/12/2018");
        Payment payment3 = new Payment("12/12/2017","12:12:12pm","20mins","20SGD","13/12/2018");
        Payment payment4 = new Payment("12/12/2017","12:12:12pm","20mins","20SGD","13/12/2018");
        Payment payment5 = new Payment("12/12/2017","12:12:12pm","20mins","20SGD","13/12/2018");
        alPayment.add(payment1);
        alPayment.add(payment2);
        alPayment.add(payment3);
        alPayment.add(payment4);
        alPayment.add(payment5);

        aaPayment = new ArrayAdapter<Payment>(getContext(), android.R.layout.simple_list_item_1, alPayment);

        lvPayment.setAdapter(aaPayment);
        aaPayment.notifyDataSetChanged();

        lvPayment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(),PaymentDetailsActivity.class);
                Payment dataPayment = alPayment.get(position);
                intent.putExtra("paymentData",dataPayment);
                startActivity(intent);
            }
        });
        return view;
    }

}
