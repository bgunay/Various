package pl.jvsystem.nosql.redis;

import redis.clients.jedis.Jedis;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 04.12.13 22:20
 */
public class Demo
{
	public static void main(String[] args) throws InterruptedException
	{
		Jedis jedis = new Jedis("192.168.27.130", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);

		String cacheKey = "cachekey";
		//adding a new key
		jedis.set(cacheKey, "cached value");

		//setting the TTL in seconds
		jedis.expire(cacheKey, 15);

		//Getting the remaining ttl
		System.out.println("TTL:" + jedis.ttl(cacheKey));
		Thread.sleep(1000);
		System.out.println("TTL:" + jedis.ttl(cacheKey));
		//Getting the cache value
		System.out.println("Cached Value:" + jedis.get(cacheKey));

		//Wait for the TTL finishs
		Thread.sleep(15000);

		//trying to get the expired key
		System.out.println("Expired Key:" + jedis.get(cacheKey));

		//Adding a set as value
		jedis.sadd(cacheKey,"Java","C#","Python");//SADD

		//Getting all values in the set: SMEMBERS
		System.out.println("Languages: " + jedis.smembers(cacheKey));
		//Adding new values
		jedis.sadd(cacheKey,"Java","Ruby");
		//Getting the values... it doesn't allow duplicates
		System.out.println("Languages: " + jedis.smembers(cacheKey));
	}
}
