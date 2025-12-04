package com.dsa.algorithms.strings;

/**
 * Solution for Leetcode 1108: Defanging an IP Address.
 * Given a valid (IPv4) IP address, return a defanged version of that IP
 * address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Problem Link:
 * <a href="https://leetcode.com/problems/defanging-an-ip-address/">Leetcode
 * 1108 - Defanging an IP Address</a>
 */
public class DefangIPaddr {
    /**
     * Main method to demonstrate the defangIPaddr function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }

    /**
     * Replaces every period "." with "[.]" in a given IPv4 IP address.
     * <p>
     * Time Complexity: O(N), where N is the length of the input string `address`.
     * The method iterates through the string once.
     * Space Complexity: O(N), where N is the length of the input string `address`.
     * A new StringBuilder is created to store the defanged IP address, which can be
     * up to N + 2 * (number of dots) characters long.
     *
     * @param address The IPv4 IP address string to be defanged.
     * @return The defanged IP address string.
     */
    static String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();

        for (Character ch : address.toCharArray()) {
            if (ch.equals('.')) {
                result.append("[.]");
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
