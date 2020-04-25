package com.anmol.service;

import java.util.*;

/**
 *There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    /**
     * the idea is to take this as a directed graph and for each vertex with incoming edge,
     * we want to remove all the edges so that the course can be done.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] required = new int[numCourses];
        int count = 0;
        // get all the courses who have a pre-requisite with their count.
        for(int i = 0; i< prerequisites.length;i++) {
            required[prerequisites[i][0]]++;
        }
        // we can use a queue as well
        Stack<Integer> stack = new Stack<>();
        Set<Integer> linkedList = new LinkedHashSet<>();
        for(int i = 0; i<required.length;i++) {
            if(required[i] == 0) {
                stack.push(i);      // add all the courses which do not have a prerequisite.
            }
        }
        while (!stack.empty()) {
            int currentCourse = stack.pop();
            count++;
            linkedList.add(currentCourse);

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == currentCourse) {
                    required[prerequisite[0]]--;    // we finished the course with no pre-requisite
                    if (required[prerequisite[0]] == 0) {   // finish the course whose prerequisites are done
                        stack.push(prerequisite[0]);    // now it can be used by other course.
                        linkedList.add(prerequisite[0]);
                    }
                }
            }
        }
        for(Integer val : linkedList) {
            System.out.println(val);
        }

        // if solution is possible then return the result stored in the set, else empty array
        int[] ints = linkedList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {
                {1,0},
                {2,1},
                {1,3}
        };
        CourseSchedule schedule = new CourseSchedule();
        System.out.println(schedule.canFinish(4, prerequisites));
    }
}
