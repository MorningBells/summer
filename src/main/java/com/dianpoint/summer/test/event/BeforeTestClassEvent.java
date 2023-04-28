package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class BeforeTestClassEvent extends TestContextEvent{


    public BeforeTestClassEvent(Object source) {
        super(source);
    }
}
