package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;

import org.afb.androidreference.R;
import org.afb.androidreference.ReferenceClasses.TabLayoutResources.SampleFragmentPagerAdapter;

/**
 * Created by soad1_000 on 4/27/2017.
 */

public class TabLayoutReferenceContent extends BaseReferenceItemContent {
    public TabLayoutReferenceContent(Context context, String subtitle, String description) {
        super(context, subtitle, description);
    }
    @Override
    View getView(LayoutInflater inflater, ViewGroup container, Context context) {
        View rootView = inflater.inflate(R.layout.tab_layout_reference, container, false);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        AppCompatActivity activity = (AppCompatActivity)context;
        viewPager.setAdapter(new SampleFragmentPagerAdapter(activity.getSupportFragmentManager(), activity));
        final TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setContentDescription(tab.getText() + " " + (i+1) + " of " + tabLayout.getTabCount());
        }

        return rootView;
    }

}
