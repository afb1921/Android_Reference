package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.afb.androidreference.R;

/**
 * Created by wbreu on 4/27/2017.
 */

public class FabReferenceContent extends BaseReferenceItemContent {
    public FabReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }

    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.fab_reference, container, false);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.spinner_contents, android.R.layout.simple_list_item_1);
        final ListView listView = (ListView) rootView.findViewById(R.id.fab_list);
        listView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        //NestedScrollView nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.item_detail_container);
        //nestedScrollView.setFillViewport(true);
        AccessibilityNodeInfoCompat nodeInfoCompat = AccessibilityNodeInfoCompat.obtain(fab);

        nodeInfoCompat.setTraversalBefore(listView);

        ViewCompat.setAccessibilityDelegate(fab, new AccessibilityDelegateCompat(){
            @Override
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(v, info);
                info.setTraversalBefore(listView);
                info.addAction(
                        new AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                                AccessibilityNodeInfoCompat.ACTION_LONG_CLICK,
                                "do something")
                );
            }
        });
        return rootView;
    }
}
