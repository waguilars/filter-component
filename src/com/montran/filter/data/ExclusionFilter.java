package com.montran.filter.data;

/**
 * Filter that allow to exclude a word from a given text
 * @author Wilson Aguilar
 */
public class ExclusionFilter extends BaseFilter {

    public ExclusionFilter(String pattern) {
        super(pattern);
    }

    /**
     * Filter the text excluding the given pattern from the text
     * @param text - text to be filtered
     * @return filtered text
     */
    @Override
    public String filter(String text) {
        return text.replaceAll(this.pattern, "");
    }
}
