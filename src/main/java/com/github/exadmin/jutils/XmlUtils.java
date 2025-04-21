package com.github.exadmin.jutils;

import org.jdom2.Element;

public class XmlUtils {
    /**
     * Ensures that provided xml elements has expected name.
     * Throws AssertionError in fail case.
     * @param expectedName String expected value
     * @param xmlElement JDOM element instance to check name for
     */
    public static void assertElementName(String expectedName, Element xmlElement) {
        if (!expectedName.equals(xmlElement.getName())) throw new AssertionError("Unexpected element name. Current name = " + xmlElement.getName() + ", expected name = " + expectedName);
    }
}
