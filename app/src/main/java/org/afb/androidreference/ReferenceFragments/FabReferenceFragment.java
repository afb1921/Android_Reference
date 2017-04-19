package org.afb.androidreference.ReferenceFragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import org.afb.androidreference.R;

/**
 * Created by johnlilly on 3/29/17.
 */

public class FabReferenceFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
//    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FabReferenceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            // Load the dummy content specified by the fragment
//            // arguments. In a real-world scenario, use a Loader
//            // to load content from a content provider.
////            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
//
//            Activity activity = this.getActivity();
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle("Image View");
//            }
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fab_reference, container, false);
//        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_contents, android.R.layout.simple_list_item_1);
        final ListView listView = (ListView) rootView.findViewById(R.id.fab_list);
        listView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        NestedScrollView nestedScrollView = (NestedScrollView) getActivity().findViewById(R.id.item_detail_container);
        nestedScrollView.setFillViewport(true);
        AccessibilityNodeInfoCompat nodeInfoCompat = AccessibilityNodeInfoCompat.obtain(fab);

        nodeInfoCompat.setTraversalBefore(listView);
//        AccessibilityNodeInfoCompat.obtain(listView).setTraversalAfter(fab);
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
