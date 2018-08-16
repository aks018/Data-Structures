import java.util.HashSet;
import java.util.Set;

public class TwoPointer {

    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
     */

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /*
    Given two arrays, write a function to compute their intersection.

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }

        int[] arr = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            arr[i++] = num;
        }

        return arr;
    }


}
