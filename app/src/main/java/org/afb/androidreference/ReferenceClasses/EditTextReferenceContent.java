package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.afb.androidreference.R;

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
        TextView textView = (TextView) rootView.findViewById(R.id.name_label);
        //textView.setLabelFor(R.id.name_editText);


        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(context, R.array.spinner_contents, android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.reference_spinner);
        spinner.setAdapter(spinnerAdapter);

        return rootView;
    }
}
