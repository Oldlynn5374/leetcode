import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            Integer value = nums[i];
            map.put(value,i);
        }

        int[]result = new int[2];

        for(int i = 0;i < nums.length;i++){
            Integer subbed = nums[i];
            Integer sub = target - subbed;
            Integer index2 = map.get(sub);
            if(index2 == null || index2==i){
                continue;
            }else{
                result[0] = i;
                result[1] = index2;
                return result;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{3,2,4};
        int target = 6;
        int []result = new TwoSum().twoSum(nums,target);
        for(int i : result){
            System.out.println(i);
        }
    }
}
