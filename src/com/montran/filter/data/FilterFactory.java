package com.montran.filter.data;

import java.util.ResourceBundle;

/**
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

    public abstract BaseFilter create() throws Exception;
}
