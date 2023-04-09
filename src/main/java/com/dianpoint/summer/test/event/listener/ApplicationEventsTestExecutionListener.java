/*
 * Copyright 2002-2020 the original author or authors.
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

import com.dianpoint.summer.context.AbstractApplicationContext;
import com.dianpoint.summer.context.ApplicationContext;
import com.dianpoint.summer.test.event.ApplicationEventsHolder;
import com.dianpoint.summer.test.event.DefaultApplicationEvents;
import com.dianpoint.summer.test.event.TestContext;
import com.dianpoint.summer.test.event.annotation.RecordApplicationEvents;

import java.io.Serializable;

public class ApplicationEventsTestExecutionListener extends AbstractTestExecutionListener {

	private static final String RECORD_APPLICATION_EVENTS = "com.dianpoint.summer.test.event.listener.ApplicationEventsTestExecutionListener.recordApplicationEvents";

	private static final Object applicationEventsMonitor = new Object();


	public final int getOrder() {
		return 1800;
	}

	@Override
	public void prepareTestInstance(final TestContext testContext) throws Exception {
		if (this.recordApplicationEvents(testContext)) {
			this.registerListenerAndResolvableDependencyIfNecessary(testContext.getApplicationContext());
			ApplicationEventsHolder.registerApplicationEvents();
		}
	}

	@Override
	public void beforeTestMethod(final TestContext testContext) throws Exception {
		if (this.recordApplicationEvents(testContext)) {
			ApplicationEventsHolder.registerApplicationEventsIfNecessary();
		}
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
		if (this.recordApplicationEvents(testContext)) {
			ApplicationEventsHolder.unregisterApplicationEvents();
		}
	}

	private boolean recordApplicationEvents(final TestContext testContext) {
		// TODO: 2023/4/8 写一个判断是否存在注解的工具类
//		return testContext.computeAttribute(RECORD_APPLICATION_EVENTS, name ->
//				TestContextAnnotationUtils.hasAnnotation(testContext.getTestClass(), RecordApplicationEvents.class));
		return false;
	}

	private void registerListenerAndResolvableDependencyIfNecessary(final ApplicationContext applicationContext) {
		final AbstractApplicationContext aac = (AbstractApplicationContext) applicationContext;
		// Synchronize to avoid race condition in parallel test execution
//		synchronized(applicationEventsMonitor) {
//			boolean notAlreadyRegistered = aac.getApplicationListeners().stream()
//					.map(Object::getClass)
//					.noneMatch(ApplicationEventsApplicationListener.class::equals);
//			if (notAlreadyRegistered) {
//				// Register a new ApplicationEventsApplicationListener.
//				aac.addApplicationListener(new ApplicationEventsApplicationListener());
//
//				// Register ApplicationEvents as a resolvable dependency for @Autowired support in test classes.
//				ConfigurableListableBeanFactory beanFactory = aac.getBeanFactory();
//				beanFactory.registerResolvableDependency(ApplicationEvents.class, new ApplicationEventsObjectFactory());
//			}
//		}
	}

	@SuppressWarnings("serial")
	private static class ApplicationEventsObjectFactory implements Serializable {

		public DefaultApplicationEvents getObject() {
			return ApplicationEventsHolder.getRequiredApplicationEvents();
		}

		@Override
		public String toString() {
			return "Current ApplicationEvents";
		}
	}

}
