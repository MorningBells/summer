package com.dianpoint.summer.test.utils;


import java.lang.reflect.Proxy;

/**
 * 与AOP相关的实用方法的集合。
 * 可以使用这些方法获取Spring代理后面的底层目标对象的引用。
 * 例如，EasyMock或Mockito将bean配置为动态mock，并且mock包装在Spring代理中，可以直接访问底层mock以配置对它的期望并执行验证
 */
public abstract class AopTestUtils {

	/** The CGLIB class separator: {@code "$$"}. */
	public static final String CGLIB_CLASS_SEPARATOR = "$$";


	public static <T> T getTargetObject(Object candidate) {
		Assert.notNull(candidate, "Candidate must not be null");
		try {
//			if (isAopProxy(candidate) && candidate instanceof Advised advised) {
//				Object target = advised.getTargetSource().getTarget();
//				if (target != null) {
//					return (T) target;
//				}
//			}
		}
		catch (Throwable ex) {
			throw new IllegalStateException("Failed to unwrap proxied object", ex);
		}
		return (T) candidate;
	}


	public static <T> T getUltimateTargetObject(Object candidate) {
		Assert.notNull(candidate, "Candidate must not be null");
		try {
//			if (isAopProxy(candidate) && candidate instanceof Advised advised) {
//				Object target = advised.getTargetSource().getTarget();
//				if (target != null) {
//					return (T) getUltimateTargetObject(target);
//				}
//			}
		}
		catch (Throwable ex) {
			throw new IllegalStateException("Failed to unwrap proxied object", ex);
		}
		return (T) candidate;
	}


	public static boolean isAopProxy( Object object) {
		return (object instanceof SpringProxy && (Proxy.isProxyClass(object.getClass()) ||
				object.getClass().getName().contains(CGLIB_CLASS_SEPARATOR)));
	}

}
