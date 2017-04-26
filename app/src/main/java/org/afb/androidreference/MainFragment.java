package org.afb.androidreference;

/**
 * Created by wbreu on 4/25/2017.
 */

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A fragment listing all the test sessions.
 */
public class MainFragment extends Fragment implements AdapterView.OnItemClickListener {
    // The callback for selection of test session.
    private NavigationCallback mCallback;

    private Callbacks mCallbacks = sDummyCallbacks;
    // The controller containing all the test information.
    private ItemController mController;
    // The list adapter for listing test sessions.
    private ReferenceItemListAdapter mAdapter;

    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(int position);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(int position) {
        }
    };

    public void setOnSessionSelectedCallback(NavigationCallback callback) {
        mCallback = callback;
    }

    public void setTestController(ItemController controller) {
        mController = controller;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + mController.getItem(position).getName(), Toast.LENGTH_SHORT).show();
        mCallbacks.onItemSelected(position);

    }
    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setHasOptionsMenu(true);
        mAdapter = new ReferenceItemListAdapter(getActivity(), mController, mCallback);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_sort_by_alphabet:
//                mController.setOrderType(getContext(), TestController.ORDER_ALPHABET);
//                mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.action_sort_by_default:
//                mController.setOrderType(getContext(), TestController.ORDER_DEFAULT);
//                mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.action_sort_by_most_frequently_used:
//                mController.setOrderType(getContext(), TestController.ORDER_MOST_FREQUENTLY_USED);
//                mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.action_sort_by_most_recently_used:
//                mController.setOrderType(getContext(), TestController.ORDER_MOST_RECENTLY_USED);
//                mAdapter.notifyDataSetChanged();
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            final ActionBar toolbar = activity.getSupportActionBar();
            if (toolbar != null) {
                toolbar.setDisplayHomeAsUpEnabled(false);
                toolbar.setDisplayShowHomeEnabled(true);
                toolbar.setDisplayShowCustomEnabled(false);
                toolbar.setTitle(R.string.app_name);
            }
            activity.setTitle(R.string.app_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView testListView = (ListView) view.findViewById(R.id.list);
        testListView.setAdapter(mAdapter);
        testListView.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Activities containing this fragment must implement its callbacks.
        if (!(context instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }
        mCallbacks = (Callbacks) context;
    }
}