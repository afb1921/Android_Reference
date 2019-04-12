package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import org.afb.androidreference.R;


/**
 * Created by johnlilly on 4/19/17.
 */

public class FocusOrderReferenceContent extends BaseReferenceItemContent {
    public FocusOrderReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.focus_order_reference, container, false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        fab.setImageResource(android.R.drawable.ic_menu_edit);

        //Setting this as a heading and checkbox for demo purposes
        ViewCompat.setAccessibilityDelegate(fab, new AccessibilityDelegateCompat(){
            @Override
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(v, info);
                info.setClassName(CheckBox.class.getName());
            }
        });

        return rootView;
    }
}
