package org.afb.androidreference;

import android.content.Context;

import org.afb.androidreference.ReferenceClasses.BaseReferenceItemContent;
import org.json.JSONException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wbreu on 4/25/2017.
 */

public class ReferenceItem {
    private String name;
    private Class _class;
    private String description;

    @Override
    public String toString() {
        return "ReferenceItem{" +
                "name='" + name + '\'' +
                ", class_name='" + _class.toString() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public BaseReferenceItemContent getTestContent(int index, Context context) {
        try {
            return createContent(context, index);
        }
        catch(Exception e)
        {
            throw new IllegalStateException("Failed to create test content object. "
                    + e.getMessage());
        }
    }

    private BaseReferenceItemContent createContent(Context context, int index) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, JSONException {
//        final String subtitleResourceName = JsonUtils.getString(content, JSON_KEY_SUBTITLE);
//        final String descriptionResourceName = JsonUtils.getString(content, JSON_KEY_DESCRIPTION);
//        final String className = JsonUtils.getString(content, JSON_KEY_CLASSNAME);
        final Constructor<?> constructor = _class.getConstructor(
                Context.class, String.class, String.class);

//        final String subtitle =
//                JsonUtils.readStringByResourceIdFromString(context, subtitleResourceName);
//        final String description =
//                JsonUtils.readStringByResourceIdFromString(context, descriptionResourceName);
        final BaseReferenceItemContent testContent = (BaseReferenceItemContent) constructor.newInstance(
                context, "subtitle", description);

        return testContent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReferenceItem(String name, Class<?> _class, String description) {

        this.name = name;
        this._class = _class;
        this.description = description;
    }
}
