package com.bmx.dubbo.provider.service;

import util.IdWorker;

public class Test {

    /**
     * id生成工具测试
     */
    @org.junit.Test
    public void add() {
        IdWorker idWorker = new IdWorker();
        Long id = idWorker.nextId();
        System.out.println("id = " + id);
    }
}
