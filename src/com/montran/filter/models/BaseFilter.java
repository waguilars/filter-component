package com.montran.filter.models;

/**
 * Base class that describes a basic filter object
 * @author Wilson Aguilar
 */
public abstract class BaseFilter implements FilterOperation {
    protected String pattern;

    public BaseFilter(String pattern) {
        this.pattern = pattern;
    }
}
