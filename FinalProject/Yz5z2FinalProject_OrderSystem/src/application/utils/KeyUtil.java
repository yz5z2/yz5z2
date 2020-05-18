/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.utils;

import java.util.Random;

/**
 *
 * @author Yz5z2
 */
public class KeyUtil {
    /* order
    * Generate a unique primary key
    * Format: time + random number
    */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
