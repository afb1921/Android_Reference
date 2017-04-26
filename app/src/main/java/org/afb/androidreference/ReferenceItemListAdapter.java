package org.afb.androidreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by wbreu on 4/25/2017.
 */

public class ReferenceItemListAdapter extends BaseAdapter {

    private final Context mContext;
    private final ItemController mController;
    private final NavigationCallback mCallback;

    public ReferenceItemListAdapter(Context context, ItemController controller,
                              NavigationCallback callback) {
        mContext = context;
        mController = controller;
        mCallback = callback;
    }

    @Override
    public int getCount() {
        return mController.getCount();
    }

    @Override
    public Object getItem(int i) {
        return mController.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.reference_list_item, parent, false);
            final ReferenceItemListAdapter.ViewHolder holder = new ReferenceItemListAdapter.ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.reference_list_item_name);
            holder.description = (TextView) convertView.findViewById(R.id.reference_list_item_description);
            convertView.setTag(holder);
        }

        final ReferenceItem session = mController.getItem(i);
        final ReferenceItemListAdapter.ViewHolder holder = (ReferenceItemListAdapter.ViewHolder) convertView.getTag();
        holder.title.setText(session.getName());
        holder.description.setText(session.getDescription());
//        holder.panel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //TODO: THIS NEEDS CHANGED
//                mCallback.onTestSessionSelected(0);
//            }
//        });
        return convertView;
    }
    /**
     * A view holder describes an item view's content within the ListView.
     */
    private static final class ViewHolder {
        TextView title;
        TextView description;
        View panel;
    }
}