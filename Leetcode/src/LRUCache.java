package com.anmol.service;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    CacheNode start;
    CacheNode end;
    Map<Integer, CacheNode> cacheNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheNodeMap = new HashMap<>();
    }

    public int get(int key) {
        if(cacheNodeMap.get(key) == null) {
            return -1;
        }
        CacheNode node = cacheNodeMap.get(key);
        removeNode(node);
        addNodeAtStart(node);
        return node.val;
    }

    public void put(int key, int value) {
        CacheNode node = cacheNodeMap.get(key);
        if (node != null) {
            node.val = value;
            removeNode(node);
        } else {
            if (cacheNodeMap.size() == capacity) {
                cacheNodeMap.remove(end.key);
                removeNode(end);
                node = new CacheNode(value, key);
                cacheNodeMap.put(key, node);
            } else {
                node = new CacheNode(value, key);
                cacheNodeMap.put(key, node);
            }

        }
        addNodeAtStart(node);

    }

    private void addNodeAtStart(CacheNode node) {
        if(start == null) {
            start = node;
            end = node;
        } else {
            node.next = start;
            start.prev = node;
            start = node;
        }
    }

    private void removeNode(CacheNode node) {
        if(node.prev==null) {
            start = node.next;
        } else if(node.next == null) {
            end = node.prev;
            end.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

    static class CacheNode {
        int val;
        CacheNode next;
        CacheNode prev;
        int key;

        CacheNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
//        cache.put(1,1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
