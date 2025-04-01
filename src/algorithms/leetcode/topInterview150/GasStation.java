package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class GasStation {

    /*
    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

    You have a car with an unlimited gas tank and
    it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
    You begin the journey with an empty tank at one of the gas stations.

    Given two integer arrays gas and cost,
    return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
    otherwise return -1. If there exists a solution, it is guaranteed to be unique.
     */

    public static void main(String[] args) {
        int[] gas = {2, 3, 4}, cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) {
            return -1;
        }
        int sum = 0 ;
        for(int i = 0 ; i < gas.length ; i++){
            sum += gas[i]-cost[i];
        }
        if(sum<0){
            return -1;
        }

        int resultIdx = 0 ;
        int delta = 0 ;
        for(int i = 0 ; i<gas.length ;i++){
            delta += gas[i]-cost[i];
            if(delta < 0 ){
                delta = 0 ;
                resultIdx = i + 1;
            }
        }
        return resultIdx;
    }
}
