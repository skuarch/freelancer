package model.logic;

import java.util.ArrayList;

/**
 *
 * @author skuarch
 */
public class I18N {
    
    private static final ArrayList<String> arrayList = new ArrayList<>(100);
    
    static{
        System.out.println("creating arrayList i18n");
        arrayList.clear();        
        arrayList.add("text12");
        arrayList.add("text13");
        arrayList.add("text14");
        arrayList.add("text15");
        arrayList.add("text20");
        arrayList.add("text21");
        arrayList.add("text44");
        arrayList.add("text45");
        arrayList.add("text46");
        arrayList.add("text47");
        arrayList.add("text48");
        arrayList.add("text49");
        arrayList.add("text50");
        arrayList.add("text51");
        arrayList.add("text52");
        arrayList.add("text53");
        arrayList.add("text54");
        arrayList.add("text55");
        arrayList.add("text74");
        arrayList.add("text76");
        arrayList.add("text78");
        arrayList.add("text80");
        arrayList.add("text82");
        arrayList.add("text84");
        arrayList.add("text86");
        arrayList.add("text88");
        arrayList.add("text90");
        arrayList.add("text92");
        arrayList.add("text97");
        arrayList.add("text98");
        arrayList.add("text101");
        arrayList.add("text102");
        arrayList.add("text103");
        arrayList.add("text104");
        arrayList.add("text105");
        arrayList.add("text106");
        arrayList.add("text107");
        arrayList.add("text108");
        arrayList.add("text109");
        arrayList.add("text110");
        arrayList.add("text111");
        arrayList.add("text112");
        arrayList.add("text113");
        arrayList.add("text114");
        arrayList.add("text115");
        arrayList.add("text116");
        arrayList.add("text117");
        arrayList.add("text118");
        arrayList.add("text119");
        arrayList.add("text120");
        arrayList.add("text121");
        arrayList.add("text122");
        arrayList.add("text123");
        arrayList.add("text136");
        arrayList.add("text137");
        arrayList.add("text138");
        arrayList.add("text139");
        arrayList.add("text143");
        arrayList.add("text144");
        arrayList.add("text145");
    }
    
    private I18N(){
    }

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }
    
}
