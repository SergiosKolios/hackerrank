package negative_absolute;

public class Solution {

    private static int thinkPositive(int i) {
        if (i == Integer.MIN_VALUE) {
            i++;
            return Math.abs(i);
        }
        return Math.abs(i);
        // This doesn't always return a *positive* number.
        /* Yes, we know changing this to `return 1;` will pass all the tests.
         * While cute that isn't quite what we're looking for. See the javadoc
         * our reasoning.
         * */
    }

    public static void main(String[] args) {
        Integer min = Integer.MIN_VALUE;
        int result = thinkPositive(min);
        System.out.println(result);
    }
}
