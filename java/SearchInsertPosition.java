package leetcode;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/8/13 17:23
 */
public class SearchInsertPosition {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     *
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     */
    @Test
    public void searchInsertPositionTest() {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }

    /**
     * 二分法解决
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
