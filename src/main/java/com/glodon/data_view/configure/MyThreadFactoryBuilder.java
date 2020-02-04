package com.glodon.data_view.configure;

/**
 * @author liuwg-a
 * @date 2019/8/28 14:48
 * @description
 */
public class MyThreadFactoryBuilder {

    String namePrefix;

    public MyThreadFactoryBuilder namePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
        return this;
    }

    public MyThreadFactory build() {
        return new MyThreadFactory(this);
    }
}
