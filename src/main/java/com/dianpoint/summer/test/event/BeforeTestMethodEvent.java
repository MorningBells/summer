package com.dianpoint.summer.test.event;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class BeforeTestMethodEvent extends TestContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public BeforeTestMethodEvent(Object source) {
        super(source);
    }
}
