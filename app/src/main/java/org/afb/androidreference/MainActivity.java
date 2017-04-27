package org.afb.androidreference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import org.afb.androidreference.ReferenceClasses.ReferenceItemFragment;

/**
 * Created by wbreu on 4/25/2017.
 */

public class MainActivity extends AppCompatActivity implements
        FragmentManager.OnBackStackChangedListener, MainFragment.Callbacks {

    private static final String MAIN_FRAGMENT_NAME = "MAIN_FRAGMENT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ItemController mController;
        try {
            mController = ItemController.getInstance();
        } catch (Exception e) {
            Log.println(Log.ERROR, this.getLocalClassName(), "Failed to initialize tests.");
            finish();
            return;
        }

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        final MainFragment mainFragment = new MainFragment();
        //mainFragment.setOnSessionSelectedCallback(this);
        mainFragment.setTestController(mController);
        switchFragment(mainFragment, MAIN_FRAGMENT_NAME);
    }

    @Override
    public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override
    public void onItemSelected(int position) {
        showReferenceContent(position);
    }

//    @Override
//    public void onNextContentClicked(int sessionId, int contentIndex) {
//        final int nextContentIndex = contentIndex + 1;
//        if (mController.getSessionById(sessionId).getContentCount() > nextContentIndex) {
//            showTestContent(sessionId, nextContentIndex);
//        } else {
//            final TestSession nextSession = mController.getNextSessionById(sessionId);
//            if (nextSession == null) {
//                returnToMainFragment();
//            } else {
//                showTestContent(nextSession.getId(), 0);
//            }
//        }
//    }
//
//    @Override
//    public void onPreviousContentClicked(int sessionId, int contentIndex) {
//        final int previousContent = contentIndex - 1;
//        if (previousContent >= 0) {
//            showTestContent(sessionId, previousContent);
//        } else {
//            final TestSession previousSession = mController.getPreviousSessionById(sessionId);
//            if (previousSession == null) {
//                returnToMainFragment();
//            } else {
//                showTestContent(previousSession.getId(), previousSession.getContentCount() - 1);
//            }
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        returnToMainFragment();
        return true;
    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        // Fire a TYPE_WINDOW_STATE_CHANGED event so that the accessibility service will be notified
        // of window title change.
        getWindow().getDecorView()
                .sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    /**
     * Pops back to the main fragment.
     */
    private void returnToMainFragment() {
        getSupportFragmentManager().popBackStack(MAIN_FRAGMENT_NAME, 0);
    }

    /**
     * Show specified content in a test session.
     *
     * @param i    Reference int
     */
    private void showReferenceContent(int i) {

        final ReferenceItemFragment testSessionFragment = new ReferenceItemFragment();
        testSessionFragment.setSession(i, i);
        //testSessionFragment.setNavigationCallback(this);
        switchFragment(testSessionFragment, null);
        //mController.recordTestSessionAccessed(getApplicationContext(), sessionId);
    }

    /**
     * Replaces the fragment holder with a new fragment, adds the fragment transaction to the
     * back stack.
     *
     * @param fragment The fragment to show.
     * @param name     Name of the fragment, used to identify the fragment when popping up the back
     *                 stack.
     */
    private void switchFragment(Fragment fragment, String name) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_holder, fragment);
        transaction.addToBackStack(name);
        transaction.commit();
    }
}
