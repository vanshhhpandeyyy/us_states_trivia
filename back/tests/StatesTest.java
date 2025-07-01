package back.tests;

import back.src.States;

public class StatesTest {
    public static void main(String[] args) {
        testValidState();
        testInvalidState();
        testCaseInsensitivity();
        testTotalCount();
    }

    public static void testValidState() {
        if (States.validStates.contains("california") && States.validStates.contains("new york")) {
            System.out.println("testValidState passed");
        } else {
            System.out.println("testValidState FAILED");
        }
    }

    public static void testInvalidState() {
        if (!States.validStates.contains("wakanda") && !States.validStates.contains("atlantis")) {
            System.out.println("testInvalidState passed");
        } else {
            System.out.println("testInvalidState FAILED");
        }
    }

    public static void testCaseInsensitivity() {
        if (States.validStates.contains("texas".toLowerCase())) {
            System.out.println("testCaseInsensitivity passed");
        } else {
            System.out.println("testCaseInsensitivity FAILED");
        }
    }

    public static void testTotalCount() {
        if (States.validStates.size() == 50) {
            System.out.println("testTotalCount passed");
        } else {
            System.out.println("testTotalCount FAILED");
        }
    }
}
