/*
 * This file is part of Meteor Satellite Addon (https://github.com/crazycat256/meteor-satellite-addon).
 * Copyright (c) crazycat256.
 */

package com.allinone.utils;

public class MathUtils {

    public static double mod(double x, double y) {
        return (((x % y) + y) % y);
    }

}
