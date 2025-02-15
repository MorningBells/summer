/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dianpoint.summer.test.event.listener;

import com.dianpoint.summer.test.event.TestContext;

/**
 * @author wangyi
 * @date 2023/4/8
 */
public abstract class AbstractTestExecutionListener implements TestExecutionListener {

	@Override
	public void beforeTestClass(final TestContext testContext) throws Exception {
	}

	@Override
	public void prepareTestInstance(final TestContext testContext) throws Exception {
	}

	@Override
	public void beforeTestMethod(final TestContext testContext) throws Exception {
	}

	@Override
	public void beforeTestExecution(final TestContext testContext) throws Exception {
	}

	@Override
	public void afterTestExecution(final TestContext testContext) throws Exception {
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
	}

	@Override
	public void afterTestClass(final TestContext testContext) throws Exception {
	}

}
