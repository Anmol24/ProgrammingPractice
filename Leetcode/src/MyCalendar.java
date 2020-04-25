package com.anmol.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendar {
    List<Event> events;

    public MyCalendar() {
         events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (!events.isEmpty()) {
            for (Event event : events) {
                if (event.start < end && start < event.end) {
                    return false;
                }
            }
        }
        events.add(new Event(start, end));
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // returns true
        System.out.println(calendar.book(15, 25)); // returns false
        System.out.println(calendar.book(20, 30)); // returns true
        System.out.println(calendar.book(0, 5)); // returns true
        System.out.println(calendar.book(5, 7)); // returns true
        System.out.println(calendar.book(6, 9)); // returns true
        System.out.println(calendar.book(8, 9)); // returns true
        System.out.println(calendar.book(30, 34)); // returns true
        System.out.println(calendar.book(31, 32)); // returns true
    }

    static class Event implements Comparable<Event> {

        int start;
        int end;
        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event o) {
            return this.start - o.start;
        }
    }
}
