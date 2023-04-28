package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class AfterTestMethodEvent extends TestContextEvent{


    public AfterTestMethodEvent(Object source) {
        super(source);
    }
}
