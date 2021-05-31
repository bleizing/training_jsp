package com.bleizing.logging;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Logging {
	private final Logger logger;
	public long duration;

	/*
	static {
		synchronized (Logging.class) {
			final Properties _fload = new Properties();
			try {
				final InputStream _instream = Logging.class.getResourceAsStream("../../../log4j.properties");
				_fload.load(_instream);
				_instream.close();
			} catch (final Exception e) {
				if (AppSetting.PRINT_STACKTRACE) {
					e.printStackTrace(System.out);
				}
			}


			try {
				final Properties _props = new Properties();
				final File _conf = new File(AppSetting.getConfigPath(), "logging.properties");

				final InputStream _instream = new FileInputStream(_conf);
				_props.load(_instream);
				_instream.close();

				_fload.putAll(_props);

				PropertyConfigurator.configure(_fload);
			} catch (final Exception e) {
				if (AppSetting.PRINT_STACKTRACE) {
					e.printStackTrace(System.out);
				}
			}
		}
	}
	 */

	private static final char NEW_LINE = '\n';

	private static final String INDENT = "    ";

	private final StringBuilder buffer = new StringBuilder();

	private String className;

	private String methodName;

	private boolean prefixDate = true;

	private static final DateFormat LINE_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US);

	private static final NumberFormat DURATION_FORMAT = new DecimalFormat("#,##0");

	public final Date start;
	public Date finish;


	public Logging(final String name) {
		this.logger = Logger.getLogger(name);

		this.start = new Date();
		this.finish = new Date();
	}

	public Logging(final Class<?> clazz) {
		this.logger = Logger.getLogger(clazz);
		this.start = new Date();
		this.finish = new Date();
	}

	/*
	public static Logger getLogger(Class clazz) {
		return Logger.getLogger(clazz);
	}
	public static Logger getLogger(String name) {
		return Logger.getLogger(name);
	}
	 */

	public Logging() {
		this("");
	}

	public final Logging setClass(final Class<?> clazz) {
		return this.setClass(clazz.getName());
	}

	public final Logging setClass(final String className) {
		this.className = className;

		return this;
	}

	public final Logging setMethod(final String methodName) {
		this.methodName = methodName;

		return this;
	}

	public final Logging setMethod(final Method method) {
		return this.setMethod(method.getName());
	}

	private String indentation(final int count) {
		final StringBuilder _ret = new StringBuilder();
		for (int i = 0; i < count; i++) {
			_ret.append(Logging.INDENT);
		}

		return _ret.toString();
	}

	public final Logging append(final String obj) {
		if (this.prefixDate) {
			this.finish = new Date();
			this.buffer.append(this.indentation(1))
			.append(Logging.LINE_DATE.format(this.finish));
		}

		this.buffer.append(obj);
		this.prefixDate = false;
		return this;
	}

	public final Logging append(final Number obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final HttpServletRequest obj) {
		final String _indent = this.indentation(3);
		final StringBuilder _bldr = new StringBuilder();

		String str;
		int intNum;

		str = obj.getScheme();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("Scheme: ").append(str);
		}

		str = obj.getHeader("Cookie");
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("Cookie: ").append(str);
		}


		HttpSession _sess = obj.getSession();
		if (null != _sess) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("Session Id: ").append(_sess.getId());
		}

		str = obj.getAuthType();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("auth-type: ").append(str);
		}

		str = obj.getCharacterEncoding();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("character-encoding: ").append(str);
		}

		str = obj.getContentType();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("content-type: ").append(str);
		}

		str = obj.getContextPath();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("context-path: ").append(str);
		}

		str = obj.getLocalAddr();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("local-address: ").append(str);
		}

		str = obj.getLocalName();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("local-name: ").append(str);
		}

		str = obj.getMethod();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("method: ").append(str);
		}

		str = obj.getPathInfo();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("path-info: ").append(str);
		}

		str = obj.getPathTranslated();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("path-translated: ").append(str);
		}

		str = obj.getProtocol();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("protocol: ").append(str);
		}

		str = obj.getQueryString();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("query-string: ").append(str);
		}

		str = obj.getRemoteAddr();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("remote-address: ").append(str);
		}

		str = obj.getRemoteHost();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("remote-host: ").append(str);
		}

		intNum = obj.getRemotePort();
		if (0 < intNum) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("remote-port: ").append(intNum);
		}

		str = obj.getRemoteUser();
		if (null != str) {
			_bldr.append(Logging.NEW_LINE).append(_indent)
			.append("remote-user: ").append(str);
		}

		str = obj.getRequestedSessionId();

		return this.append(_bldr.toString());
	}

	public final Logging append(final Character obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final Integer obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final Double obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final Float obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final Long obj) {
		return this.append(String.valueOf(obj));
	}

	public final Logging append(final BigDecimal obj) {
		return this.append(obj.toPlainString());
	}


	public final Logging append(final Throwable obj) {
		return this.append(obj, 0);
	}

	public final Logging append(final Throwable obj, final int indent) {
		int _indent = indent + 1;
		final String _indentStr = this.indentation(_indent);
		final StringBuilder _buff = new StringBuilder();
//		if (obj instanceof ProcessException || obj instanceof ProcessExceptionDesc) {
//			if (!obj.getMessage().equalsIgnoreCase(ErrorType.UNEXPECTED_ERROR.description)){
//				return this;
//			}
//		}
		if (null == obj) {
			_buff.append(_indentStr).append("null");
		} else {
			try {
				_buff.append(obj.getClass().getName()).append(": ").append(obj.getMessage()).append(Logging.NEW_LINE);
				final StackTraceElement[] _elems = obj.getStackTrace();
				int _lastIdx = 0;

				for (int i = _elems.length - 1; i >= 0; i--) {
					final StackTraceElement _elem = _elems[i];
					final String _classname = _elem.getClassName();
					if (_classname.startsWith("com.bleizing")) {
						_lastIdx = i;
						break;
					}
				}

				for (int i = 0; i <= _lastIdx; i++) {
					final StackTraceElement _elem = _elems[i];
					_buff.append(this.indentation(_indent + 1))
					.append("class: ").append(_elem.getClassName()).append(", ")
					.append("method: ").append(_elem.getMethodName()).append(", ")
					.append("line: ").append(_elem.getLineNumber() < 1 ? "<unknown>" : String.valueOf(_elem.getLineNumber()))
					.append(Logging.NEW_LINE);
				}
				_buff.delete(_buff.length() - 1, _buff.length());
				this.append(_buff.toString());

				if (null != obj.getCause()) {
					_indent++;
					this.append(Logging.NEW_LINE)
					.append(this.indentation(_indent + 1))
					.append("cause: ");
					this.append(obj.getCause(), _indent);
				}
			}catch(Exception e) {
				//just ignore the exception...
			}
		}


		return this;
	}

	public final Logging appendLine() {
		this.buffer.append(Logging.NEW_LINE);
		this.prefixDate = true;
		return this;
	}

	public final void write() {
		this.flush(Level.ALL);
	}

	public final void trace() {
		this.flush(Level.TRACE);
	}

	public final void debug() {
		this.flush(Level.DEBUG);
	}

	public final void info() {
		this.flush(Level.INFO);
	}

	public final void warn() {
		this.flush(Level.WARN);
	}

	public final void error() {
		this.flush(Level.ERROR);
	}

	public final void fatal() {
		this.flush(Level.FATAL);
	}

	private void flush(Level level) {
		if (null == level || null == this.logger) {
			return;
		}

		if(this.buffer.length()==0) {
			return;
		}

		final String _methodName = null == this.methodName ? "" : this.methodName.trim();
		this.buffer.insert(0, Logging.NEW_LINE);
		if ("".equals(_methodName)) {
			this.buffer.insert(0, "<method>");
		} else {
			this.buffer.insert(0, _methodName);
		}

		final String _className = null == this.className ? "" : this.className.trim();
		if ("".equals(_className)) {
			this.buffer.insert(0, "<class> - ");
		} else {
			this.buffer.insert(0, " - ").insert(0, _className);
		}

		this.duration = this.finish.getTime() - this.start.getTime();
		boolean isNewLine = true;
		while (isNewLine) {
			this.buffer.delete(this.buffer.length() - 1, this.buffer.length());
			isNewLine = this.buffer.charAt(this.buffer.length() - 1) == Logging.NEW_LINE;
		}

		this.buffer.append(Logging.NEW_LINE);
		this.buffer.append(this.indentation(1))
		.append("--> duration: ")
		.append(Logging.DURATION_FORMAT.format(duration)).append(" ms");
		this.buffer.append(Logging.NEW_LINE);

		try {
			String logString = this.buffer.toString()//.replaceAll("(\"(?i)(?>new|)password\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1***")
					.replaceAll("(\"(?i)(?>video|)record\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1base64Video")
					.replaceAll("(\"(?i)(?>doc|)ktp\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1base64DocKtp")
					.replaceAll("(\"(?i)(?>doc|)ttd\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1base64DocTtd")
					.replaceAll("(\"(?i)(?>doc|)npwp\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1base64DocNpwp")
					.replaceAll("(\"(?i)(?>doc|)photo\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1base64DocPhoto")
					.replaceAll("(\"(?i)content\"(?>\\s+|):(?>\\s+|)\").+(?=\")", "$1content")
					.replaceAll("(data:image/png;base64),(.*)","[$1]");

			logString = excludePass(logString);
			
			
			            System.out.println(logString);
			if (Level.FATAL.equals(level)) {
				this.logger.fatal(logString);
			} else if (Level.ERROR.equals(level)) {
				this.logger.error(logString);
			} else if (Level.WARN.equals(level)) {
				this.logger.warn(logString);
			} else if (Level.INFO.equals(level)) {
				this.logger.info(logString);
			} else if (Level.DEBUG.equals(level)) {
				this.logger.debug(logString);
			} else if (Level.TRACE.equals(level)) {
				this.logger.trace(logString);
			} else if (Level.ALL.equals(level)) {
				synchronized (this.logger) {
					final Level _level = this.logger.getLevel();
					this.logger.setLevel(Level.ALL);
					this.logger.trace(logString);
					this.logger.setLevel(_level);
				}
			}
		} catch (Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
				e.printStackTrace(System.out);
//			}
		}

		final int _len = this.buffer.length();
		this.buffer.delete(0, _len);
	}

	private String excludePass(String str) {
		str = str.replaceAll("(\"confirmPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
		str = str.replaceAll("(\"newPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
		str = str.replaceAll("(\"oldPassword\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
		str = str.replaceAll("(\"password\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
		str = str.replaceAll("(\"pin\"(?>\\s+|):(?>\\s+|)(?=\")\")([^\"]+(?=\"))", "$1*****");
		return str;
	}


	public String getLoggerName() {
		return this.logger.getName();
	}




	/*

	public void info(Object message) {
		this.logger.info(message);
	}

	public void info(Object message,Throwable t) {
		this.logger.info(message,t);
	}

	public void debug(Object message) {
		this.logger.debug(message);
	}

	public void debug(Object message,Throwable t) {
		this.logger.debug(message,t);
	}


	public void error(Object message) {
		this.logger.error(message);
	}

	public void error(Object message,Throwable t) {
		this.logger.error(message,t);
	}

	public void trace(Object message) {
		this.logger.trace(message);
	}

	public void trace(Object message,Throwable t) {
		this.logger.trace(message,t);
	}
	 */
}
