package util;

import java.util.List;

public class MathUtil {
    public static float getAverageOfList(List<Integer> items) {
        int sum = 0;

        for (int i : items) {
            sum += i;
        }

        return (float) sum / items.size();
    }
}
