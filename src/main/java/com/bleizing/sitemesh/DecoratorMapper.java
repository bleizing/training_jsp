package com.bleizing.sitemesh;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.module.sitemesh.*;
import com.opensymphony.module.sitemesh.mapper.*;

public class DecoratorMapper extends ConfigDecoratorMapper {
	/**
	 * 
	 */
	private transient ConfigLoader conf;
	
	/**
	 * 
	 */
	public void init(final Config config, final Properties properties, final DecoratorMapper parent) throws InstantiationException {
		super.init(config, properties, parent);
		try {
			final String _xmlFile = properties.getProperty("config", "/WEB-INF/decorators.xml");
			this.conf = new ConfigLoader(_xmlFile, config);
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
				e.printStackTrace(System.out);
//			}

			throw new InstantiationException(e.toString());
		}
	}

	/**
	 * 
	 */
	public Decorator getDecorator(final HttpServletRequest request, final Page page) {
		Decorator ret = null;
		try {
			final String _requestURI = request.getRequestURI();			
			final String _mapperKey = _requestURI.substring(request.getContextPath().length(), _requestURI.length());
			final String _mapper = conf.getMappedName(_mapperKey);
			
			ret = getNamedDecorator(request, _mapper);
			
		} catch (final Exception e) {
//			if (AppSetting.PRINT_STACKTRACE) {
				e.printStackTrace(System.out);
//			}
		}

		return null == ret? super.getDecorator(request, page) : ret;
	}
}
