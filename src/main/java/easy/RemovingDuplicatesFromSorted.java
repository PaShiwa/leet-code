package src.main.java.easy;

public class RemovingDuplicatesFromSorted {

    public static void main(String[] args) {
        int[] numbers = {0,0,1,1,1,2,2,3,3,4};
        int newLength = removeDuplicates(numbers);

        System.out.println("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
    public static int removeDuplicates(int[] numbers) {
        if (numbers.length == 0) return 0;
        int index = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[index]) {
                // The first position is fixed for the first element, hence increase the index first.
                index++;
                numbers[index] = numbers[i];
            }
        }
        return index + 1;
    }
}

