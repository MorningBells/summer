package com.dianpoint.summer.test.event.listener;

import com.dianpoint.summer.test.event.*;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class EventPublishingTestExecutionListener implements TestExecutionListener{


    public void beforeTestClass(TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestClassEvent::new);
    }

    public void prepareTestInstance(TestContext testContext) throws Exception {
        testContext.publishEvent(PrepareTestInstanceEvent::new);
    }

    public void beforeTestMethod(TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestMethodEvent::new);
    }

    public void beforeTestExecution(TestContext testContext) throws Exception {
        testContext.publishEvent(BeforeTestExecutionEvent::new);
    }

    public void afterTestExecution(TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestExecutionEvent::new);
    }

    public void afterTestMethod(TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestMethodEvent::new);
    }

    public void afterTestClass(TestContext testContext) throws Exception {
        testContext.publishEvent(AfterTestClassEvent::new);
    }

}
