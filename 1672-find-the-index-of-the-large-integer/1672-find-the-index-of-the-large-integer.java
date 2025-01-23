/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * // Compares the sum of arr[l..r] with the sum of arr[x..y]
 * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 * public int compareSub(int l, int r, int x, int y) {}
 *
 * // Returns the length of the array
 * public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int length = reader.length();

        while (length > 1) {
            length /= 2;
            int l = left;
            int r = left + length - 1;
            int x = r + 1;
            int y = x + length - 1;
            int result = reader.compareSub(l, r, x, y);
            if (result == 0) {
                return y + 1;
            } else if (result < 0) {
                left += length;
            }
        }
        return left;
    }
}