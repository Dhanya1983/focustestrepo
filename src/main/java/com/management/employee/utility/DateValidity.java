package com.management.employee.utility;

import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidity {

	public static boolean checkValidDate1(String strDate) {
		if (!strDate.trim().equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd");
			sdf.setLenient(false);
			try {
				java.util.Date d = sdf.parse(strDate);
				System.out.println("Valid Format" + d);
			} catch (ParseException e) {
				System.out.println("Invalid Format " + e.getMessage());
				return true;
			}
		}
		return false;
	}

	public static boolean checkValidDate(Date strDate) {

		try {
			Format sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s = sdf.format(strDate);
			System.out.println("Valid Format" + sdf);
		} catch (Exception e) {
			System.out.println("Invalid Format " + e.getMessage());
			return true;
		}

		return false;
	}

	public static void main(String args[]) throws ParseException {
		// boolean val=DateValidity.checkValidDate(new java.sql.Date());
		// System.out.println(val);
	}

}
