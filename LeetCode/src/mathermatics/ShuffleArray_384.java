package mathermatics;

import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

public class ShuffleArray_384 {
    private int[] origin;
    private int[] array;
    private Random random;

    public ShuffleArray_384(int[] nums) {
        origin = nums;
        array = nums.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin.clone();
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int pos = i + random.nextInt(array.length - i);
            int temp = array[i];
            array[i] = array[pos];
            array[pos] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray_384 shuffleArray = new ShuffleArray_384(nums);

        int[] shuffle = shuffleArray.shuffle();
        for (int i : shuffle) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] shuffle2 = shuffleArray.shuffle();
        for (int i : shuffle2) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] shuffle3 = shuffleArray.shuffle();
        for (int i : shuffle3) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] reset = shuffleArray.reset();
        for (int i : reset) {
            System.out.print(i + " ");
        }

    }
}
