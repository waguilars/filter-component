package com.montran.filter.models;

/**
 * @author Wilson Aguilar
 */
public abstract class BaseFilter implements FilterOperation {
    protected String pattern;

    public BaseFilter(String pattern) {
        this.pattern = pattern;
    }
}
