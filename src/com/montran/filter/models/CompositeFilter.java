package com.montran.filter.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilson Aguilar
 */
public class CompositeFilter extends BaseFilter {
    List<FilterOperation> filters;

    public CompositeFilter() {
        super(null);
        this.filters = new ArrayList<>();
    }

    public CompositeFilter apply(FilterOperation filter) {
        this.filters.add(filter);
        return this;
    }

    @Override
    public String filter(String text) {
        for (FilterOperation f : this.filters) {
            text = f.filter(text);
        }
        return text;
    }
}
