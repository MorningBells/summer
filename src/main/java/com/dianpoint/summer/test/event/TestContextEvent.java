package com.dianpoint.summer.test.event;

import com.dianpoint.summer.context.ApplicationEvent;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public abstract class TestContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TestContextEvent(Object source) {
        super(source);
    }


    @Override
    public final TestContext getSource() {
        return (TestContext) super.getSource();
    }

}
