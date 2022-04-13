package com.montran.filter.data;

import java.util.ResourceBundle;

/**
 * Creator class of Filters based on a configuration file.
 * @author Wilson Aguilar
 */
public class DefaultFilter extends FilterFactory {

    public DefaultFilter(ResourceBundle resources) {
        super(resources);
    }

    /**
     * Create a dynamic filter based in the <pre>config.properties</pre> file
     * To configure a filter you can set these properties in the configuration file:
     * filter.type=i
     * filter.settings=text
     * Available types are: i -> InclusionFilter, e -> ExclusionFilter, o -> OutputFilter
     * Settings for the same types are: i -> text, e -> text, o -> text:replacement
     *
     * If you need to create a CompositeFilter, you need append more types and settings splitted by a (,)
     *
     * filter.type=i,o,e
     * filter.settings=world ,w:x,l
     *
     * @return filter based on the configuration.
     * @throws Exception is thrown when the format is wrong or when you are sending a not valid filter
     */
    @Override
    public BaseFilter create() throws Exception {

        if (filterType.contains(",")) {
            String[] types = filterType.split(",");
            String[] params = filterSettings.split(",");
            return this.createCompositeFilter(types, params);
        }

        return checkFilterType(this.filterType, this.filterSettings);
    }

    private InclusionFilter createInclusionFilter(String pattern) {
        return new InclusionFilter(pattern);
    }

    private ExclusionFilter createExclusionFilter(String pattern) {
        return new ExclusionFilter(pattern);
    }

    private OutputFilter createOutputFilter(String pattern) throws Exception {
        if (!pattern.contains(":")) {
            throw new Exception("Wrong format exception, the output filter needs 2 params split with (:)");
        }
        String[] params = pattern.split(":");
        return new OutputFilter(params[0], params[1]);
    }

    private CompositeFilter createCompositeFilter(String[] types, String[] params) throws Exception {
        CompositeFilter filter = new CompositeFilter();

        for (int i = 0; i < types.length; i++) {
            filter.apply(checkFilterType(types[i], params[i]));
        }
        return filter;
    }

    private BaseFilter checkFilterType(String type, String pattern) throws Exception {
        switch (type) {
            case "i":
                return createInclusionFilter(pattern);
            case "e":
                return createExclusionFilter(pattern);
            case "o":
                return createOutputFilter(pattern);
        }

        throw new Exception("Type does not match with any of supported types (i - inclusion, e - exclusion, o - output)");
    }
}
