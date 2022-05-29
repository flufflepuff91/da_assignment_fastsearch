/*
 * Project: Assignment 4 Datastructures and Algorithms Stack
 * Last Change:01.01.2022
 * Author: Jennifer Gassner
 */

package com.da.search;

/**
 * Class that implements the FastSearch search algorithm.
 */

public class FastSearch {

    /**
     * Array to be searched for x
     */
    private int[] data_array;

    /**
     * Constructor for a fast search instance.
     *
     * @param data_array array to be searched.
     */
    public FastSearch(int[] data_array) {
        this.data_array = data_array;
    }

    /**
     * Implements fastsearch. The array is split into three subarrays.  Initially subarray A goes from index 0 to index
     * m_B-1 (m_B = midpoint in BinarySearch), subarray B goes from m_B+1 to m_I-1 (m_I = index computed by
     * InterpolationSearch) and subarray C goes from m_I+1 to data_array.length-1.
     * Based on x the correct subarray is chosen and the method is called recursively until the element is found or
     * it was determined that the element is not contained within the array.
     *
     * @param from from index
     * @param to   to index
     * @param x    searched element
     * @return index of x or -1 of x does not exist within data_array
     */
    public int fastSearch(int from, int to, int x) {
        if (to - from == 0) {
            if (data_array[from] == x) {
                return from;
            }
        }
        int intpoSum = data_array[to] + data_array[from];
        double intpoFrac = x / (double) intpoSum;
        int intpoIdx = from + (int) Math.ceil((to - from) * intpoFrac);
        int intpoElem = data_array[intpoIdx];
        //System.out.println("[DEBUG:] Länge der halben Liste: " + binlist);
        if (intpoElem == x) {
            return intpoIdx;
        } else {
            int binIdx = from + ((to - from) / 2);
            int binElem = data_array[binIdx];
            if (binElem == x) {
                return binIdx;
            } else {
                if (intpoIdx < binIdx) {
                    if (x < intpoElem) {
                        return fastSearch(from, intpoIdx, x);
                    } else {
                        return fastSearch(intpoIdx, binIdx, x);
                    }
                } else {
                    if (x < intpoElem) {
                        return fastSearch(binIdx, intpoIdx, x);
                    } else {
                        return fastSearch(intpoIdx, to, x);
                    }
                }
            }
        }
    }
}
