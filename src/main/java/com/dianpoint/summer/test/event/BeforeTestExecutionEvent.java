package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class BeforeTestExecutionEvent extends TestContextEvent{

    public BeforeTestExecutionEvent(Object source) {
        super(source);
    }
}
