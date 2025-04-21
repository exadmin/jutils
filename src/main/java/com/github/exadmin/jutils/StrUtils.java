package com.github.exadmin.jutils;

public class StrUtils {

    /**
     * Returns true in case provided argument is null or empty
     * @param str String to check
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Returns true in case provided argument is not null and is not empty
     * @param str String to check
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Replaces content of the string by new one.
     * @param template where to replace
     * @param replacementPrefix start place in the template which will be replaced
     * @param replacementSuffix end place in the template which will be replaced
     * @param replaceWith the new content to be put into template
     * @return new string result
     */
    public static String replaceContent(String template, String replacementPrefix, String replacementSuffix, String replaceWith){
        int cutStart = template.indexOf(replacementPrefix);
        int cutEnd   = template.indexOf(replacementSuffix) + replacementSuffix.length();

        return template.substring(0, cutStart) +
                "\n" +
                replaceWith +
                "\n" +
                template.substring(cutEnd);
    }

    /**
     * In case first argument is null - returns some default value instead.
     * The default value is got from second argument or empty string is returned in case nothing is speficied.
     * @param str String value to check for nullness
     * @return non null value
     */
    public static String getNonNullValue(String str, String ... defaultValue) {
        if (str != null) return str;

        if (defaultValue == null || defaultValue.length == 0) return "";
        if (defaultValue.length > 1) throw new IllegalArgumentException("defaultValue argument must have only one value");

        return defaultValue[0];
    }
}
