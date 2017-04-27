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
        referenceItems.add(new ReferenceItem("Checkbox",org.afb.androidreference.ReferenceClasses.CheckbockReferenceContent.class,"Checkbox tests"));
        referenceItems.add(new ReferenceItem("Image Reference",org.afb.androidreference.ReferenceClasses.ImageReferenceContent.class,"Image reference stuff"));
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
