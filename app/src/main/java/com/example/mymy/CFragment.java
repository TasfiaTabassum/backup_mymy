package com.example.mymy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CFragment extends Fragment {

    TextView text1 , text2 ;

    public CFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        text1 = getActivity().findViewById(R.id.demovidlink);
       // text1.setMovementMethod(LinkMovementMethod.getInstance());

        text2 = getActivity().findViewById(R.id.gitrepolink);
       // text2.setMovementMethod(LinkMovementMethod.getInstance());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
}