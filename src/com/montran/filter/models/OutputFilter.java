package com.montran.filter.models;

/**
 * @author Wilson Aguilar
 */
public class OutputFilter extends BaseFilter {
    private final String replacement;

    public OutputFilter(String pattern, String replacement) {
        super(pattern);
        this.replacement = replacement;
    }

    @Override
    public String filter(String text) {
        return text.replaceAll(this.pattern, replacement);
    }
}
