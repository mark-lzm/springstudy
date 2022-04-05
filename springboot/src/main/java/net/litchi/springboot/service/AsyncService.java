package net.litchi.springboot.service;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 17:11
 */
public interface AsyncService {
    public Future<Boolean> task1() throws InterruptedException;
    public Future<Boolean> task2() throws InterruptedException;
    public Future<Boolean> task3() throws InterruptedException;
}
