package com.example.harald.runwithme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.SupportMapFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    Button btnStart = null;
    private IDataConsumer consumer = null;
    private Model model = null;

    public SettingsFragment() {
        // Required empty public constructor
    }
    public void setDataConsumer(IDataConsumer consumer, Model model)
    {
        this.consumer = consumer;
        this.model = model;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.btnStart = (Button) view.findViewById(R.id.btn_start);
        this.btnStart.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SettingsFragment.this.model.setCurrentAction(Model.ACTION.SELECT_STARTPOINT);
                SettingsFragment.this.consumer.showMessage("select startpoint");
            }
        });

    }
}
