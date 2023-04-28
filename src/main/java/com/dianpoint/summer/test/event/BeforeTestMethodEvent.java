package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class BeforeTestMethodEvent extends TestContextEvent{

    public BeforeTestMethodEvent(Object source) {
        super(source);
    }
}
