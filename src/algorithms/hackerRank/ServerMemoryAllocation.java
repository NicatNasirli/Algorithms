package algorithms.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class ServerMemoryAllocation {

    /*
     Given n programs and n-1 servers, each program must run on its own server,
     and each server can only handle one program. Every program has a memory requirement given by the array memoryRequirement.
     Every server has a fixed memory capacity, given by the array memoryAvailable.
     Since there is one extra program, a new server must be added.

     Implement a function to determine the smallest memory capacity required for the new server to
    ensure that all programs can be executed.
    The function getMinMemory takes the following inputs:
    int memoryRequirement[n]: the memory
    requirements of the programs
    int memoryAvailable[n-1]: the memory capacities
    of the existing servers
    The function should return the minimum memory size required for the new server or -1 if allocation is impossible.
     */

    public static void main(String[] args) {
        List<Integer> memoryRequirement = new ArrayList<>(List.of(5, 2, 3, 7));
        List<Integer> memoryAvailable = new ArrayList<>(List.of(6, 2, 8));
        System.out.println(getMinMemory(memoryRequirement, memoryAvailable));
    }

    public static int getMinMemory(List<Integer> memoryRequirement, List<Integer> memoryAvailable) {
        memoryRequirement.sort(Integer::compareTo);
        memoryAvailable.add(0);
        memoryAvailable.sort(Integer::compareTo);
        int size = memoryRequirement.size();
        int result = -2, skip = 0;
        int availableIndex = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (memoryRequirement.get(i) > memoryAvailable.get(availableIndex)) {
                if (skip < 1) {
                    result = memoryRequirement.get(i);
                    skip++;
                } else return -1;
            } else availableIndex--;
        }

        return Math.max(result, -1);
    }
}


