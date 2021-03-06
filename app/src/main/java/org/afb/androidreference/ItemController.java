package org.afb.androidreference;

import java.util.ArrayList;

/**
 * Created by wbreu on 4/25/2017.
 */

public class ItemController {
    private ArrayList<ReferenceItem> referenceItems;
    private static ItemController sItemController;
    public ItemController() {
        referenceItems = new ArrayList<ReferenceItem>();
        referenceItems.add(new ReferenceItem("Checkbox",org.afb.androidreference.ReferenceClasses.CheckboxReferenceContent.class,"Checkbox tests"));
        referenceItems.add(new ReferenceItem("Image Reference",org.afb.androidreference.ReferenceClasses.ImageReferenceContent.class,"Image reference"));
        referenceItems.add(new ReferenceItem("Floating Action Button",org.afb.androidreference.ReferenceClasses.FabReferenceContent.class,"Floating action button"));
        referenceItems.add(new ReferenceItem("Edit Text",org.afb.androidreference.ReferenceClasses.EditTextReferenceContent.class,"Edit Text"));
        referenceItems.add(new ReferenceItem("Spinner",org.afb.androidreference.ReferenceClasses.SpinnerReferenceContent.class,"Spinner"));
        referenceItems.add(new ReferenceItem("Tab Layout",org.afb.androidreference.ReferenceClasses.TabLayoutReferenceContent.class,"Tab Layout"));
        referenceItems.add(new ReferenceItem("Focus Order",org.afb.androidreference.ReferenceClasses.FocusOrderReferenceContent.class,"Focus Order"));
    }

    public int getCount(){
        return referenceItems.size();
    }

    public ReferenceItem getItem(int i){
        return referenceItems.get(i);
    }

    public static ItemController getInstance() {
        if (sItemController == null) {
            sItemController = new ItemController();
        }
        return sItemController;
    }
}
