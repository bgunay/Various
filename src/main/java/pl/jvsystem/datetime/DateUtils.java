package pl.jvsystem.datetime;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

//import org.joda.time.Instant;
//import org.joda.time.Period;
//import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//import pl.compan.docusafe.boot.Docusafe;
//import pl.compan.docusafe.core.EdmException;

/**
 * Klasa zawiera metody wspomagaj�ce formatowanie i parsowanie dat.
 * 
 * @author <a href="mailto:lukasz@wa.home.pl">Lukasz Kowalczyk</a>
 * @version $Id: DateUtils.java,v 1.61 2009/11/24 12:44:46 mariuszk Exp $
 * {@link DateFormatters} nale�y u�ywa� DateFormatters uzupe�niaj�c je je�eli format b�dzie cz�sto u�ywany
 */
public class DateUtils
{
	
	/** The Constant log. */
	private final static Logger log = LoggerFactory.getLogger(DateUtils.class);

	/** The Constant DATE_FORMAT_REGEXPS. */
	private static transient final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>()
	{
		private static final long serialVersionUID = 1L;

		{
			put("^\\d{8}$", "yyyyMMdd");
			put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
			put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
			put("^\\d{1,2}/\\d{1,2}/\\d{4}$", "MM/dd/yyyy");
			put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
			put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
			put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
			put("^\\d{12}$", "yyyyMMddHHmm");
			put("^\\d{8}\\s\\d{4}$", "yyyyMMdd HHmm");
			put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}$", "dd-MM-yyyy HH:mm");
			put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy-MM-dd HH:mm");
			put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}$", "MM/dd/yyyy HH:mm");
			put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy/MM/dd HH:mm");
			put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMM yyyy HH:mm");
			put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMMM yyyy HH:mm");
			put("^\\d{14}$", "yyyyMMddHHmmss");
			put("^\\d{8}\\s\\d{6}$", "yyyyMMdd HHmmss");
			put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd-MM-yyyy HH:mm:ss");
			put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy-MM-dd HH:mm:ss");
			put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "MM/dd/yyyy HH:mm:ss");
			put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy/MM/dd HH:mm:ss");
			put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMM yyyy HH:mm:ss");
			put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMMM yyyy HH:mm:ss");
		}
	};

	/**
	 * Instantiates a new date utils.
	 */
	private DateUtils()
	{
	}

	/** The Constant SECOND. */
	public static final long SECOND = 1000L;

	/** The Constant MINUTE. */
	public static final long MINUTE = 60 * SECOND;

	/** The Constant HOUR. */
	public static final long HOUR = 60 * MINUTE;

	/** The Constant DAY. */
	public static final long DAY = 24 * HOUR;

	/** The Constant jsDateFormatYY. */
	public static final DateFormat jsDateFormatYY = new SimpleDateFormat("dd-MM-yy");

	/** The Constant jsTimeFormat. */
	public static final DateFormat jsTimeFormat = new SimpleDateFormat("HH:mm");

	/** dd-MM-yyyy. */
	public static final DateFormat commonDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	/** The Constant commonDateTimeFormat. */
	public static final DateFormat commonDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	/** The Constant commonTimeFormat. */
	public static final DateFormat commonTimeFormat = new SimpleDateFormat("HH:mm");

	/** The Constant sqlDateFormat. */
	public static final DateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/** The Constant commonDateFormatShort. */
	public static final DateFormat commonDateFormatShort = new SimpleDateFormat("dd-MM-yy");

	/** The Constant commonDateTimeFormatShort. */
	public static final DateFormat commonDateTimeFormatShort = new SimpleDateFormat("dd-MM-yy HH:mm");

	/** The Constant sqlDateTimeFormat. */
	public static final DateFormat sqlDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/** The Constant sqlTimeFormat. */
	public static final DateFormat sqlTimeFormat = new SimpleDateFormat("HH:mm:ss");

	/** The Constant yearMonthFormat. */
	public static final DateFormat yearMonthFormat = new SimpleDateFormat("yyyyMM");

	/** The Constant yearMonthDayFormat. */
	public static final DateFormat yearMonthDayFormat = new SimpleDateFormat("yyyyMMdd");
	
	/** The Constant yearMonth_Format. */
	public static final DateFormat yearMonth_Format = new SimpleDateFormat("yyyy-MM");

	/** The Constant year_Format. */
	public static final DateFormat year_Format = new SimpleDateFormat("yyyy");

	/** The Constant polishMonthFormat. */
	public static final DateFormat polishMonthFormat = new SimpleDateFormat("MMMMM", new Locale("pl"));

	/** The Constant slashDateFormat. */
	public static final DateFormat slashDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	// "Only dates between January 1, 1753 and December 31, 9999 are accepted."
	// - dla niekt�rych serwer�w
	/** The Constant zeroDate. */
	public static final Date zeroDate = new GregorianCalendar(1753, GregorianCalendar.JANUARY, 1).getTime();

	/** The Constant commonDateTimeWithoutWhiteSpaceFormat. */
	public static final DateFormat commonDateTimeWithoutWhiteSpaceFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

	/**
	 * Format daty, kt�ry powinien by� przekazywany w konstruktorze kalendarza
	 * javascriptowego na stronach JSP. Musi by� zgodny z warto�ci� sta�ej
	 */
	public static final String jsCalendarDateFormat = "%d-%m-%Y"; // "dd-mm-y";

	/** The Constant bipDateFormat. */
	public static final DateFormat bipDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	/** The Constant portableDateTimeFormat. */
	public static final DateFormat portableDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSS'Z'");
	static
	{
		portableDateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	/**
	 * Sama data. Domy�lna strefa czasowa, poniewa� interesuj�ce s� tylko
	 * warto�ci roku, miesi�ca i dnia.
	 */
	public static final DateFormat portableDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'");

	/** The Constant ldapDateTimeFormat. */
	public static final DateFormat ldapDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	static
	{
		ldapDateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	/**
	 * Przelicza milisekundy na godziny.
	 * 
	 * @param miliseconds
	 *            the miliseconds
	 * @return the double
	 */
	public static double hours(long miliseconds)
	{
		return (double) miliseconds / HOUR;
	}

	/**
	 * Sprawdza, czy w przekazanych obiektach pola dnia, miesi�ca i roku s�
	 * jednakowe. Godziny, minuty etc. s� ignorowane.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return true, if successful
	 */
	public static boolean datesEqual(Date a, Date b)
	{
		if (a==null && b==null)
			return true;
		if (a==null || b==null)
			return false;
		
		Calendar calendarA = Calendar.getInstance();
		Calendar calendarB = Calendar.getInstance();

		calendarA.setTime(a);
		calendarB.setTime(b);

		return calendarA.get(Calendar.DAY_OF_MONTH) == calendarB.get(Calendar.DAY_OF_MONTH)
				&& calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
				&& calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR);
	}
	
	/*
	 * Por�wnanie dat do poziomu sekund.
	 */
	/**
	 * Dates equal to seconds.
	 *
	 * @param a the a
	 * @param b the b
	 * @return true, if successful
	 */
	public static boolean datesEqualToSeconds(Date a, Date b)
	{
		if (a==null && b==null)
			return true;
		if (a==null || b==null)
			return false;
		
		Calendar calendarA = Calendar.getInstance();
		Calendar calendarB = Calendar.getInstance();

		calendarA.setTime(a);
		calendarB.setTime(b);

		return calendarA.get(Calendar.DAY_OF_MONTH) == calendarB.get(Calendar.DAY_OF_MONTH)
				&& calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
				&& calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR)
				&& calendarA.get(Calendar.HOUR_OF_DAY) == calendarB.get(Calendar.HOUR_OF_DAY)
				&& calendarA.get(Calendar.MINUTE) == calendarB.get(Calendar.MINUTE)
				&& calendarA.get(Calendar.SECOND) == calendarB.get(Calendar.SECOND);
	}
	
	/**
	 * Por�wnanie dw�ch timestamp�w (wg konwersji do milisekund i przyr�wnania long-a)
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean timeStampEquals(Date a, Date b)
	{
		if (a==null && b==null)
			return true;
		if (a==null || b==null)
			return false;

		return a.getTime() == b.getTime();
	}
	
	/*
	 * Por�wnanie dat do poziomu sekund.
	 */
	/**
	 * Dates equal to minute.
	 *
	 * @param a the a
	 * @param b the b
	 * @return true, if successful
	 */
	public static boolean datesEqualToMinute(Date a, Date b)
	{
		if (a==null && b==null)
			return true;
		if (a==null || b==null)
			return false;
		
		Calendar calendarA = Calendar.getInstance();
		Calendar calendarB = Calendar.getInstance();

		calendarA.setTime(a);
		calendarB.setTime(b);

		return calendarA.get(Calendar.DAY_OF_MONTH) == calendarB.get(Calendar.DAY_OF_MONTH)
				&& calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
				&& calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR)
				&& calendarA.get(Calendar.HOUR_OF_DAY) == calendarB.get(Calendar.HOUR_OF_DAY)
				&& calendarA.get(Calendar.MINUTE) == calendarB.get(Calendar.MINUTE);
	}
	
	/**
	 * Porownianie dwoch dat pod wzgledem godzin i minut HH:mm
	 * return true, if date1 > date2
	 * else return false.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean compareDateByHours(Date date1, Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		int houer1 = cal1.get(Calendar.HOUR_OF_DAY);
		int houer2 = cal2.get(Calendar.HOUR_OF_DAY);
		int minut1 = cal1.get(Calendar.MINUTE);
		int minut2 = cal2.get(Calendar.MINUTE);
		
		if (houer1 >= houer2) 
		{
			if (houer1 == houer2)
			{
				if (minut1 >= minut2)
				{
					return true;
				}
				else return false;
			}
			return true;
		}
		else return false;
	}
	
	/**
	 * Porownianie dwoch dat pod wzgledem godzin i minut HH:mm
	 * return true, if date1 > date2
	 * else return false.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean compareDate(Date date1, Date date2)
	{
		// je�eli nie jest to ten sam dzie� mo�na wykorzysta� por�wnanie daty
		if (!DateUtils.sameDay(date1, date2))
		{
			return date2.before(date1);
		}
		
		return compareDateByHours(date1, date2);
	}


	/**
	 * Null safe parse js date.
	 * 
	 * @param sDate
	 *            the s date
	 * @return the date
	 */
	public static Date nullSafeParseJsDate(String sDate)
	{
		return sDate == null ? null : parseJsDate(sDate);
	}

	/**
	 * Null safe parse js date time.
	 * 
	 * @param sDateTime
	 *            the s date time
	 * @return the date
	 */
	public static Date nullSafeParseJsDateTime(String sDateTime)
	{
		return sDateTime == null ? null : parseJsDateTime(sDateTime);
	}

	/**
	 * Zwraca obiekt Date odpowiadaj�cy tekstowej reprezentacji zgodnej z
	 * formatem {@link #jsDateFormat}. dd-MM-yyyy Je�eli przekazany parametr nie
	 * mo�e by� poprawnie zinterpretowany, zwracana jest warto�� null.
	 * 
	 * @param sDate
	 *            the s date
	 * @return the date
	 */
	public static Date parseJsDate(String sDate)
	{
		return DateFormatters.instance().parseJsDate(sDate);
	}


	/**
	 * Parses the js date time.
	 * 
	 * @param sDateTime
	 *            the s date time
	 * @return the date
	 */
	public static Date parseJsDateTime(String sDateTime)
	{
		return DateFormatters.instance().parseJsDateTime(sDateTime);
	}


	/**
	 * Parses the js time.
	 * 
	 * @param sTime
	 *            the s time
	 * @return the date
	 */
	@Deprecated
	public static Date parseJsTime(String sTime)
	{
		if (sTime == null)
			throw new NullPointerException("sTime");

		synchronized (jsTimeFormat)
		{
			try
			{
				return jsTimeFormat.parse(sTime);
			}
			catch (ParseException e)
			{
				return null;
			}
		}
	}

	/**
	 * Format js date.
	 * 
	 * @param date
	 *            the date
	 * @return the string
     * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsDate(Date date)
	{
		return DateFormatters.instance().formatJsDate(date);
	}

	/**
	 * Format js date or empty string.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsDateOrEmptyString(Date date)
	{
		try
		{
			return formatJsDate(date);
		} catch (Exception e)
		{
			return "";
		}
	}

	/**
	 * Format js date yy.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsDateYY(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (jsDateFormatYY)
		{
			return jsDateFormatYY.format(date);
		}
	}

	/**
	 * Format js time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsTime(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (jsTimeFormat)
		{
			return jsTimeFormat.format(date);
		}
	}

	/**
	 * Format js date time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsDateTime(Date date)
	{
		return DateFormatters.instance().formatJsDateTime(date);
	}

	/**
	 * Format js date time or empty.
	 *
	 * @param date the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatJsDateTimeOrNull(Date date){
        return DateFormatters.instance().formatJsDateTimeOrNull(date);
	}

	/**
	 * Format common date.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatCommonDate(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (commonDateFormat)
		{
			return commonDateFormat.format(date);
		}
	}

	/**
	 * Format common time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatCommonTime(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (commonTimeFormat)
		{
			return commonTimeFormat.format(date);
		}
	}

	/**
	 * Format common date time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatCommonDateTime(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (commonDateTimeFormat)
		{
			return commonDateTimeFormat.format(date);
		}
	}

	/**
	 * Format common date time without white spaces.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatCommonDateTimeWithoutWhiteSpaces(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (commonDateTimeWithoutWhiteSpaceFormat)
		{
			return commonDateTimeWithoutWhiteSpaceFormat.format(date);
		}
	}

	/**
	 * Format year month.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatYearMonth(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (yearMonthFormat)
		{
			return yearMonthFormat.format(date);
		}
	}

	/**
	 * Format year_ month.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatYear_Month(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (yearMonth_Format)
		{
			return yearMonth_Format.format(date);
		}
	}

	/**
	 * Format year.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatYear(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (year_Format)
		{
			return year_Format.format(date);
		}
	}

	/**
	 * Format polish month.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatPolishMonth(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (polishMonthFormat)
		{
			return polishMonthFormat.format(date);
		}
	}

	/**
	 * Format slash date.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatSlashDate(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (slashDateFormat)
		{
			return slashDateFormat.format(date);
		}
	}

	/**
	 * Format bip date.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatBipDate(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (bipDateFormat)
		{
			return bipDateFormat.format(date);
		}
	}

	/**
	 * Format ldap date time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatLdapDateTime(Date date)
	{
		if (date == null)
			throw new NullPointerException("date");

		synchronized (ldapDateTimeFormat)
		{
			return ldapDateTimeFormat.format(date);
		}
	}

	/**
	 * Parses the ldap date time.
	 * 
	 * @param dateTime
	 *            the date time
	 * @return the date
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static Date parseLdapDateTime(String dateTime)
	{
		if (dateTime == null)
			throw new NullPointerException("dateTime");

		synchronized (ldapDateTimeFormat)
		{
			try
			{
				return ldapDateTimeFormat.parse(dateTime);
			} catch (ParseException e)
			{
				return null;
			}
		}
	}

	/**
	 * Format portable date time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatPortableDateTime(Date date)
	{
		synchronized (portableDateTimeFormat)
		{
			return portableDateTimeFormat.format(date);
		}
	}

	/**
	 * Formatuje sam� dat� w przeno�nym formacie (w strefie czasowej GMT).
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatPortableDate(Date date)
	{
		synchronized (portableDateFormat)
		{
			return portableDateFormat.format(date);
		}
	}

	/**
	 * Format sql date.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatSqlDate(Date date)
	{
		synchronized (sqlDateFormat)
		{
			return sqlDateFormat.format(date);
		}
	}

	/**
	 * Format sql date time.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 * @deprecated {@link DateFormatters} nale�y u�ywa� DateFormatters
	 */
    @Deprecated
	public static String formatSqlDateTime(Date date)
	{
		synchronized (sqlDateTimeFormat)
		{
			return sqlDateTimeFormat.format(date);
		}
	}

	/**
	 * Null safe sql date.
	 * 
	 * @param st
	 *            the st
	 * @return the java.util. date
	 */
	public static Date nullSafeSqlDate(java.sql.Timestamp st)
	{
		return st != null ? new Date(st.getTime()) : null;
	}

	/**
	 * Null safe sql date.
	 * 
	 * @param st
	 *            the st
	 * @return the java.util. date
	 */
	public static Date nullSafeSqlDate(java.sql.Date st)
	{
		return st != null ? new Date(st.getTime()) : null;
	}

	/**
	 * Odejmuje dat� b od daty a, zwraca r�nic� w dniach.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return the int
	 */
	public static int substract(final Date a, final Date b)
	{
		if (a == null)
			throw new NullPointerException("a");
		if (b == null)
			throw new NullPointerException("b");

		if (a == b || a.getTime() == b.getTime())
			return 0;

		boolean negative = b.after(a); // b > a, r�nica b�dzie ujemna
		int delta;

		// podczas oblicze� data calA powinna by� mniejsza ni� calB
		GregorianCalendar calA = new GregorianCalendar();
		calA.setTime(negative ? a : b);
		GregorianCalendar calB = new GregorianCalendar();
		calB.setTime(negative ? b : a);

		if (calA.get(Calendar.YEAR) == calB.get(Calendar.YEAR))
		{
			delta = calB.get(Calendar.DAY_OF_YEAR) - calA.get(Calendar.DAY_OF_YEAR);
		} else
		{
			delta = daysInYear(calA.get(Calendar.YEAR)) - calA.get(Calendar.DAY_OF_YEAR);
			delta += calB.get(Calendar.DAY_OF_YEAR);
			for (int y = calA.get(Calendar.YEAR) + 1; y < calB.get(Calendar.YEAR); y++)
			{
				delta += daysInYear(y);
			}
		}

		return negative ? -delta : delta;
	}

	/**
	 * Zwraca r�nic� mi�dzy datami w dniach.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return a - b. Liczba bez znaku.
	 */
	public static int difference(final Date a, final Date b)
	{
		return Math.abs(substract(a, b));
	}

	/**
	 * Zwraca dat� reprezentuj�c� najp�niejszy mo�liwy do przedstawienia czas
	 * danego dnia.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date endOfDay(Date date)
	{
		Calendar cal = DateUtils.toCalendar(date);

		cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));

		return cal.getTime();
	}

	/**
	 * Zwraca dat� reprezentuj�c� najwcze�niejszy mo�liwy do przedstawienia czas
	 * danego dnia.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date startOfDay(Date date)
	{
		Calendar cal = DateUtils.toCalendar(date);

		cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));

		return cal.getTime();
	}

	/**
	 * TODO: zaimplementowa� :-).
	 * 
	 * @param days
	 *            the days
	 * @return the business days
	 */
	public static int getBusinessDays(int days)
	{
		return days;
	}

	/**
	 * Plus days.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return the date
	 */
	public static Date plusDays(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Plus hours.
	 * 
	 * @param date
	 *            the date
	 * @param hours
	 *            the hours
	 * @return the date
	 */
	public static Date plusHours(Date date, int hours)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);
		return cal.getTime();
	}

	/**
	 * Plus minutes.
	 * 
	 * @param date
	 *            the date
	 * @param minutes
	 *            the minutes
	 * @return the date
	 */
	public static Date plusMinutes(Date date, int minutes)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	/**
	 * Plus business days.
	 * 
	 * A co kaman z tymi business days??? WTF? LOL !
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return the date
	 */
	public static Date plusBusinessDays(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, getBusinessDays(days));
		return cal.getTime();
	}

	/**
	 * Gets the current time.
	 * 
	 * @return the current time
	 */
	public static Date getCurrentTime()
	{
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * Zwraca czas odpowiadaj�cy p�nocy rozpoczynaj�cej dany dzie�.
	 * 
	 * @param date
	 *            the date
	 * @param plusDays
	 *            Liczba dni, kt�re nale�y doda� po ustawieniu czasu na p�noc.
	 * @return the date
	 */
	public static Date midnight(Date date, int plusDays)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.clear(Calendar.HOUR_OF_DAY);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.add(Calendar.DATE, plusDays);
		return cal.getTime();
	}

	/**
	 * Zwraca czas odpowiadaj�cy p�nocy rozpoczynaj�cej dany dzie�.
	 * 
	 * @param date
	 *            the date
	 * @param plusDays
	 *            the plus days
	 * @return the date
	 */
	public static Date nullSafeMidnight(Date date, int plusDays)
	{
		return date != null ? midnight(date, plusDays) : null;
	}

	/**
	 * Zwraca liczb� dni w podanym roku.
	 * 
	 * @param year
	 *            the year
	 * @return the int
	 */
	private static int daysInYear(int year)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	/**
	 * ��czy dat� z godzin�.
	 * 
	 * @param date
	 *            the date
	 * @param time
	 *            the time
	 * @return the date
	 */
	public static Date mergeDateWithTime(Date date, Date time)
	{
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		cal2.setTime(time);
		cal1.set(Calendar.MILLISECOND, cal2.get(Calendar.MILLISECOND));
		cal1.set(Calendar.SECOND, cal2.get(Calendar.SECOND));
		cal1.set(Calendar.MINUTE, cal2.get(Calendar.MINUTE));
		cal1.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY));
		return cal1.getTime();
	}

	/**
	 * Parsuje dat� rozpoznaj�c najpierw po d�ugo�ci roku czy data podana jest w
	 * formacie yyyy-mm-dd czy dd-mm-yyyy.
	 * 
	 * @param sDate
	 *            the s date
	 * @return the date
	 * @throws java.text.ParseException
	 *             the parse exception
	 * TODO metoda napisana beznadziejnie, lepiej uzywac parse
	 */
	@Deprecated
	public static Date parseDateAnyFormat(String sDate) throws ParseException
	{
		String[] split = sDate.split("-");
		if (split.length != 3)
			throw new ParseException("Niew�a�ciwy format daty", 0);
		if (split[0].length() == 4)
			return sqlDateFormat.parse(sDate);
		else if (split[2].length() == 4)
			return commonDateFormat.parse(sDate);
		else if (split[0].length() == 2 || split[2].length() == 2)
			return commonDateFormatShort.parse(sDate);
		throw new ParseException("Niew�a�ciwy format daty", 0);
	}

	/**
	 * Parsuje dat� sprawdza czy po dacie nie ma podanej godziny z minutami
	 * hh:mm pozniej rozpoznaj�c najpierw po d�ugo�ci roku czy data podana jest
	 * w formacie yyyy-mm-dd czy dd-mm-yyyy.
	 * 
	 * @param sDate
	 *            the s date
	 * @return the date
	 * @throws java.text.ParseException
	 *             the parse exception
	 */
	public static Date parseDateTimeAnyFormat(String sDate) throws ParseException
	{
        DateFormatters df = DateFormatters.instance();
		if (sDate.contains(":"))
		{
			String[] split = sDate.split("-");
			if (split.length != 3)
				throw new ParseException("Niew�a�ciwy format daty", 0);
			if (split[0].length() == 4)
				return df.parseSqlDateTimeNoSeconds(sDate);
			else if (split[2].length() > 2)
				return df.parseJsDateTime(sDate);
			else if (split[0].length() == 2 || split[2].length() == 2)
				return commonDateTimeFormatShort.parse(sDate);
		} else
		{
			return parseDateAnyFormat(sDate);
		}
		throw new ParseException("Niew�a�ciwy format daty", 0);
	}

	/**
	 * Convert the given date to a Calendar object. The TimeZone will be derived
	 * from the local operating system's timezone.
	 * 
	 * @param date
	 *            The date to be converted to Calendar.
	 * @return The Calendar object set to the given date and using the local
	 *         timezone.
	 */
	public static Calendar toCalendar(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * Convert the given date to a Calendar object with the given timezone.
	 * 
	 * @param date
	 *            The date to be converted to Calendar.
	 * @param timeZone
	 *            The timezone to be set in the Calendar.
	 * @return The Calendar object set to the given date and timezone.
	 */
	public static Calendar toCalendar(Date date, TimeZone timeZone)
	{
		Calendar calendar = toCalendar(date);
		calendar.setTimeZone(timeZone);
		return calendar;
	}

	/**
	 * Parse the given date string to date object and return a date instance
	 * based on the given date string. This makes use of the
	 *
	 * @param dateString The date string to be parsed to date object.
	 * @return The parsed date object.
	 * @throws java.text.ParseException If the date format pattern of the given date string is
	 * unknown, or if the given date string or its actual date is
	 * invalid based on the date format pattern.
	 * {@link DateUtil#determineDateFormat(String)} to determine the
	 * SimpleDateFormat pattern to be used for parsing.
	 */
	public static Date parse(String dateString) throws ParseException
	{
		Preconditions.checkNotNull(dateString, "Podana data jest null = {}");
		
		String dateFormat = determineDateFormat(dateString);
		if (dateFormat == null)
		{
			throw new ParseException("Unknown date format.", 0);
		}
		return parse(dateString, dateFormat);
	}
	
	/**
	 * Parsowanie daty, format daty ustalany automatycznie.
	 * Je�eli nie uda si� ustali� formatu stosowany jest DD-MM-RRRR.
	 *
	 * @param dateString the date string
	 * @return the date
	 */
	public static Date parseQuietly(String dateString)
	{
		try
		{
			return parse(dateString);
		}
		catch (ParseException e)
		{
			log.error("",e);
			return parseJsDate(dateString);
		}
	}

	/**
	 * Validate the actual date of the given date string based on the given date
	 * format pattern and return a date instance based on the given date string.
	 * 
	 * @param dateString
	 *            The date string.
	 * @param dateFormat
	 *            The date format pattern which should respect the
	 *            SimpleDateFormat rules.
	 * @return The parsed date object.
	 * @throws java.text.ParseException
	 *             If the given date string or its actual date is invalid based
	 *             on the given date format pattern.
	 * @see java.text.SimpleDateFormat
	 */
	public static Date parse(String dateString, String dateFormat) throws ParseException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		simpleDateFormat.setLenient(false); // Don't automatically convert invalid date.
		return simpleDateFormat.parse(dateString);
	}

	// Validators
	// ---------------------------------------------------------------------------------

	/**
	 * Checks whether the actual date of the given date string is valid. This
	 * makes use of the {@link DateUtil#determineDateFormat(String)} to
	 * determine the SimpleDateFormat pattern to be used for parsing.
	 * 
	 * @param dateString
	 *            The date string.
	 * @return True if the actual date of the given date string is valid.
	 */
	public static boolean isValidDate(String dateString)
	{
		try
		{
			parse(dateString);
			return true;
		}
		catch (ParseException e)
		{
			return false;
		}
	}

	/**
	 * Checks whether the actual date of the given date string is valid based on
	 * the given date format pattern.
	 * 
	 * @param dateString
	 *            The date string.
	 * @param dateFormat
	 *            The date format pattern which should respect the
	 *            SimpleDateFormat rules.
	 * @return True if the actual date of the given date string is valid based
	 *         on the given date format pattern.
	 * @see java.text.SimpleDateFormat
	 */
	public static boolean isValidDate(String dateString, String dateFormat)
	{
		try
		{
			parse(dateString, dateFormat);
			return true;
		}
		catch (ParseException e)
		{
			return false;
		}
	}

	// Checkers
	// -----------------------------------------------------------------------------------

	/**
	 * Determine SimpleDateFormat pattern matching with the given date string.
	 * Returns null if format is unknown. You can simply extend DateUtil with
	 * more formats if needed.
	 * 
	 * @param dateString
	 *            The date string to determine the SimpleDateFormat pattern for.
	 * @return The matching SimpleDateFormat pattern, or null if format is
	 *         unknown.
	 * @see java.text.SimpleDateFormat
	 */
	public static String determineDateFormat(String dateString)
	{
		for (String regexp : DATE_FORMAT_REGEXPS.keySet())
		{
			if (dateString.toLowerCase().matches(regexp))
			{
				return DATE_FORMAT_REGEXPS.get(regexp);
			}
		}
		return null; // Unknown format.
	}

	// Changers
	// -----------------------------------------------------------------------------------

	/**
	 * Add the given amount of years to the given date. It actually converts the
	 * date to Calendar and calls {@link CalendarUtil#addYears(java.util.Calendar, int)}
	 * and then converts back to date.
	 *
	 * @param date The date to add the given amount of years to.
	 * @param years The amount of years to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 */
	public static Date addYears(Date date, int years)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addYears(calendar, years);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of months to the given date. It actually converts
	 * the date to Calendar and calls
	 *
	 * @param date The date to add the given amount of months to.
	 * @param months The amount of months to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 * {@link CalendarUtil#addMonths(java.util.Calendar, int)} and then converts back to
	 * date.
	 */
	public static Date addMonths(Date date, int months)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addMonths(calendar, months);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of days to the given date. It actually converts the
	 * date to Calendar and calls {@link CalendarUtil#addDays(java.util.Calendar, int)}
	 * and then converts back to date.
	 *
	 * @param date The date to add the given amount of days to.
	 * @param days The amount of days to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 */
	public static Date addDays(Date date, int days)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addDays(calendar, days);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of hours to the given date. It actually converts the
	 * date to Calendar and calls {@link CalendarUtil#addHours(java.util.Calendar, int)}
	 * and then converts back to date.
	 *
	 * @param date The date to add the given amount of hours to.
	 * @param hours The amount of hours to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 */
	public static Date addHours(Date date, int hours)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addHours(calendar, hours);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of minutes to the given date. It actually converts
	 * the date to Calendar and calls
	 *
	 * @param date The date to add the given amount of minutes to.
	 * @param minutes The amount of minutes to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 * {@link CalendarUtil#addMinutes(java.util.Calendar, int)} and then converts back to
	 * date.
	 */
	public static Date addMinutes(Date date, int minutes)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addMinutes(calendar, minutes);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of seconds to the given date. It actually converts
	 * the date to Calendar and calls
	 *
	 * @param date The date to add the given amount of seconds to.
	 * @param seconds The amount of seconds to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 * {@link CalendarUtil#addSeconds(java.util.Calendar, int)} and then converts back to
	 * date.
	 */
	public static Date addSeconds(Date date, int seconds)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addSeconds(calendar, seconds);
		return calendar.getTime();
	}

	/**
	 * Add the given amount of millis to the given date. It actually converts
	 * the date to Calendar and calls
	 *
	 * @param date The date to add the given amount of millis to.
	 * @param millis The amount of millis to be added to the given date. Negative
	 * values are also allowed, it will just go back in time.
	 * @return the date
	 * {@link CalendarUtil#addMillis(java.util.Calendar, int)} and then converts back to
	 * date.
	 */
	public static Date addMillis(Date date, int millis)
	{
		Calendar calendar = toCalendar(date);
		CalendarUtil.addMillis(calendar, millis);
		return calendar.getTime();
	}

	// Comparators
	// --------------------------------------------------------------------------------

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year.
	 * It actually converts the both dates to Calendar and calls
	 *
	 * @param one The one date.
	 * @param two The other date.
	 * @return True if the two given dates are dated on the same year.
	 * {@link CalendarUtil#sameYear(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#sameYear(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameYear(Date one, Date two)
	{
		return CalendarUtil.sameYear(toCalendar(one), toCalendar(two));
	}

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year
	 * and month. It actually converts the both dates to Calendar and calls
	 *
	 * @param one The one date.
	 * @param two The other date.
	 * @return True if the two given dates are dated on the same year and month.
	 * {@link CalendarUtil#sameMonth(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#sameMonth(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameMonth(Date one, Date two)
	{
		return CalendarUtil.sameMonth(toCalendar(one), toCalendar(two));
	}

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year,
	 * month and day. It actually converts the both dates to Calendar and calls
	 *
	 * @param one The one date.
	 * @param two The other date.
	 * @return True if the two given dates are dated on the same year, month and
	 * day.
	 * {@link CalendarUtil#sameDay(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#sameDay(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameDay(Date one, Date two)
	{
		return CalendarUtil.sameDay(toCalendar(one), toCalendar(two));
	}

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year,
	 * month, day and hour. It actually converts the both dates to Calendar and
	 * calls {@link CalendarUtil#sameHour(java.util.Calendar, java.util.Calendar)}.
	 * 
	 * @param one
	 *            The one date.
	 * @param two
	 *            The other date.
	 * @return True if the two given dates are dated on the same year, month,
	 *         day and hour.
	 * @see CalendarUtil#sameHour(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameHour(Date one, Date two)
	{
		return CalendarUtil.sameHour(toCalendar(one), toCalendar(two));
	}

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year,
	 * month, day, hour and minute. It actually converts the both dates to
	 * Calendar and calls {@link CalendarUtil#sameMinute(java.util.Calendar, java.util.Calendar)}.
	 * 
	 * @param one
	 *            The one date.
	 * @param two
	 *            The other date.
	 * @return True if the two given dates are dated on the same year, month,
	 *         day, hour and minute.
	 * @see CalendarUtil#sameMinute(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameMinute(Date one, Date two)
	{
		return CalendarUtil.sameMinute(toCalendar(one), toCalendar(two));
	}

	/**
	 * Returns <tt>true</tt> if the two given dates are dated on the same year,
	 * month, day, hour, minute and second. It actually converts the both dates
	 * to Calendar and calls {@link CalendarUtil#sameSecond(java.util.Calendar, java.util.Calendar)}
	 * .
	 * 
	 * @param one
	 *            The one date.
	 * @param two
	 *            The other date.
	 * @return True if the two given dates are dated on the same year, month,
	 *         day, hour, minute and second.
	 * @see CalendarUtil#sameSecond(java.util.Calendar, java.util.Calendar)
	 */
	public static boolean sameSecond(Date one, Date two)
	{
		return CalendarUtil.sameSecond(toCalendar(one), toCalendar(two));
	}

	// Calculators
	// --------------------------------------------------------------------------------

	/**
	 * Retrieve the amount of elapsed years between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed years between the two given dates
	 * {@link CalendarUtil#elapsedYears(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedYears(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedYears(Date before, Date after)
	{
		return CalendarUtil.elapsedYears(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed months between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed months between the two given dates.
	 * {@link CalendarUtil#elapsedMonths(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedMonths(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedMonths(Date before, Date after)
	{
		return CalendarUtil.elapsedMonths(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed days between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed days between the two given dates.
	 * {@link CalendarUtil#elapsedDays(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedDays(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedDays(Date before, Date after)
	{
		return CalendarUtil.elapsedDays(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed hours between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed hours between the two given dates.
	 * {@link CalendarUtil#elapsedHours(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedHours(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedHours(Date before, Date after)
	{
		return CalendarUtil.elapsedHours(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed minutes between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed minutes between the two given dates.
	 * {@link CalendarUtil#elapsedMinutes(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedMinutes(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedMinutes(Date before, Date after)
	{
		return CalendarUtil.elapsedMinutes(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed seconds between the two given dates. It
	 * actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed seconds between the two given dates.
	 * {@link CalendarUtil#elapsedSeconds(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedSeconds(java.util.Calendar, java.util.Calendar)
	 */
	public static int elapsedSeconds(Date before, Date after)
	{
		return CalendarUtil.elapsedSeconds(toCalendar(before), toCalendar(after));
	}

	/**
	 * Retrieve the amount of elapsed milliseconds between the two given dates.
	 * It actually converts the both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The amount of elapsed milliseconds between the two given dates.
	 * {@link CalendarUtil#elapsedMillis(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedMillis(java.util.Calendar, java.util.Calendar)
	 */
	public static long elapsedMillis(Date before, Date after)
	{
		return CalendarUtil.elapsedMillis(toCalendar(before), toCalendar(after));
	}

	/**
	 * Calculate the total of elapsed time from years up to seconds between the
	 * two given dates. It Returns an int array with the elapsed years, months,
	 * days, hours, minutes and seconds respectively. It actually converts the
	 * both dates to Calendar and calls
	 *
	 * @param before The first date with expected date before the second date.
	 * @param after The second date with expected date after the first date.
	 * @return The elapsed time between the two given dates in years, months,
	 * days, hours, minutes and seconds.
	 * {@link CalendarUtil#elapsedTime(java.util.Calendar, java.util.Calendar)}.
	 * @see CalendarUtil#elapsedTime(java.util.Calendar, java.util.Calendar)
	 */
	public static int[] elapsedTime(Date before, Date after)
	{
		return CalendarUtil.elapsedTime(toCalendar(before), toCalendar(after));
	}


    
    public static JsonSerializer<Date> gsonTimestampSerializer = new JsonSerializer<Date>() {
		@Override
		public JsonElement serialize(Date date, Type type, JsonSerializationContext ctx) {
			if(date != null) {
				return new JsonPrimitive(date.getTime());
			}
			return null;
		}
	};
	
	public static JsonDeserializer<Date> gsonTimestampDeserializer = new JsonDeserializer<Date>() {
		@Override
		public Date deserialize(JsonElement el, Type type, JsonDeserializationContext ctx) throws JsonParseException {
			try {
				return new Date(el.getAsLong());
			} catch(Exception e) {
				throw new JsonParseException("Cannot convert date", e);
			}
		}
	};


}