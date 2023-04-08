/*
 * Copyright 2002-2021 the original author or authors.
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


public abstract class ApplicationEventsHolder {

	private static final ThreadLocal<DefaultApplicationEvents> applicationEvents = new ThreadLocal<>();


	private ApplicationEventsHolder() {
	}


	public static DefaultApplicationEvents getApplicationEvents() {
		return applicationEvents.get();
	}

	public static DefaultApplicationEvents getRequiredApplicationEvents() {
		DefaultApplicationEvents events = applicationEvents.get();
		if (events==null){
			throw new RuntimeException("DefaultApplicationEvents 不能为空");
		}
		return events;
	}


	public static void registerApplicationEventsIfNecessary() {
		if (getApplicationEvents() == null) {
			registerApplicationEvents();
		}
	}

	public static void registerApplicationEvents() {
		applicationEvents.set(new DefaultApplicationEvents());
	}

	public static void unregisterApplicationEvents() {
		applicationEvents.remove();
	}

}
