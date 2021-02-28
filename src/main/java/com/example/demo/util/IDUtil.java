package com.example.demo.util;

public class IDUtil {
    /**
     * 随机id生成，使用雪花算法
     * @return
     */
    public static String getRandomId() {
        SnowflakeIdWorker sf = new SnowflakeIdWorker();
        long id = sf.nextId();
        String ids = id + "";
        return ids;
    }
}