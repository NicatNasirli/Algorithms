package algorithms.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class CalculateBarrierEnergy {
    /*
    You are given an array initialEnergy of size n, where each element represents the starting energy
    of a particle in space. The energy of a particle is reduced by a value called the barrier.
    If the energy becomes less than zero, it is set to zero.

    Your task is to find the maximum possible value of the barrier such that the total of
    all finalEnergy values is greater than or equal to a given threshold th.
     */

    public static void main(String[] args) {
        List<Integer> initialEnergy = new ArrayList<>(List.of(5, 2, 13, 10));
        System.out.println(getMaxBarrier(initialEnergy, 8));
    }

    public static int getMaxBarrier(List<Integer> initialEnergy, long th) {
        long sum = 0;
        long sumDecrement = 0;
        int result = 0;
        for (int i : initialEnergy) {
            sum += i;
        }

        while (true) {
            for (int i: initialEnergy) {
                if (i - result > 0) sumDecrement++;
            }
            sum -= sumDecrement;
            sumDecrement = 0;
            if (sum < th) return result ;
            result++;
        }

    }
}
