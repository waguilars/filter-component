package com.montran.filter.models;

/**
 * @author Wilson Aguilar
 */
public class ExclusionFilter extends BaseFilter {

    public ExclusionFilter(String pattern) {
        super(pattern);
    }

    @Override
    public String filter(String text) {
        return text.replaceAll(this.pattern, "");
    }
}
