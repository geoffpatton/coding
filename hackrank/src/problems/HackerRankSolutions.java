package problems;

class HackerRankSolutions {

    /**
     * Jumping on the Clouds
     * <p>
     * Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
     * Jump on any 0 cloud that is 1 or 2 ahead of your current cloud
     * 
     * @param c int array containing 0's and 1's
     * @return the minimum number of jumps required, as an integer.
     */
    int jumpingOnClouds(int[] c) {
        int len = c.length;

        if (len < 3) {
            return 1; // return one when length is less than 3
        }

        int jump = 0;
        for (int i = 0; i < len - 2; ++i, ++jump) {
            if (c[i + 2] == 0) {
                ++i; // when two ahead is 0 jump to it and increment i
            }
            if (i == len - 3) {
                ++jump; // add another jump since we need to move one more space
            }
        }
        return jump;
    }

    /**
     * Find the maximum hour glass sum from the 6x6 array
     * 
     * @param arr
     * @return largest (maximum) hourglass sum found in the given array
     */
    int hourglassSum(int[][] arr) {
        int colLen = arr.length;
        int rowLen = arr[0].length;

        int maxSum = Integer.MIN_VALUE; // set Max Sum to Integer Min value
        for (int i = 0; i < colLen - 2; ++i) {
            for (int y = 0; y < rowLen - 2; ++y) {
                maxSum = Math.max(maxSum, arr[i][y] + arr[i][y + 1] + arr[i][y + 2] + arr[i + 1][y + 1] + arr[i + 2][y]
                    + arr[i + 2][y + 1] + arr[i + 2][y + 2]);
            }
        }
        return maxSum;
    }

    /**
     * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above.
     * Once sorted, print the following three lines:
     * <p>
     * Array is sorted in (count) swaps.
     * First Element: a[0]
     * Last Element: a[len -1]
     * 
     * @param a array of integers
     * @return number of swaps. added for testing
     */
    int countSwaps(int[] a) {
        int len = a.length;
        int swaps = 0;
        int tmp = 0;

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - 1; ++j) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    ++swaps;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[len - 1]);

        return swaps;
    }

    /**
     * Given a string, determine how many special substrings can be formed from it.
     * 
     * @param n an integer, the length of string s
     * @param s String
     * @return count of total special substrings.
     */
    long substrCount(int n, String s) {
        long count = 0;

        // when all letters are the same
        int index;
        for (int i = 0; i < n; ++i) {
            index = i;
            while (index < n && s.charAt(i) == s.charAt(index)) {
                ++index;
            }
            count += index - i;
        }

        int prevIndex;
        int nextIndex;
        char first;
        // when middle letter is different
        for (int i = 1; i < n; ++i) {
            index = 1;
            nextIndex = i + index;
            prevIndex = i - index;
            first = s.charAt(prevIndex);
            while (prevIndex >= 0 && nextIndex < n && s.charAt(prevIndex) == s.charAt(nextIndex)
                && first == s.charAt(nextIndex) && s.charAt(nextIndex) != s.charAt(i)) {
                ++index;
                nextIndex = i + index;
                prevIndex = i - index;
            }
            count += index - 1;
        }
        return count;
    }

    /**
     * Given an array of integers: a, and a number: d, perform d left rotations on the array.
     * Return the updated array to be printed as a single line of space-separated integers.
     * 
     * @param a array of integer
     * @param d number of left rotations to perform
     * @return the rotated array
     */
    int[] rotLeft(int[] a, int d) {
        int len = a.length;
        int end; // end index location
        int[] result = new int[len]; // new array to hold the result

        // iterate over each element
        for (int x = 0; x < len; ++x) {
            end = x - d; // find the end location of the element
            if (end < 0) {
                end += len;
            }
            result[end] = a[x]; // place element in the result array
        }
        return result;
    }
}
