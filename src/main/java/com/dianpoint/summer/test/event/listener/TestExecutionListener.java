package com.dianpoint.summer.test.event.listener;

import com.dianpoint.summer.test.event.TestContext;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public interface TestExecutionListener {

    default void beforeTestClass(TestContext testContext) throws Exception {
    }

    default void prepareTestInstance(TestContext testContext) throws Exception {
    }

    default void beforeTestMethod(TestContext testContext) throws Exception {
    }

    default void beforeTestExecution(TestContext testContext) throws Exception {
    }

    default void afterTestExecution(TestContext testContext) throws Exception {
    }

    default void afterTestMethod(TestContext testContext) throws Exception {
    }

    default void afterTestClass(TestContext testContext) throws Exception {
    }
}
