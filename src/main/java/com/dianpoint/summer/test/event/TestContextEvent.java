package com.dianpoint.summer.test.event;

import com.dianpoint.summer.context.ApplicationEvent;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public abstract class TestContextEvent extends ApplicationEvent {

    public TestContextEvent(Object source) {
        super(source);
    }


    @Override
    public final TestContext getSource() {
        return (TestContext) super.getSource();
    }

}
