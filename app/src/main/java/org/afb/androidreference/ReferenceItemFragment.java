package org.afb.androidreference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wbreu on 4/26/2017.
 */

public class ReferenceItemFragment extends Fragment {
    private int mSessionId;
    private int mContentIndex;
//
//    // Callback when navigation button is clicked.
//    private NavigationCallback mCallback;

    public void setSession(int sessionId, int contentIndex) {
        mSessionId = sessionId;
        mContentIndex = contentIndex;
    }

//    public void setNavigationCallback(NavigationCallback callback) {
//        mCallback = callback;
//    }

    @Override
    public void onResume() {
        super.onResume();
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        final String title = TestController.getInstance().getSessionById(mSessionId).getTitle();
        if (activity != null) {
            final ActionBar toolbar = activity.getSupportActionBar();
            if (toolbar != null) {
                toolbar.setDisplayHomeAsUpEnabled(true);
                toolbar.setDisplayShowHomeEnabled(true);
                toolbar.setDisplayShowCustomEnabled(false);
                toolbar.setTitle(title);
            }
            activity.setTitle(title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        final View view = inflater.inflate(R.layout.fragment_test_content, container, false);

        final BaseTestContent content = TestController.getInstance().getSessionById(mSessionId)
                .getTestContent(mContentIndex);

        final TextView description = (TextView)
                (view.findViewById(R.id.contentContainer).findViewById(R.id.description));
        description.setText(Html.fromHtml(content.getDescription()));
        description.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView subtitle = (TextView)
                (view.findViewById(R.id.contentContainer).findViewById(R.id.title));
        subtitle.setText(content.getSubtitle());

        final Button previous = (Button) view.findViewById(R.id.previous);
        previous.setOnClickListener(this);

        final Button next = (Button) view.findViewById(R.id.next);
        next.setOnClickListener(this);

        assignButtonText(previous, next);

        final ViewGroup contentArea = (ViewGroup) view.findViewById(R.id.content_area);
        contentArea.addView(content.getView(inflater, contentArea, getContext()));

        return view;
    }

    @Override
    public void onClick(View v) {
        if (mCallback == null) {
            return;
        }
        switch (v.getId()) {
            case R.id.next:
                mCallback.onNextContentClicked(mSessionId, mContentIndex);
                break;
            case R.id.previous:
                mCallback.onPreviousContentClicked(mSessionId, mContentIndex);
                break;
        }
    }

    private void assignButtonText(Button previousButton, Button nextButton) {
        final TestController controller = TestController.getInstance();

        if (mContentIndex > 0) {
            previousButton.setText(R.string.button_previous_page);
        } else if (controller.getPreviousSessionById(mSessionId) != null) {
            previousButton.setText(R.string.button_previous_category);
        } else {
            previousButton.setText(R.string.button_home);
        }

        final TestSession session = controller.getSessionById(mSessionId);
        if (mContentIndex < session.getContentCount() - 1) {
            nextButton.setText(R.string.button_next_page);
        } else if (controller.getNextSessionById(mSessionId) != null) {
            nextButton.setText(R.string.button_next_category);
        } else {
            nextButton.setText(R.string.button_home);
        }
    }
}
