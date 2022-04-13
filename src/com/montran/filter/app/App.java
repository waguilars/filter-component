package com.montran.filter.app;

import com.montran.filter.data.*;

import java.util.ResourceBundle;

/**
 * @author Wilson Aguilar
 */
public class App {

    public static void main(String[] args) {
        String text = "hello world with all the world around th world\n" +
                "world some thing nothing almost worldworld\n" +
                "inside the house in the world.\n";

//        CompositeFilter filter = new CompositeFilter();
//
//        filter.apply(new InclusionFilter("world "))
//                .apply(new OutputFilter("w", "x"))
//                .apply(new ExclusionFilter("l"));
//
//        System.out.println(filter.filter(text));

        ResourceBundle resources = ResourceBundle.getBundle("com.montran.filter.settings.config");

        DefaultFilterCreator systemFilter = new DefaultFilterCreator(resources);
        try {
            BaseFilter filter = systemFilter.create();
            System.out.println(filter.filter(text));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
