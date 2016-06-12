package cn.rongcapital.dps.tool.common;


public class ToolAssert {
	/**
	 * ToolAssert a boolean expression, throwing {@code IllegalArgumentException}
	 * if the test result is {@code false}.
	 * <pre class="code">ToolAssert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
	 * @param expression a boolean expression
	 * @param message the exception message to use if the ToolAssertion fails
	 * @throws IllegalArgumentException if expression is {@code false}
	 */
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * ToolAssert a boolean expression, throwing {@code IllegalArgumentException}
	 * if the test result is {@code false}.
	 * <pre class="code">ToolAssert.isTrue(i &gt; 0);</pre>
	 * @param expression a boolean expression
	 * @throws IllegalArgumentException if expression is {@code false}
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression, "[ToolAssertion failed] - this expression must be true");
	}

	/**
	 * ToolAssert that an object is {@code null} .
	 * <pre class="code">ToolAssert.isNull(value, "The value must be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the ToolAssertion fails
	 * @throws IllegalArgumentException if the object is not {@code null}
	 */
	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * ToolAssert that an object is {@code null} .
	 * <pre class="code">ToolAssert.isNull(value);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is not {@code null}
	 */
	public static void isNull(Object object) {
		isNull(object, "[ToolAssertion failed] - the object argument must be null");
	}

	/**
	 * ToolAssert that an object is not {@code null} .
	 * <pre class="code">ToolAssert.notNull(clazz, "The class must not be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the ToolAssertion fails
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
	/**
	 * <pre class="code">ToolAssert.notEmpty(clazz);</pre>
	 * string is not null or ""
	 * @param str
	 * @param message
	 */
	public static void notEmpty(String str, String message) {
		if (str == null || "".equals(str)) {
			throw new IllegalArgumentException(message);
		}
	}
	/**
	 * ToolAssert that an object is not {@code null} .
	 * <pre class="code">ToolAssert.notNull(clazz);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object) {
		notNull(object, "[ToolAssertion failed] - this argument is required; it must not be null");
	}
	/**
	 * <pre class="code">ToolAssert.notEmpty(clazz);</pre>
	 * string is not null or ""
	 * @param str
	 * @param message
	 */
	public static void warning(String message) {
		throw new IllegalArgumentException(message);
	}
}
