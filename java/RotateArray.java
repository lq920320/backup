package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuqian
 * @date 2020/8/25 8:12
 */
public class RotateArray {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     * 说明:
     *     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     *     要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void rotateTest() {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums1));
        rotate1(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, -100, 3, 99};
        System.out.println(Arrays.toString(nums2));
        rotate2(nums2, 2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums3));
        rotate3(nums3, 3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {1, -100, 3, 99};
        System.out.println(Arrays.toString(nums4));
        rotate4(nums4, 2);
        System.out.println(Arrays.toString(nums4));
    }


    /**
     * 暴力法
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int temp;
        int previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 方法 2：使用额外的数组(不符合要求)
     *
     * 算法
     *
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 i 的我们把它放到 (i+k)%数组长度(i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 使用环状替换
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 反转数组
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
