/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    @Test
    public void testImplementationRequiredNotAllowed() {
        // The assignment requires you to implement the feature.
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, false, false, true, true));
    }
    @Test
    public void testWrittenAsCourseWorkAndCitingYourSourceNotAllowed() {
        // Code was written as part of a 6.005 assignment but didn't cite the source.
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));
    }
    @Test
    public void testAllConditionsMetAllowed() {
        // You wrote the code, cited your source, and it's not part of a 6.005 assignment.
        assertTrue(RulesOf6005.mayUseCodeInAssignment(true, false, false, true, false));
    }
}
