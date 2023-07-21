package com.simple4h.sample.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <url><a href="https://leetcode.cn/problems/zigzag-conversion/submissions/">N字形变换</a></url>
 *
 * @author Simple4H
 */
public class Convert {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
