package com.glodon.data_view.configure;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuwg-a
 * @date 2019/8/23 9:28
 * @description
 */
public class MyThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_NUMBER  = new AtomicInteger(1);
    private final ThreadGroup          group;
    private final AtomicInteger        threadNumber = new AtomicInteger(1);
    private final String               namePrefix;

    MyThreadFactory(MyThreadFactoryBuilder builder) {
        SecurityManager s = System.getSecurityManager();
        group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        String threadPoolNamePrefix = (builder == null
                                       || StringUtils.isEmpty(builder.namePrefix)) ? "data-view" : builder.namePrefix;
        namePrefix = threadPoolNamePrefix + "-thread-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
