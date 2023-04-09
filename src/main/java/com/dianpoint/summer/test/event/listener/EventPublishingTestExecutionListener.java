package com.dianpoint.summer.test.event.listener;

import com.dianpoint.summer.test.event.*;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class EventPublishingTestExecutionListener implements TestExecutionListener{


    public void beforeTestClass(final TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestClassEvent::new);
    }

    public void prepareTestInstance(final TestContext testContext) throws Exception {
        testContext.publishEvent(PrepareTestInstanceEvent::new);
    }

    public void beforeTestMethod(final TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestMethodEvent::new);
    }

    public void beforeTestExecution(final TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestExecutionEvent::new);
    }

    public void afterTestExecution(final TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestExecutionEvent::new);
    }

    public void afterTestMethod(final TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestMethodEvent::new);
    }

    public void afterTestClass(final TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestClassEvent::new);
    }

}
