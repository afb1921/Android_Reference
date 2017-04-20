package org.afb.androidreference.ReferenceFragments;

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

/**
 * Created by johnlilly on 4/19/17.
 */

public class FocusOrderReferenceFragment extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.focus_order_reference, container, false);

//        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_reference);
//        imageView.setContentDescription(getString(R.string.photo1_content_description));
//        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
//        toolbarLayout.setTitle("Images");
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);



        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.setImageResource(android.R.drawable.ic_menu_edit);
        final View itemDetailContainer = getActivity().findViewById(R.id.item_detail_container);
        ViewCompat.setAccessibilityDelegate(fab, new AccessibilityDelegateCompat(){
            @Override
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(v, info);
                info.setTraversalBefore(itemDetailContainer);
            }
        });
        View leftColumn = getActivity().findViewById(R.id.left_column);
        final View rightColumn = getActivity().findViewById(R.id.right_column);
        ViewCompat.setAccessibilityDelegate(leftColumn, new AccessibilityDelegateCompat(){
            @Override
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(v, info);
                info.setTraversalAfter(rightColumn);
            }
        });
    }
}
