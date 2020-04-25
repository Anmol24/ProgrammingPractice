package com.anmol.service;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues st = new StackUsingQueues();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
    }

}

