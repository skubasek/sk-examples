package sk.examples.integer.sum;

import java.util.HashMap;
import java.util.Map;

import com.sun.tools.internal.xjc.Language;

/**
 * TODO: add 1 sentence description
 */
public class ProductOfThree {

    // Given an array or list of integers, e.g. [-11,-9,-5,0,1,3,6], find the highest product of any three of them without sorting the list.

    /*
    [-11, -8, -7, -5, -3, -2, 1]
    find the highest and lowest number
    10, -11
    find the 2nd highest
    -2, -8
    find the 3rd highest (could be positive or negative)
    -3, -7
    if highest number negative
      multiply 3 lowest numbers
    else
      -11 * -8
      multiply 2 abs highest, with highest

    */
    static long highestProductOf3(int[] ints) {
        int LOWEST = -9999999; /// assume lowest
        int HIGHEST = 999999; // highest

        // keep track of 3 highest & 3 lowest
        Map<String, Integer> map = new HashMap<>();

        int high = LOWEST;
        int low = HIGHEST;

        /* finding highest

        1, 2, 3
        on each int
            if higher than current, replace


         */

        // [-11, -8, -5, 0, -2, 1]
        for (int n : ints) {
            // -8, idx 2
            for (int i = 1; i <= 3; i++) {
                String highkey = "high_" + i;
                String lowkey = "low_" + i;

                high = map.getOrDefault(highkey, high); // -11
                if (n > high) {
                    map.put(highkey, n);

                    // is n higher than the next high
                    int high2 = map.getOrDefault()
                    if ()
                    break;
                }


//                low = map.getOrDefault(lowkey, low);
//                if (n < low) {
//                    map.put(lowkey, low);
//                    break;
//                }
            }
        }

        System.out.println(map);


        if (map.get("high_1") < 0) {
            return map.get("low_1") * map.get("low_2") * map.get("low_3");
        } else {
            return -1;
        }

    }


    public static void main(String[] args) {
        highestProductOf3(new int[]{-11,-9,-5,0,1,3,6});
    }
}
