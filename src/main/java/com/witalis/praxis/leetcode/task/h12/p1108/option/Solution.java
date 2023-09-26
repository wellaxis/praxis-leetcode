package com.witalis.praxis.leetcode.task.h12.p1108.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1108
 * Name: Defanging an IP Address
 * URL: <a href="https://leetcode.com/problems/defanging-an-ip-address/">Defanging an IP Address</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String address;

    public String process() {
        return defangIPaddr(address);
    }

    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for (char c : address.toCharArray()){
            str.append((c == '.')? "[.]" : c );
        }

        return str.toString();
    }
}
