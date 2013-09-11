package pl.jvsystem.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.09.13 12:04
 */
public class CacheTest
{
	public static void main(String[] args) throws ExecutionException
	{
		LoadingCache<String, Book> books = CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(5, TimeUnit.MINUTES)
//				.removalListener()
				.build(new CacheLoader<String, Book>()
				{
					@Override
					public Book load(String s) throws Exception
					{
						return getBookFromDB(s);
					}
				});



		books.get("twoja stara");
		books.get("twoja stara");
		books.getUnchecked("twoja stara");
		books.invalidateAll();
		books.get("twoja stara");
	}

	static class Book
	{
		private String name;

		Book(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
		}
	}

	private static Book getBookFromDB(String name)
	{
		System.out.println("get book from db:" + name);
		return new Book(name);
	}

}
