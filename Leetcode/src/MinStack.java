package com.anmol.service;

class MinStack {

    static class MyStack {
        int min;
        int val;
        MyStack next;

        MyStack(int min, int val) {
            this.min = min;
            this.val = val;
        }
    }



    MyStack top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top == null) {
            top = new MyStack(x, x);
        } else {
            MyStack temp = new MyStack(Math.min(x, top.min), x);
            temp.next = top;
            top = temp;
        }
    }

    public void pop() {
        if(top!=null) {
            MyStack temp = top.next;
            top.next = null;
            top = temp;
        }
    }

    public int top() {
        if(top == null){
            return -1;
        }
        return top.val;
    }

    public int getMin() {
        if(top == null){
            return -1;
        }
        return top.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */