package org.afb.androidreference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import org.afb.androidreference.ReferenceFragments.CheckboxReferenceActivity;
import org.afb.androidreference.ReferenceFragments.CheckboxReferenceFragment;
import org.afb.androidreference.ReferenceFragments.EditTextReferenceActivity;
import org.afb.androidreference.ReferenceFragments.EditTextReferenceFragment;
import org.afb.androidreference.ReferenceFragments.FabReferenceActivity;
import org.afb.androidreference.ReferenceFragments.FabReferenceFragment;
import org.afb.androidreference.ReferenceFragments.ImageReferenceActivity;
import org.afb.androidreference.ReferenceFragments.ImageReferenceFragment;
import org.afb.androidreference.dummy.DummyContent;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            switch (position){
                case 0:
                    holder.mItem = new DummyContent.DummyItem(String.valueOf(position + 1),"Images", "Details");
                    //holder.mIdView.setText(holder.mItem.id);
                    holder.mContentView.setText(holder.mItem.content);

                    holder.mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mTwoPane) {
                                Bundle arguments = new Bundle();
                                arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                                ImageReferenceFragment fragment = new ImageReferenceFragment();
                                fragment.setArguments(arguments);
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.item_detail_container, fragment)
                                        .commit();
                            } else {
                                Context context = v.getContext();
                                Intent intent = new Intent(context, ImageReferenceActivity.class);
                                //intent.putExtra(ImageReferenceFragment.ARG_ITEM_ID, holder.mItem.id);

                                context.startActivity(intent);
                            }
                        }
                    });
                    break;
                case 1:
                    holder.mItem = new DummyContent.DummyItem(String.valueOf(position + 1),"Checkboxes", "Details");
                    //holder.mIdView.setText(holder.mItem.id);
                    holder.mContentView.setText(holder.mItem.content);

                    holder.mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mTwoPane) {
                                Bundle arguments = new Bundle();
                                arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                                CheckboxReferenceFragment fragment = new CheckboxReferenceFragment();
                                fragment.setArguments(arguments);
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.item_detail_container, fragment)
                                        .commit();
                            } else {
                                Context context = v.getContext();
                                Intent intent = new Intent(context, CheckboxReferenceActivity.class);
                                //intent.putExtra(ImageReferenceFragment.ARG_ITEM_ID, holder.mItem.id);

                                context.startActivity(intent);
                            }
                        }
                    });
                    break;
                case 2:
                    holder.mItem = new DummyContent.DummyItem(String.valueOf(position + 1),"Edit Text", "Details");
                    //holder.mIdView.setText(holder.mItem.id);
                    holder.mContentView.setText(holder.mItem.content);

                    holder.mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mTwoPane) {
                                Bundle arguments = new Bundle();
                                arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                                EditTextReferenceFragment fragment = new EditTextReferenceFragment();
                                fragment.setArguments(arguments);
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.item_detail_container, fragment)
                                        .commit();
                            } else {
                                Context context = v.getContext();
                                Intent intent = new Intent(context, EditTextReferenceActivity.class);
                                //intent.putExtra(ImageReferenceFragment.ARG_ITEM_ID, holder.mItem.id);

                                context.startActivity(intent);
                            }
                        }
                    });
                    break;
                case 3:
                    holder.mItem = new DummyContent.DummyItem(String.valueOf(position + 1),"FAB", "Details");
                    //holder.mIdView.setText(holder.mItem.id);
                    holder.mContentView.setText(holder.mItem.content);

                    holder.mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mTwoPane) {
                                Bundle arguments = new Bundle();
                                arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                                FabReferenceFragment fragment = new FabReferenceFragment();
                                fragment.setArguments(arguments);
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.item_detail_container, fragment)
                                        .commit();
                            } else {
                                Context context = v.getContext();
                                Intent intent = new Intent(context, FabReferenceActivity.class);
                                //intent.putExtra(ImageReferenceFragment.ARG_ITEM_ID, holder.mItem.id);

                                context.startActivity(intent);
                            }
                        }
                    });
                    break;
                default:
                holder.mItem = mValues.get(position);
                holder.mContentView.setText(mValues.get(position).content);

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mTwoPane) {
                            Bundle arguments = new Bundle();
                            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                            ItemDetailFragment fragment = new ItemDetailFragment();
                            fragment.setArguments(arguments);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.item_detail_container, fragment)
                                    .commit();
                        } else {
                            Context context = v.getContext();
                            Intent intent = new Intent(context, ItemDetailActivity.class);
                            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                            context.startActivity(intent);
                        }
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
