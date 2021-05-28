package com.bleizing.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.Scanner;

public class ClassUtil {
	private ClassUtil() {}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Class<?> forName(final String name) {
		Class<?> ret = null;
		try {
			ret = Class.forName(name, false, Thread.currentThread().getContextClassLoader());
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
		}

		return ret;

	}

	/**
	 * 
	 * @param packagename
	 * @return Set&lt;String&gt;
	 */
	public static Set<String> scanClasses(final String packagename) {
		final Set<String> _ret = new HashSet<String>(0);
		try {
			final Scanner _scanner = new ResourcesScanner();
			final Reflections _ref = new Reflections(packagename, _scanner);
			final Set<String> _scanned = _ref.getResources(Pattern.compile(".+\\.class$"));
			for (final String _classname: _scanned) {
				String formattedClassName = _classname.replaceAll("\\.class$", "").replace('/', '.').trim();

				_ret.add(formattedClassName);

			}
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
		}

		return _ret;
	}

	public static List<Field> scanClassFields(final Class<?> clazz) {
		final List<Field> _ret = new ArrayList<Field>();
		if (null == clazz) {
			return _ret;
		}

		try {
			final Field[] _fields = clazz.getDeclaredFields();
			for (final Field _field : _fields) {
				if (Modifier.isStatic(_field.getModifiers())) {
					continue;
				}

				_ret.add(_field);
			}

			final Class<?> _super = clazz.getSuperclass();
			if (!Object.class.equals(_super)) {
				_ret.addAll(scanClassFields(_super));
			}
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
//				e.printStackTrace(System.out);
//			}
		}

		return _ret;
	}

	public static List<Field> scanFields(final Object object) {
		if (null == object) {
			return new ArrayList<Field>();
		}

		return ClassUtil.scanClassFields(object.getClass());
	}
}
