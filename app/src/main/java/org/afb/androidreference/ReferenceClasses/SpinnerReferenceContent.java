package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.afb.androidreference.R;

/**
 * Created by wbreu on 4/26/2017.
 */

public class SpinnerReferenceContent extends BaseReferenceItemContent {
    public SpinnerReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.edittext_reference, container, false);

        // set the labelFor attribute to the EditText
        TextView textView = (TextView) rootView.findViewById(R.id.name_label);
        textView.setLabelFor(R.id.name_editText);

        return rootView;
    }
}
