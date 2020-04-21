package com.ssm.domian.web.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DataTimeConverter implements Converter<String, Date> {

	/**
	 * 用于把 String 类型转成日期类型
	 */
	@Override
	public Date convert(String source) {
		// source就是需要转换的目标字符串
		DateFormat format = null;
		Date date = null;
		try {
			if (source != null && !"".equals(source)) {
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				date = format.parse(source);
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException("输入日期有误");
		}
	}

}
