import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; 

                }
            }
        }
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String roman) {
        Map<Character, Integer> convertMap = new HashMap<>(); 
        convertMap.put('I', 1);
        convertMap.put('V', 5);
        convertMap.put('X', 10);
        convertMap.put('L', 50);
        convertMap.put('C', 100);
        convertMap.put('D', 500);
        convertMap.put('M', 1000);

        int number = 0, prev = 0; 

        for (int i = 0; i < roman.length(); i++) {

            int current = convertMap.get(roman.charAt(i)); 
            /* 
            If the current character has a greater value than the previous one,
            we subtract twice the value of the smaller one. 
            */
            if (current > prev) {
                number += current - 2 * prev;
            } else {
                number += current;
            }

            prev = current; 
                

        }
        return number;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output_list = new ArrayList<>();
        findPermutations(nums, output_list, new ArrayList<>());
        return output_list;
    }

    private void findPermutations(int[] nums, List<List<Integer>> output_list, List<Integer> temp_list) {
        if (temp_list.size() == nums.length) {
            output_list.add(new ArrayList<>(temp_list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // if a number is already in the permutation, skip it 
                if (temp_list.contains(nums[i])) continue;
                temp_list.add(nums[i]);
                findPermutations(nums, output_list, temp_list);
                // After trying a number, remove it from the permutation
                temp_list.remove(temp_list.size() - 1);


            }
        }
    }

    public static void main(String[] args) {
        // test your code here!

    }
}