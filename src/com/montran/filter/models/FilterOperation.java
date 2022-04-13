package com.montran.filter.models;

/**
 * Define the basic operation of a filter.
 * @author Wilson Aguilar
 */
public interface FilterOperation {

    /**
     * Defines the filter operation to be executed.
     * @param text - text to be filtered
     * @return filtered text
     */
    String filter(String text);
}
