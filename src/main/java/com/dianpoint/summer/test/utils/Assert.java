package com.dianpoint.summer.test.utils;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Supplier;

public abstract class Assert {

	public static void state(final boolean expression, final String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	public static void state(final boolean expression, final Supplier<String> messageSupplier) {
		if (!expression) {
			throw new IllegalStateException(nullSafeGet(messageSupplier));
		}
	}


	public static void state(final boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}


	public static void isTrue(final boolean expression, final String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}


	public static void isTrue(final boolean expression, final Supplier<String> messageSupplier) {
		if (!expression) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}


	public static void isTrue(final boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}


	public static void isNull(final Object object, final String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}


	public static void isNull(@Nullable final Object object, final Supplier<String> messageSupplier) {
		if (object != null) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void isNull(@Nullable final Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}


	public static void notNull(@Nullable final Object object, final String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}


	public static void notNull(@Nullable final Object object, final Supplier<String> messageSupplier) {
		if (object == null) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}


	public static void notNull(@Nullable final Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}


	public static void noNullElements(@Nullable final Object[] array, final String message) {
		if (array != null) {
			for (final Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}


	public static void noNullElements(@Nullable final Object[] array, final Supplier<String> messageSupplier) {
		if (array != null) {
			for (final Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(nullSafeGet(messageSupplier));
				}
			}
		}
	}

	public static void noNullElements(@Nullable final Object[] array) {
		noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}


	public static void noNullElements(@Nullable final Collection<?> collection, final String message) {
		if (collection != null) {
			for (final Object element : collection) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	public static void noNullElements(@Nullable final Collection<?> collection, final Supplier<String> messageSupplier) {
		if (collection != null) {
			for (final Object element : collection) {
				if (element == null) {
					throw new IllegalArgumentException(nullSafeGet(messageSupplier));
				}
			}
		}
	}


	private static boolean endsWithSeparator(final String msg) {
		return (msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith("."));
	}

	private static String messageWithTypeName(final String msg, @Nullable final Object typeName) {
		return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
	}

	@Nullable
	private static String nullSafeGet(@Nullable final Supplier<String> messageSupplier) {
		return (messageSupplier != null ? messageSupplier.get() : null);
	}

}
