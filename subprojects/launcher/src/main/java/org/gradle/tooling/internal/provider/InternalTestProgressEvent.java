/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.tooling.internal.provider;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class InternalTestProgressEvent implements Serializable {

    private final String eventType;
    private final InternalTestDescriptor descriptor;
    private final InternalTestResult result;

    public InternalTestProgressEvent(String eventType, InternalTestDescriptor descriptor, InternalTestResult result) {
        this.eventType = eventType;
        this.descriptor = descriptor;
        this.result = result;
    }

    public String getEventType() {
        return eventType;
    }

    public InternalTestDescriptor getDescriptor() {
        return descriptor;
    }

    public InternalTestResult getResult() {
        return result;
    }

    public static class InternalTestDescriptor implements Serializable {

        private final Object id;
        private final String name;
        private final String className;
        private final Object parentId;

        public InternalTestDescriptor(Object id, String name, String className, Object parentId) {
            this.id = id;
            this.name = name;
            this.className = className;
            this.parentId = parentId;
        }

        public Object getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getClassName() {
            return className;
        }

        public Object getParentId() {
            return parentId;
        }

    }

    public static class InternalTestResult implements Serializable {

        private final long startTime;
        private final long endTime;
        private final List<Throwable> failures;

        public InternalTestResult(long startTime, long endTime, List<Throwable> failures) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.failures = failures == null ? Collections.<Throwable>emptyList() : failures;
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public List<Throwable> getFailures() {
            return failures;
        }

    }

}
