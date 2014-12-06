package pl.jvsystem.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * GettingStarted
 */
public class GettingStarted {

	static final MetricRegistry metrics = new MetricRegistry();

	public static void main(String[] args) {
		startReport();
		Meter requests = metrics.meter("requests");

		requests.mark();
		requests.mark();
		wait5Seconds();
	}

	static void startReport() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
				.convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS)
				.build();
		reporter.start(1, TimeUnit.SECONDS);
	}

	static void wait5Seconds() {
		try {
			Thread.sleep(5*1000);
		}
		catch(InterruptedException ignored) {}
	}

}
