package pl.jvsystem.patterns.creational.objectpool;

import java.sql.Connection;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 23.05.13 19:20
 */
public class Client
{
	public static void main(String[] args)
	{
		JDBCConnectionPool pool = new JDBCConnectionPool("org.blee", "jdbc:hsqldb://localhost/mydb", "sa", "secret");
		Connection conn = pool.checkOut();
		// use connection
		// ...

		pool.checkIn(conn);
	}
}
