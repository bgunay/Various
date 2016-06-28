package com.github.pnowy.various.datetime;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * Klasa do formatowania dat, formattery nie s� thread safe, wi�c lepiej trzyma� je w
 * thread context
 *
 * Najlepiej wyci�ga� DateFormattery raz i p�niej korzysta� z wyci�gni�tego obiektu (o ile b�dzie wykorzystywany
 * w tym samym w�tku) np:
 * <pre>
 * {@code
 * DateFormatters df = DateFormatters.instance();
 * String sDate1 = df.formatJsDate(date1);
 * String sDate2 = df.formatJsDate(date2);
 * }
 * </pre>
 * @author Micha� Sankowski <michal.sankowski@docusafe.pl>
 */
public final class DateFormatters implements Serializable
{
//    private final static Logger LOG = LoggerFactory.getLogger(DateFormatters.class);
    /** Mapa zawieraj�ca wszystkie formaty dat */
    private final ImmutableMap<String, DateFormat> patternToFormat = ImmutableMap.<String, DateFormat>builder()
            .put("dd-MM-yyyy", new SimpleDateFormat("dd-MM-yyyy"))
            .put("dd-MM-yyyy HH:mm",  new SimpleDateFormat("dd-MM-yyyy HH:mm"))
            .put("dd-MM-yyyy HH:mm:ss", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"))
            .put("yyyy-MM-dd HH:mm", new SimpleDateFormat("yyyy-MM-dd HH:mm"))
            .put("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd"))
		    .put("yyyy-MM-dd HH-mm", new SimpleDateFormat("yyyy-MM-dd HH-mm"))
            .build();

    /** "dd-MM-yyyy" Format daty u�ywany w formularzach w ca�ej aplikacji. */
    private final DateFormat jsDateFormat = patternToFormat.get("dd-MM-yyyy");

    /** format "dd-MM-yyyy HH:mm" */
    private final DateFormat jsDateTimeFormat = patternToFormat.get("dd-MM-yyyy HH:mm");

    /** format "dd-MM-yyyy HH:mm:ss" */
    private final DateFormat jsDateTimeWithSecondsFormat = patternToFormat.get("dd-MM-yyyy HH:mm:ss");

    /** format "yyyy-MM-dd HH:mm" */
    private final DateFormat sqlDateTimeFormatNoSeconds = patternToFormat.get("yyyy-MM-dd HH:mm");
    
	/** format "yyyy-MM-dd" */
	public final DateFormat sqlDateFormat = patternToFormat.get("yyyy-MM-dd");

	public final DateFormat windowsFilenameDateFormat = patternToFormat.get("yyyy-MM-dd HH-mm");

    /** wzorce nie zdefiniowane w patternToFormat przechowywane tymczasowo */
    private transient SoftReference<Map<String, DateFormat>> undefinedPatterns = new SoftReference<Map<String, DateFormat>>(Maps.<String, DateFormat>newHashMapWithExpectedSize(2));

    /**
     * Zwraca format na podstawie ��danego formatu
     * @param format
     * @return now� instancj� formatu
     */
    public DateFormat get(String format)
    {
        checkNotNull(format, "format");
        DateFormat ret = patternToFormat.get(format);
        if(ret == null)
        {
//            LOG.debug("Niezapisany format daty : '{}'", format);
            Map<String, DateFormat> map = undefinedPatterns.get();

            if(map == null)
            {
                map = Maps.newHashMap();
                ret = new SimpleDateFormat(format);
                map.put(format, ret);
                undefinedPatterns = new SoftReference<Map<String, DateFormat>>(map);
            }
            else
            {
                ret = map.get(format);
                if(ret == null)
                {
                    ret = new SimpleDateFormat(format);
                    map.put(format, ret);
                }
            }
        }
        return ret;
    }

    /**
     * Parses the js date time "dd-MM-yyyy HH:mm:ss".
     *
     * @param sDateTime "dd-MM-yyyy HH:mm"
     * @return the date, null gdy wyst�pi b��d
     */
    public Date parseJsDateTimeWithSeconds(String sDateTime) {
        checkNotNull(sDateTime, "date");
        try {
            return jsDateTimeWithSecondsFormat.parse(sDateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Formatuje wg szablonu "dd-MM-yyyy HH:mm:ss"
     * @param date
     * @return string wg, szablonu
     * @throws NullPointerException gdy date jest null
     */
    public String formatJsDateTimeWithSeconds(Date date){
        checkNotNull(date, "date");
        return jsDateTimeWithSecondsFormat.format(date);
    }

	public String formatWindowsFilename(Date date)
	{
		checkNotNull(date, "date");
		return windowsFilenameDateFormat.format(date);
	}

    /**
     * Formatuje wg szablonu dd-MM-yyyy
     * @param date
     * @return string wg, szablonu
     * @throws NullPointerException gdy date jest null
     */
    public String formatJsDate(Date date){
        checkNotNull(date, "date cannot be null");
        return jsDateFormat.format(date);
    }

    /**
     * Formatuje wg szablonu dd-MM-yyyy, null safe
     * @param date
     * @return string wg szablonu, lub null gdy date == null
     */
    public String formatJsDateOrNull(Date date) {
        if (date == null) return null;
        return jsDateFormat.format(date);
    }

    /**
     * Zwraca obiekt Date odpowiadaj�cy tekstowej reprezentacji zgodnej z
     * formatem {@link #jsDateFormat}. dd-MM-yyyy Je�eli przekazany parametr nie
     * mo�e by� poprawnie zinterpretowany, zwracana jest warto�� null.
     *
     * @param sDate string zawieraj�cy dat�
     * @return the date
     */
    public Date parseJsDate(String sDate) {
        if (sDate == null) {
            throw new NullPointerException("sDate");
        }

        try {
            return jsDateFormat.parse(sDate);
        } catch (ParseException e) {
//            LOG.warn("parse error:{} {}", sDate, e.getMessage());
            return null;
        }
    }

    /**
     * Format js date time "dd-MM-yyyy HH:mm".
     *
     * @param date
     *            the date
     * @return the string
     */
    public String formatJsDateTime(Date date) {
        if (date == null)
            throw new NullPointerException("date");

        return jsDateTimeFormat.format(date);
    }
    
    /**
     * Parses the js date time "dd-MM-yyyy HH:mm".
     *
     * @param sDateTime "dd-MM-yyyy HH:mm"
     * @return the date
     */
    public Date parseJsDateTime(String sDateTime) {
        if (sDateTime == null)
            throw new NullPointerException("sDateTime");

        try {
            return jsDateTimeFormat.parse(sDateTime);
        } catch (ParseException e) {
//        	LOG.warn("Problem z parsowaniem daty. "+e);
            return null;
        }
    }

    /**
     * Format js date time or empty "dd-MM-yyyy HH:mm".
     *
     * @param date the date
     * @return the string
     */
    public String formatJsDateTimeOrNull(Date date)
    {
        if (date == null)
            return null;

        return jsDateTimeFormat.format(date);
    }
    
    /**
     * Fromat "yyyy-MM-dd"
     * @param date
     * @return
     */
	public String formatSqlDate(Date date)
	{
		if (date == null)
            throw new NullPointerException("sqlDate");
		
		return sqlDateFormat.format(date);
	}

    /**
     * format "yyyy-MM-dd HH:mm"
     * @param date not null
     * @return "yyyy-MM-dd HH:mm"
     */
    public String formatSqlDateTimeNoSeconds(Date date) {
        checkNotNull(date, "date");
        return sqlDateTimeFormatNoSeconds.format(date);
    }

    /**
     * parse "yyyy-MM-dd HH:mm"
     * @param sDate
     * @return Date, null on error
     */
    public Date parseSqlDateTimeNoSeconds(String sDate){
        try {
            return sqlDateTimeFormatNoSeconds.parse(sDate);
        } catch (ParseException e) {
            return null;
        }
    }

    //================ THREAD LOCALE ==================
    private static ThreadLocal<DateFormatters> threadFormatters = new ThreadLocal<DateFormatters>(){
        @Override
        protected DateFormatters initialValue() {
            return new DateFormatters();
        }
    };

    public static DateFormatters instance(){
        return threadFormatters.get();
    }
}
