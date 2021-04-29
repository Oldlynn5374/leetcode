package mathermatics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight_528 {

    private int total = 0;
    private Random random;

    private List<Integer> pick;

    public RandomPickWithWeight_528(int[] w) {
        pick = new ArrayList<>();
        random = new Random();

        int pos = 0;
        for (int i = 0; i < w.length; i++) {
            int value = w[i];
            total += value;

            // int[] range = new int[]{pos, pos + value - 1};
            pos += value;
            pick.add(pos);
        }

    }

    public int pickIndex() {
        int rand = random.nextInt(total);
        return getIndex(rand);
    }

    public int getIndex(int value) {
        int begin = 0;
        int end = pick.size() - 1;
        int result = 0;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            int midVal = pick.get(mid);

            if (begin == mid) {
                if (value < midVal) {
                    result = begin;
                }else {
                    if (value < pick.get(end)) {
                        result = end;
                    }
                }
            }

            if (value >= midVal) {
                begin = mid + 1;
            }else {
                result = mid;
                end = mid;
            }

            if (begin == end) {
                if (pick.get(end) > value) {
                    return end;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] w = {3,8,5,9,2,9};
        RandomPickWithWeight_528 randomPick = new RandomPickWithWeight_528(w);
        System.out.println(randomPick.pickIndex());
        System.out.println(randomPick.pickIndex());
        System.out.println(randomPick.pickIndex());
        System.out.println(randomPick.pickIndex());
        System.out.println(randomPick.pickIndex());


    }
}
