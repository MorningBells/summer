/*
 * Copyright 2002-2022 the original author or authors.
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

package com.dianpoint.summer.test.event;

import com.dianpoint.summer.test.event.annotation.*;
import org.junit.Test;
import org.junit.platform.testkit.engine.EngineTestKit;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

/**
 */
class DirtiesContextEventPublishingTests {

	private static final List<Class<? extends TestContextEvent>> events = new ArrayList<>();


//	@BeforeEach
//	@AfterEach
	void resetEvents() {
		events.clear();
	}

	@Test
	void classLevelDirtiesContext() {
		EngineTestKit.engine("junit-jupiter")//
				.selectors(selectClass(ClassLevelDirtiesContextTestCase.class))//
				.execute()//
				.testEvents()//
				.assertStatistics(stats -> stats.started(1).succeeded(1).failed(0));

		assertThat(events).containsExactly(//
			// BeforeTestClassEvent.class -- always missing for 1st test class by default
			PrepareTestInstanceEvent.class, //
			BeforeTestMethodEvent.class, //
			BeforeTestExecutionEvent.class, //
			AfterTestExecutionEvent.class, //
			AfterTestMethodEvent.class, //
			AfterTestClassEvent.class //
		);
	}

	@Test
	void methodLevelAfterMethodDirtiesContext() {
		EngineTestKit.engine("junit-jupiter")//
				.selectors(selectClass(MethodLevelAfterMethodDirtiesContextTestCase.class))//
				.execute()//
				.testEvents()//
				.assertStatistics(stats -> stats.started(1).succeeded(1).failed(0));

		assertThat(events).containsExactly(//
			// BeforeTestClassEvent.class -- always missing for 1st test class by default
			PrepareTestInstanceEvent.class, //
			BeforeTestMethodEvent.class, //
			BeforeTestExecutionEvent.class, //
			AfterTestExecutionEvent.class, //
			AfterTestMethodEvent.class //
			// AfterTestClassEvent.class -- missing b/c of @DirtiestContext "after method" at the method level
		);
	}

	@Test
	void methodLevelAfterMethodDirtiesContextWithSubsequentTestMethod() {
		EngineTestKit.engine("junit-jupiter")//
				.selectors(selectClass(MethodLevelAfterMethodDirtiesContextWithSubsequentTestMethodTestCase.class))//
				.execute()//
				.testEvents()//
				.assertStatistics(stats -> stats.started(2).succeeded(2).failed(0));

		assertThat(events).containsExactly(//
			// BeforeTestClassEvent.class -- always missing for 1st test class by default
			// test1()
			PrepareTestInstanceEvent.class, //
			BeforeTestMethodEvent.class, //
			BeforeTestExecutionEvent.class, //
			AfterTestExecutionEvent.class, //
			AfterTestMethodEvent.class, //
			// test2()
			PrepareTestInstanceEvent.class, //
			BeforeTestMethodEvent.class, //
			BeforeTestExecutionEvent.class, //
			AfterTestExecutionEvent.class, //
			AfterTestMethodEvent.class, //
			AfterTestClassEvent.class // b/c @DirtiestContext is not applied for test2()
		);
	}

	@Test
	void methodLevelBeforeMethodDirtiesContext() {
		EngineTestKit.engine("junit-jupiter")//
				.selectors(selectClass(MethodLevelBeforeMethodDirtiesContextTestCase.class))//
				.execute()//
				.testEvents()//
				.assertStatistics(stats -> stats.started(1).succeeded(1).failed(0));

		assertThat(events).containsExactly(//
			// BeforeTestClassEvent.class -- always missing for 1st test class by default
			PrepareTestInstanceEvent.class, //
			BeforeTestMethodEvent.class, //
			BeforeTestExecutionEvent.class, //
			AfterTestExecutionEvent.class, //
			AfterTestMethodEvent.class, //
			AfterTestClassEvent.class // b/c @DirtiestContext happens "before method" at the method level
		);
	}
//
//	@SpringJUnitConfig(Config.class)
//	// add unique property to get a unique ApplicationContext
//	@TestPropertySource(properties = "DirtiesContextEventPublishingTests.key = class-level")
//	@DirtiesContext
	static class ClassLevelDirtiesContextTestCase {

		@Test
		void test() {
		}
	}
//
//	@SpringJUnitConfig(Config.class)
//	// add unique property to get a unique ApplicationContext
//	@TestPropertySource(properties = "DirtiesContextEventPublishingTests.key = method-level-after-method")
	static class MethodLevelAfterMethodDirtiesContextTestCase {

		@Test
//		@DirtiesContext
		void test1() {
		}
	}
//
//	@SpringJUnitConfig(Config.class)
//	// add unique property to get a unique ApplicationContext
//	@TestPropertySource(properties = "DirtiesContextEventPublishingTests.key = method-level-after-method-with-subsequent-test-method")
//	@TestMethodOrder(DisplayName.class)
	static class MethodLevelAfterMethodDirtiesContextWithSubsequentTestMethodTestCase {

		@Test
//		@DirtiesContext
		void test1() {
		}

		@Test
		void test2() {
		}
	}
//
//	@SpringJUnitConfig(Config.class)
//	// add unique property to get a unique ApplicationContext
//	@TestPropertySource(properties = "DirtiesContextEventPublishingTests.key = method-level-before-method")
	static class MethodLevelBeforeMethodDirtiesContextTestCase {

		@Test
//		@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
		void test() {
		}
	}
//
//	@Configuration
//	static class Config {
//
//		@BeforeTestClass
//		public void beforeTestClass(BeforeTestClassEvent e) {
//			events.add(e.getClass());
//		}
//
//		@PrepareTestInstance
//		public void prepareTestInstance(PrepareTestInstanceEvent e) {
//			events.add(e.getClass());
//		}
//
//		@BeforeTestMethod
//		public void beforeTestMethod(BeforeTestMethodEvent e) {
//			events.add(e.getClass());
//		}
//
//		@BeforeTestExecution
//		public void beforeTestExecution(BeforeTestExecutionEvent e) {
//			events.add(e.getClass());
//		}
//
//		@AfterTestExecution
//		public void afterTestExecution(AfterTestExecutionEvent e) {
//			events.add(e.getClass());
//		}
//
//		@AfterTestMethod
//		public void afterTestMethod(AfterTestMethodEvent e) {
//			events.add(e.getClass());
//		}
//
//		@AfterTestClass
//		public void afterTestClass(AfterTestClassEvent e) {
//			events.add(e.getClass());
//		}
//
//	}

}
