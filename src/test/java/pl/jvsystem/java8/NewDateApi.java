package pl.jvsystem.java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class NewDateApi {
	private static final Logger LOG = LoggerFactory.getLogger(NewDateApi.class);

	@Test
	public void testClock() throws Exception {
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();

		Instant instant = clock.instant();

		Date legacyDate = Date.from(instant);   // legacy java.util.Date
	}

	@Test
	public void testTimeZone() throws Exception {
		LOG.trace("All zones: {}", ZoneId.getAvailableZoneIds());

		ZoneId zone1 = ZoneId.of("Europe/Warsaw");
		ZoneId zone2 = ZoneId.of("America/Los_Angeles");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);

		System.out.println(now1.isBefore(now2));  // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239
	}

	@Test
	public void testTime() throws Exception {
		LocalTime late = LocalTime.of(23, 59, 59);

		System.out.println(late);       // 23:59:59

		DateTimeFormatter germanFormatter =
				DateTimeFormatter
						.ofLocalizedTime(FormatStyle.SHORT)
						.withLocale(Locale.forLanguageTag("PL"));

		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37

	}

	@Test
	public void testLocalDate() throws Exception {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);

		LocalDate independenceDay = LocalDate.of(1987, Month.MAY, 30);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);    // FRIDAY

		DateTimeFormatter germanFormatter =
				DateTimeFormatter
						.ofLocalizedDate(FormatStyle.MEDIUM)
						.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas);   // 2014-12-24
	}

	@Test
	public void testLocalDateTime() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now with last day of mont: "+now.with(TemporalAdjusters.lastDayOfMonth()));

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);      // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);    // 1439

		Instant instant = sylvester
				.atZone(ZoneId.systemDefault())
				.toInstant();

		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);

		DateTimeFormatter formatter =
				DateTimeFormatter
						.ofPattern("MMM dd, yyyy - HH:mm");


		String string = formatter.format(LocalDateTime.now());
		System.out.println(string);     // Nov 03, 2014 - 07:13

	}

	@Test
	public void testDuration() {
		Duration duration = Duration.ofDays(566);
	}

}
