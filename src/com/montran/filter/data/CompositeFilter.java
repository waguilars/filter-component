package com.montran.filter.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow us to concatenate several FilterOperation
 * to be executed.
 * @author Wilson Aguilar
 */
public class CompositeFilter extends BaseFilter {
    List<BaseFilter> filters;

    public CompositeFilter() {
        super(null);
        this.filters = new ArrayList<>();
    }

    /**
     * Append a new FilterOperation.
     * @param filter - An implementation of FilterOperation
     * @return CompositeFilter with the new filter added
     */
    public CompositeFilter apply(BaseFilter filter) {
        this.filters.add(filter);
        return this;
    }

    /**
     * String as a result of execute the filter method of the list of FilterOperations
     * @param text - text to be filtered
     * @return filtered text
     */
    @Override
    public String filter(String text) {
        for (BaseFilter f : this.filters) {
            text = f.filter(text);
        }
        return text;
    }
}
