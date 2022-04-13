package com.montran.filter.app;

import com.montran.filter.models.CompositeFilter;
import com.montran.filter.models.ExclusionFilter;
import com.montran.filter.models.InclusionFilter;
import com.montran.filter.models.OutputFilter;

/**
 * @author Wilson Aguilar
 */
public class App {

    public static void main(String[] args) {
        String text = "hello world with all the world around th world\n" +
                "world some thing nothing almost worldworld\n" +
                "inside the house in the world.\n";

        CompositeFilter filter = new CompositeFilter();

        filter.apply(new InclusionFilter("world "))
                .apply(new OutputFilter("w", "x"))
                .apply(new ExclusionFilter("l"));

        System.out.println(filter.filter(text));

    }

}
