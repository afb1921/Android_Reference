package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import org.afb.androidreference.R;

/**
 * Created by wbreu on 4/26/2017.
 */

public class ImageReferenceContent extends BaseReferenceItemContent {
    public ImageReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.image_reference, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_reference);
        imageView.setContentDescription(getString(R.string.photo1_content_description));
        return rootView;
    }
}
