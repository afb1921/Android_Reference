package org.afb.androidreference.ReferenceFragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.afb.androidreference.R;

/**
 * Created by johnlilly on 3/22/17.
 */

public class EditTextReferenceFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
//    private ListContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EditTextReferenceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edittext_reference, container, false);

        // set the labelFor attribute to the EditText
        TextView textView = (TextView) rootView.findViewById(R.id.name_label);
        //textView.setLabelFor(R.id.name_editText);


        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_contents, android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.reference_spinner);
        spinner.setAdapter(spinnerAdapter);

        return rootView;
    }
}
