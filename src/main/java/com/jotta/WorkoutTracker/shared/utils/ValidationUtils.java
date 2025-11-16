package com.jotta.WorkoutTracker.shared.utils;

public class ValidationUtils {
    public static boolean isPositive(Number value) {
        return value != null && value.intValue() > 0;
    }
}
