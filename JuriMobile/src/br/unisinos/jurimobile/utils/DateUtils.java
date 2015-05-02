package br.unisinos.jurimobile.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String MASK_DATE_TIME = "yyyy-MM-dd hh:mm";

	public static Date parseDate(String stringDate) {
		if (stringDate != null) {
			try {
				return new SimpleDateFormat(MASK_DATE_TIME).parse(stringDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String formatDate(Date date) {
		if (date != null) {
			return new SimpleDateFormat(MASK_DATE_TIME).format(date);
		}
		return null;
	}

}
