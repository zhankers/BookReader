package com.ebook.test.lru;

import java.time.Instant;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-31 12:38
 */
public class LRU {

    private ScheduledExecutorService swapExpiredPoll;

    private Map<String, Node> cache;

    private PriorityQueue<Node> expireQueue;


    private LRU() {
        cache = new ConcurrentHashMap<>(1024);
        expireQueue = new PriorityQueue<>(1024);
        swapExpiredPoll = new ScheduledThreadPoolExecutor(10);
        swapExpiredPoll.scheduleWithFixedDelay(new ExpiredNodeRunnable(), 3, 3, TimeUnit.SECONDS);
    }

    public static LRU getInstance() {
        return new LRU();
    }


    public Object get(String key) {
        Node node = cache.get(key);
        return node == null ? null : node.getData();
    }

    public Object set(String key, Object data, long ttl) {
        long expiredTime = Instant.now().toEpochMilli() + ttl;
        Node newNode = new Node(key, data, expiredTime);

        Node oldNode = cache.get(key);

        expireQueue.add(newNode);

        if (oldNode != null) {
            expireQueue.remove(oldNode);
            return oldNode.getData();
        }

        return null;
    }

    class ExpiredNodeRunnable implements Runnable{

        @Override
        public void run() {
            long currentTime = Instant.now().toEpochMilli();
            while (true) {


                Node top = expireQueue.peek();

                if (isNull(top) || top.getExpireTime() > currentTime) {
                    return;
                }

                cache.remove(top.getKey());
                expireQueue.poll();
            }
        }
    }

}

class Node implements Comparable<Node>{

    private String key;
    private Object data;
    private Long expireTime;

    public Node(String key, Object data, Long expireTime) {
        this.key = key;
        this.data = data;
        this.expireTime = expireTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public int compareTo(Node that) {

        if (this.expireTime > that.getExpireTime()) {
            return 1;
        }

        if (this.expireTime < that.getExpireTime()) {
            return -1;
        }
        return 0;
    }
}