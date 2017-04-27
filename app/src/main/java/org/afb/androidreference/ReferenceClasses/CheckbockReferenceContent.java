package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import org.afb.androidreference.R;

/**
 * Created by wbreu on 4/26/2017.
 */

public class CheckbockReferenceContent extends BaseReferenceItemContent {
    public CheckbockReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.checkbox_reference, container, false);

        CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        checkBox.setText("Checkbox label");
        checkBox.setContentDescription("Checkbox description");

        return rootView;
    }
}
