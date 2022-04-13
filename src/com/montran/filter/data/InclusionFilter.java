package com.montran.filter.data;

/**
 * Filter that only includes a pattern from the text
 * @author Wilson Aguilar
 */
public class InclusionFilter extends BaseFilter {

    public InclusionFilter(String pattern) {
        super(pattern);
    }

    /**
     * Filter the text including the given pattern
     * @param text - text to be filtered
     * @return filtered text
     */
    @Override
    public String filter(String text) {
        StringBuilder result = new StringBuilder();

        while (true) {
            int start = text.indexOf(this.pattern);

            if (start == -1 || text.length() < this.pattern.length())
                break;

            text = text.substring(start);
            result.append(text, 0, this.pattern.length());
            text = text.substring(this.pattern.length());

        }

        return result.toString();
    }
}
