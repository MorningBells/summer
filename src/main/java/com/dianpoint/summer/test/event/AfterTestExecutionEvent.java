package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class AfterTestExecutionEvent extends TestContextEvent{

    public AfterTestExecutionEvent(Object source) {
        super(source);
    }
}
