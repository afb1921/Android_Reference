package org.afb.androidreference.ReferenceFragments;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import org.afb.androidreference.R;

/**
 * Created by johnlilly on 3/29/17.
 */

public class FabScrollBahavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private int toolbarHeight;

    public FabScrollBahavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.toolbarHeight = (int) context.getResources().getDimension(R.dimen.app_bar_height);

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        //do nothing with the fab or write your logic for the FAB
        return true;
    }
}