package com.dianpoint.summer.test.event;


import com.dianpoint.summer.beans.BeansException;
import com.dianpoint.summer.beans.factory.config.BeanFactoryPostProcessor;
import com.dianpoint.summer.beans.factory.config.BeanPostProcessor;
import com.dianpoint.summer.beans.factory.config.ConfigurableListableBeanFactory;
import com.dianpoint.summer.context.ApplicationContext;
import com.dianpoint.summer.context.ApplicationEvent;
import com.dianpoint.summer.context.ApplicationListener;
import com.dianpoint.summer.core.env.Environment;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author wangyi
 * @date 2023/4/5
 */
public class TestContext {

    private final Map<String, Object> attributes = new ConcurrentHashMap<>(4);

    private final Class<?> testClass;

    private volatile Object testInstance;

    private volatile Method testMethod;

    private volatile Throwable testException;

    public TestContext(final Class<?> testClass) {
        this.testClass = testClass;
    }


    public final Class<?> getTestClass() {
        return this.testClass;
    }

    public final Object getTestInstance() {
        Object testInstance = this.testInstance;
        if (testInstance == null){
            throw new RuntimeException("No test instance");
        }
        return testInstance;
    }

    public final Method getTestMethod() {
        Method testMethod = this.testMethod;
        if (testMethod == null){
            throw new RuntimeException("No test method");
        }
        return testMethod;
    }

    public final Throwable getTestException() {
        return this.testException;
    }

    public void updateState(Object testInstance, Method testMethod, Throwable testException) {
        this.testInstance = testInstance;
        this.testMethod = testMethod;
        this.testException = testException;
    }

    public void setAttribute(String name, Object value) {
        if (name==null){
            throw new RuntimeException("Name must not be null");
        }
        synchronized (this.attributes) {
            if (value != null) {
                this.attributes.put(name, value);
            }
            else {
                this.attributes.remove(name);
            }
        }
    }

    public Object getAttribute(String name) {
        if (name==null){
            throw new RuntimeException("Name must not be null");
        }
        return this.attributes.get(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T computeAttribute(String name, Function<String, T> computeFunction) {
        if (name==null){
            throw new RuntimeException("Name must not be null");
        }
        if (computeFunction==null){
            throw new RuntimeException("Compute function must not be null");
        }
        Object value = this.attributes.computeIfAbsent(name, computeFunction);
        if (value==null){
            throw new RuntimeException(String.format("Compute function must not return null for attribute named '%s'",name));

        }
        return (T) value;
    }

    public Object removeAttribute(String name) {
        if (name==null){
            throw new RuntimeException("Name must not be null");
        }
        return this.attributes.remove(name);
    }

    public boolean hasAttribute(String name) {
        if (name==null){
            throw new RuntimeException("Name must not be null");
        }
        return this.attributes.containsKey(name);
    }


    public void publishEvent(Function<TestContext, ? extends ApplicationEvent> eventFactory) {
        // TODO: 2023/4/5 获取上下文 ApplicationContext
//        getApplicationContext().publishEvent(eventFactory.apply(this));
    }


    public ApplicationContext getApplicationContext() {
        ApplicationContext context = new ApplicationContext() {
            @Override
            public String getApplicationName() {
                return null;
            }

            @Override
            public long getStartupDate() {
                return 0;
            }

            @Override
            public ConfigurableListableBeanFactory getBeanFactory() {
                return null;
            }

            @Override
            public void setEnvironment(Environment environment) {

            }

            @Override
            public Environment getEnvironment() {
                return null;
            }

            @Override
            public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor beanFactoryPostProcessor) {

            }

            @Override
            public void refresh() throws BeansException {

            }

            @Override
            public void close() {

            }

            @Override
            public boolean isActive() {
                return false;
            }

            @Override
            public boolean containsBeanDefinition(String beanName) {
                return false;
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> type) {
                return new String[0];
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
                return null;
            }

            @Override
            public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

            }

            @Override
            public int getBeanPostProcessorCount() {
                return 0;
            }

            @Override
            public void registerDependentBean(String beanName, String dependentBeanName) {

            }

            @Override
            public String[] getDependentBeans(String beanName) {
                return new String[0];
            }

            @Override
            public String[] getDependenciesForBean(String beanName) {
                return new String[0];
            }

            @Override
            public Object getBean(String beanName) throws BeansException {
                return null;
            }

            @Override
            public boolean containsBean(String name) {
                return false;
            }

            @Override
            public void registerBean(String beanName, Object object) {

            }

            @Override
            public boolean isSingleton(String name) {
                return false;
            }

            @Override
            public boolean isPrototype(String name) {
                return false;
            }

            @Override
            public Class<?> getType(String name) {
                return null;
            }

            @Override
            public void registerSingleton(String beanName, Object singletonObject) {

            }

            @Override
            public Object getSingleton(String beanName) {
                return null;
            }

            @Override
            public boolean containsSingleton(String beanName) {
                return false;
            }

            @Override
            public String[] getSingletonNames() {
                return new String[0];
            }

            @Override
            public void publisher(ApplicationEvent event) {

            }

            @Override
            public void addApplicationListener(ApplicationListener listener) {

            }
        };
        return context;
    }

}
