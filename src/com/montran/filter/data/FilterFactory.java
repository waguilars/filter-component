package com.montran.filter.data;

import java.util.ResourceBundle;

/**
 * Base class to create filter based creators
 * @author Wilson Aguilar
 */
public abstract class FilterFactory {
    protected ResourceBundle resources;
    protected String filterType;
    protected String filterSettings;

    public FilterFactory(ResourceBundle resources) {
        this.resources = resources;
        this.filterSettings = resources.getString("filter.settings");
        this.filterType = resources.getString("filter.type");
    }

    /**
     * This method returns dynamic filter.
     * @return Filter based on the implementation.
     * @throws Exception - Custom Exception
     */
    public abstract BaseFilter create() throws Exception;
}
