package org.afb.androidreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import org.afb.androidreference.ReferenceFragments.CheckboxReferenceFragment;
import org.afb.androidreference.ReferenceFragments.EditTextReferenceFragment;
import org.afb.androidreference.ReferenceFragments.FabReferenceFragment;
import org.afb.androidreference.ReferenceFragments.FocusOrderReferenceFragment;
import org.afb.androidreference.ReferenceFragments.ImageReferenceFragment;
import org.afb.androidreference.ReferenceFragments.SpinnerReferenceFragment;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {
    protected static final int IMAGE_REFERENCE = 0;
    protected static final int CHECKBOX_REFERENCE = 1;
    protected static final int EDIT_TEXT_REFERENCE = 2;
    protected static final int FAB_REFERENCE = 3;
    protected static final int SPINNER_REFERENCE = 4;
    protected static final int FOCUS_ORDER_REFERENCE = 5;

    protected static String fragment_args = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setVisibility(View.GONE);
        //        fab.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {
    //                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
    //                        .setAction("Action", null).show();
    //            }
    //        });
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Fragment fragment;
            switch (getIntent().getIntExtra(fragment_args, 0)) {
                case IMAGE_REFERENCE:
                    fragment = new ImageReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    break;
                case CHECKBOX_REFERENCE:
                    fragment = new CheckboxReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    break;
                case EDIT_TEXT_REFERENCE:
                    fragment = new EditTextReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    break;
                case FAB_REFERENCE:
                    fragment = new FabReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    break;
                case SPINNER_REFERENCE:
                    fragment = new SpinnerReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    break;
                case FOCUS_ORDER_REFERENCE:
                    fragment = new FocusOrderReferenceFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                    getSupportActionBar().setTitle("Focus Order");
                    break;
            }
//            Bundle arguments = new Bundle();
//            //arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
//            //       getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
//            CheckboxReferenceFragment fragment = new CheckboxReferenceFragment();
//            //fragment.setArguments(arguments);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.item_detail_container, fragment)
//                    .commit();
    }
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
