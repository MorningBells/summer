package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class AfterTestClassEvent extends TestContextEvent{


    public AfterTestClassEvent(Object source) {
        super(source);
    }
}
