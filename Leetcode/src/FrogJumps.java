package com.anmol.service;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FrogJumps {

    public boolean canCross(int[] stones) {

        for(int i = 3;i<stones.length;i++) {
            if(stones[i] > stones[i-1]*2){
                return false;
            }
        }

        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.push(0);
        jumps.push(0);
        Set<Integer> stonePositions = new HashSet<>();
        for(int stone: stones) {
            stonePositions.add(stone);
        }

        /**
         * for each iteration, save the current position and the number of jumps taken
         * to reach the stone. because each position can be reached by either taking k-1, k or k+1 jumps.
         * initially k will 0 and the stone would be 0 i.e. the starting index.
         *
         * we are doing a bfs for each position and jump in the stone.
         * we try for k-1, k or k+1 jump. if at any time we reach the last index we return true;
         * for each jump we make from a stone we need to see if we can land on another given stone
         */
        while(!positions.empty()) {
            int position = positions.pop();
            int jump = jumps.pop();
            for(int i = jump-1; i <=jump+1;i++) {
                if(i <=0 ){
                    continue;
                }
                int next_position = position + i;
                if(next_position == stones[stones.length-1]) {
                    return true;
                }
                if(stonePositions.contains(next_position)) {
                    positions.push(next_position);
                    jumps.push(i);
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        FrogJumps frogJumps = new FrogJumps();
        System.out.println(frogJumps.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
