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


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultFragment extends Fragment {
    ListView lvConsult;
    ArrayList<Consult> alConsult = new ArrayList<Consult>();
    ArrayAdapter aaConsult;


    public ConsultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consult, container, false);
        lvConsult = (ListView) view.findViewById(R.id.lvConsult);
        Consult consult1 = new Consult("Bryan","12/12/2018","11:10:21 pm","History Details","Past History");
        Consult consult2 = new Consult("John","12/12/2018","11:10:21 pm","History Details","Past History");
        Consult consult3 = new Consult("Peter","12/12/2018","11:10:21 pm","History Details","Past History");
        Consult consult4 = new Consult("Ryan","12/12/2018","11:10:21 pm","History Details","Past History");
        Consult consult5 = new Consult("Agnes","12/12/2018","11:10:21 pm","History Details","Past History");
        alConsult.add(consult1);
        alConsult.add(consult2);
        alConsult.add(consult3);
        alConsult.add(consult4);
        alConsult.add(consult5);

        aaConsult = new ArrayAdapter<Consult>(getContext(), android.R.layout.simple_list_item_1, alConsult);

        lvConsult.setAdapter(aaConsult);
        aaConsult.notifyDataSetChanged();

        lvConsult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(),ConsultDetailsActivity.class);
                Consult data = alConsult.get(position);
                intent.putExtra("consultData",data);
                startActivity(intent);
            }
        });

        return view;
    }

}
