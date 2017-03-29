package org.afb.androidreference.ReferenceFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.afb.androidreference.ItemListActivity;
import org.afb.androidreference.R;

/**
 * Created by johnlilly on 3/22/17.
 */

public class EditTextReferenceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);

// loop through all toolbar children right after setting support
// action bar because the text view has no id assigned

// also make sure that the activity has some title here
// because calling setText() with an empty string actually
// removes the text view from the toolbar

        TextView toolbarTitle = null;
        for (int i = 0; i < toolbar.getChildCount(); ++i) {
            View child = toolbar.getChildAt(i);

            // assuming that the title is the first instance of TextView
            // you can also check if the title string matches
            if (child instanceof TextView) {
                toolbarTitle = (TextView)child;
                break;
            }
        }
        if(toolbarTitle != null) {
            Log.d("ASD", toolbarTitle.getText().toString());
            toolbarTitle.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            toolbarTitle.setFocusable(true);
            toolbarTitle.setFocusableInTouchMode(true);
            toolbarTitle.setAccessibilityTraversalBefore(R.id.name_label);
        }
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
            Bundle arguments = new Bundle();
            //arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
            //       getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            EditTextReferenceFragment fragment = new EditTextReferenceFragment();
            //fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
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
