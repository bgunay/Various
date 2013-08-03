package pl.jvsystem.concurrency;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 06.05.13 22:39
 */
public class CallableFuturesTest
{
	private static final int NTHREDS = 10;

//	public static void main(String...args)
//	{
//		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
//		List<Future<Long>> list = Lists.newArrayList();
//		for (int i = 0; i < 20000; i++)
//		{
//			Callable<Long> worker = new MyCallable();
//			Future<Long> submit = executor.submit(worker);
//			list.add(submit);
//		}
//		long sum = 0;
//		System.out.println(list.size());
//		for (Future<Long> future : list)
//		{
//			try
//			{
//				sum += future.get();
//			}
//			catch (InterruptedException e)
//			{
//				e.printStackTrace();
//			}
//			catch (ExecutionException e)
//			{
//				e.printStackTrace();
//			}
//		}
//		System.out.println(sum);
//		executor.shutdown();
//		Object[] greetings = {"Hello", "Hi"};
//		String[] strings = (String[]) greetings;
//		test("a", "b");
//	}

	public static void main(String[] args) throws Exception {
		String[] greetings = { "Hello", "Hi" };

		// no warning
		Object[] objects = greetings;

		// no warning
		arrayTest(greetings);

		// no warning
		varargTest(objects);

		// warning
		varargTest(greetings);

		varargTest(new String[15]);

		System.out.println("null length array: " + elementCount((Object[])null));
		System.out.println("[a,b,c] length array: " + elementCount("a", "b", "c"));

	}

	private static int elementCount(Object... elements) {
		return elements == null ? 0 : elements.length;
	}

	public static Object[] arrayTest(Object[] p) {
		return p;
	}
	public static Object[] varargTest(Object... p) {
		return p;
	}

	public static void test(String...abc)
	{
		System.out.println(Arrays.toString(abc));
	}

}
