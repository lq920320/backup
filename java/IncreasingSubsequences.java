package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuqian
 * @date 2020/8/25 14:57
 */
public class IncreasingSubsequences {

    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     *
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     *
     * 说明:
     *     给定数组的长度不会超过15。
     *     数组中的整数范围是 [-100,100]。
     *     给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void solutionTest() {

    }


    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> findSubsequences1(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; i++) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod +(x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }


    List<Integer> temp2 = new ArrayList<>();
    List<List<Integer>> ans2 = new ArrayList<>();

    public List<List<Integer>> findSubsequences2(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans2;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp2.size() >= 2) {
                ans2.add(new ArrayList<>(temp2));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp2.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp2.remove(temp2.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
