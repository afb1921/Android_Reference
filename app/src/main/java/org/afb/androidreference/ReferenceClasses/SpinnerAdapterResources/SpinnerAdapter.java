package org.afb.androidreference.ReferenceClasses.SpinnerAdapterResources;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by soad1_000 on 5/15/2017.
 */

public class SpinnerAdapter extends ArrayAdapter {
    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
