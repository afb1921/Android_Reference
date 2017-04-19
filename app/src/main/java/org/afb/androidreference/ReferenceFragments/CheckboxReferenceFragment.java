package org.afb.androidreference.ReferenceFragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.afb.androidreference.R;

/**
 * Created by johnlilly on 2/22/17.
 */

public class CheckboxReferenceFragment extends Fragment {
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
    public CheckboxReferenceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.checkbox_reference, container, false);

        CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        checkBox.setText("Checkbox label");
        checkBox.setContentDescription("Checkbox description");
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("Checkboxes");
        return rootView;
    }
}
