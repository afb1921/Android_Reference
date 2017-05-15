package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.afb.androidreference.R;
import org.afb.androidreference.ReferenceClasses.SpinnerAdapterResources.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wbreu on 4/27/2017.
 */

public class EditTextReferenceContent extends BaseReferenceItemContent {
    public EditTextReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.edittext_reference, container, false);

        // set the labelFor attribute to the EditText
        TextView textView = (TextView) rootView.findViewById(R.id.street_address_label);
        textView.setLabelFor(R.id.street_address_editText);

        ArrayList<String> list = new ArrayList<>(Arrays.asList(context.getResources().getStringArray(R.array.spinner_contents)));

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context, android.R.layout.simple_spinner_dropdown_item, list);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.reference_spinner);
        spinner.setAdapter(spinnerAdapter);
        spinner.setPrompt("Select an item");


        return rootView;
    }
}
