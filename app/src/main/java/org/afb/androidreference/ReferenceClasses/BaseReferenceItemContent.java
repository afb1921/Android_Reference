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

package org.afb.androidreference.ReferenceClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A class containing one page of test content.
 */
public abstract class BaseReferenceItemContent {
    private final Context mContext;
    private final String mSubtitle;
    private final String mDescription;

    public BaseReferenceItemContent(Context context, String subtitle, String description) {
        mContext = context;
        mSubtitle = subtitle;
        mDescription = description;
    }

    public Context getContext() {
        return mContext;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getDescription() {
        return mDescription;
    }

    protected String getString(int resId, Object... formatArgs) {
        return mContext.getString(resId, formatArgs);
    }

    abstract View getView(final LayoutInflater inflater, ViewGroup container, Context context);
}
