/**
 * @author liuqian
 * @date 2018/7/2 17:42
 * The sum of three numbers is ZERO.
 */
public class ThreeSumTest {

  @Test
  public void threeSumTest() {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));
  }


  private List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) continue;
      int j = i + 1;
      int k = nums.length - 1;
      int sum = 0 - nums[i];
      while (j < k) {
        if (j - 1 != i && nums[j] == nums[j - 1]) {
          j++;
          continue;
        }
        if (k + 1 != nums.length && nums[k] == nums[k + 1]) {
          k--;
          continue;
        }
        if (nums[j] + nums[k] == sum) res.add(Arrays.asList(nums[i], nums[j], nums[k]));
        if (nums[j] + nums[k] < sum) j++;
        else k--;
      }
    }
    return res;
  }
}
