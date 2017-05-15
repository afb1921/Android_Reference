package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.afb.androidreference.R;
import org.afb.androidreference.ReferenceClasses.SpinnerAdapterResources.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wbreu on 4/26/2017.
 */

public class SpinnerReferenceContent extends BaseReferenceItemContent {
    public SpinnerReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.spinner_reference, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.select_continent_label);
        textView.setLabelFor(R.id.select_continent_spinner);

        ArrayList<String> list = new ArrayList<>(Arrays.asList(context.getResources().getStringArray(R.array.spinner_continents)));

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context, android.R.layout.simple_spinner_dropdown_item, list);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.select_continent_spinner);
        spinner.setAdapter(spinnerAdapter);
        spinner.setPrompt("Select a continent");

        return rootView;
    }
}
