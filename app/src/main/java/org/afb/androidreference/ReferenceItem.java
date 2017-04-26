package org.afb.androidreference;

/**
 * Created by wbreu on 4/25/2017.
 */

public class ReferenceItem {
    private String name;
    private String class_name;
    private String description;

    @Override
    public String toString() {
        return "ReferenceItem{" +
                "name='" + name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReferenceItem(String name, String class_name, String description) {

        this.name = name;
        this.class_name = class_name;
        this.description = description;
    }
}
