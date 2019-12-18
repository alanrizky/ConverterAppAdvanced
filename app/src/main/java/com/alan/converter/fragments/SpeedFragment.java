package com.alan.converter.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.alan.converter.R;
import com.alan.converter.converter.SpeedConverter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeedFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Spinner fromSpinner, toSpinner;
    private EditText fromEditText, toEditText;
    private Button convertButton;
    private Double result;

    public SpeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speed, container, false);
        fromSpinner = view.findViewById(R.id.spinner_from);
        toSpinner = view.findViewById(R.id.spinner_to);
        fromEditText = view.findViewById(R.id.editText_from);
        toEditText = view.findViewById(R.id.editText_to);
        convertButton = view.findViewById(R.id.button_convert);
        @NonNull
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.speed, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        final EditText f = view.findViewById(R.id.editText_from);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {

                    String fromValue = f.getText().toString();

                    String fromString = (String) fromSpinner.getSelectedItem();
                    String toString = (String) toSpinner.getSelectedItem();
                    if (fromValue.equals("")) {
                        Toast.makeText(getContext(), "Cek kembali input anda", Toast.LENGTH_SHORT).show();
                    } else {
                        double input = Double.valueOf(fromEditText.getText().toString());
                        SpeedConverter.Speed fromUnit = SpeedConverter.Speed.fromString(fromString);
                        SpeedConverter.Speed toUnit = SpeedConverter.Speed.fromString(toString);

                        SpeedConverter converter = new SpeedConverter(fromUnit, toUnit);
                        double result = converter.converted(input);
                        toEditText.setText(String.valueOf(result));
                    }
                }
            }
        });
        return view;
    }


    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SpeedFragment.OnFragmentInteractionListener) {
            mListener = (SpeedFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnFragmentInteractionListener {
    }

}
