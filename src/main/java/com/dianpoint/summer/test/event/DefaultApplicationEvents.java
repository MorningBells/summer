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

import com.dianpoint.summer.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wangyi
 * @date 2023/4/8
 */
public class DefaultApplicationEvents {

	private final List<ApplicationEvent> events = new ArrayList<>();


	public void addEvent(ApplicationEvent event) {
		this.events.add(event);
	}

	public Stream<ApplicationEvent> stream() {
		return this.events.stream();
	}

	public <T> Stream<T> stream(Class<T> type) {
		return this.events.stream()
				.filter(type::isInstance)
				.map(type::cast);
	}

	public void clear() {
		this.events.clear();
	}


}
