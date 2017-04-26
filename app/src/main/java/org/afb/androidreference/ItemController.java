package org.afb.androidreference;

import java.util.ArrayList;

/**
 * Created by wbreu on 4/25/2017.
 */

public class ItemController {
    private ArrayList<ReferenceItem> referenceItems;

    public ItemController() {
        referenceItems = new ArrayList<ReferenceItem>();
        referenceItems.add(new ReferenceItem("name","class","desc"));
        referenceItems.add(new ReferenceItem("name1","class1","desc1"));
        referenceItems.add(new ReferenceItem("name2","class2","desc2"));
        referenceItems.add(new ReferenceItem("name2","class2","desc2"));
    }

    public int getCount(){
        return referenceItems.size();
    }

    public ReferenceItem getItem(int i){
        return referenceItems.get(i);
    }
}
