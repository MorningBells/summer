package com.dianpoint.summer.test.utils;

public interface Advised {

	boolean isFrozen();

	boolean isProxyTargetClass();

	Class<?>[] getProxiedInterfaces();

	boolean isInterfaceProxied(Class<?> intf);

	void setExposeProxy(boolean exposeProxy);

	boolean isExposeProxy();

	void setPreFiltered(boolean preFiltered);

	boolean isPreFiltered();


	String toProxyConfigString();

}
