package com.montran.filter.data;

/**
 * Class that allow to create an OutputFilter
 * @author Wilson Aguilar
 */
public class OutputFilter extends BaseFilter {
    private final String replacement;

    public OutputFilter(String pattern, String replacement) {
        super(pattern);
        this.replacement = replacement;
    }

    /**
     * Makes a filter operation replacing the given pattern with the replacement string.
     * @param text - text to be filtered
     * @return filtered text
     */
    @Override
    public String filter(String text) {
        return text.replaceAll(this.pattern, replacement);
    }
}
