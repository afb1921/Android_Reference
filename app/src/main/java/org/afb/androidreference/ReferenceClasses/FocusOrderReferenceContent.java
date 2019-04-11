package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.afb.androidreference.R;
import org.afb.androidreference.ReferenceClasses.BaseReferenceItemContent;

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
        fab.setVisibility(View.VISIBLE);
        fab.setImageResource(android.R.drawable.ic_menu_edit);
        View phoneLabel = rootView.findViewById(R.id.phone_label);
        View phoneValue = rootView.findViewById(R.id.phone_value);
        View emailLabel = rootView.findViewById(R.id.email_label);
        View emailValue = rootView.findViewById(R.id.email_value);
        View nameLabel = rootView.findViewById(R.id.name_label);
        View nameValue = rootView.findViewById(R.id.name_value);
        View locationLabel = rootView.findViewById(R.id.location_label);
        View locationValue = rootView.findViewById(R.id.location_value);

        //TODO: Commented this out cause it broke in refactoring
        //fab.setAccessibilityTraversalBefore(R.id.item_detail_container);
        phoneLabel.setAccessibilityTraversalAfter(fab.getId());
        phoneValue.setAccessibilityTraversalAfter(phoneLabel.getId());

        emailLabel.setAccessibilityTraversalAfter(phoneValue.getId());

        emailValue.setAccessibilityTraversalAfter(emailLabel.getId());

        //emailValue.setAccessibilityTraversalBefore(nameLabel.getId());
        nameLabel.setAccessibilityTraversalAfter(emailValue.getId());
        //nameLabel.setAccessibilityTraversalBefore(nameValue.getId());
        nameValue.setAccessibilityTraversalAfter(nameLabel.getId());
        //nameValue.setAccessibilityTraversalBefore(locationLabel.getId());
        locationLabel.setAccessibilityTraversalAfter(nameValue.getId());
        //locationLabel.setAccessibilityTraversalBefore(locationValue.getId());
        locationValue.setAccessibilityTraversalAfter(locationLabel.getId());
//        ViewCompat.setAccessibilityDelegate(fab, new AccessibilityDelegateCompat(){
//            @Override
//            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
//                super.onInitializeAccessibilityNodeInfo(v, info);
//                info.setTraversalBefore(itemDetailContainer);
//            }
//        });
//        final View rightColumn = getActivity().findViewById(R.id.right_column);
//        ViewCompat.setAccessibilityDelegate(leftColumn, new AccessibilityDelegateCompat(){
//            @Override
//            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
//                super.onInitializeAccessibilityNodeInfo(v, info);
//                info.setTraversalAfter(rightColumn);
//            }
//        });
        return rootView;
    }
}
