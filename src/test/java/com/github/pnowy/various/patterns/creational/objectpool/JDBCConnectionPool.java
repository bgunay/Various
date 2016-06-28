package com.github.pnowy.various.patterns.creational.objectpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 23.05.13 19:17
 */
public class JDBCConnectionPool extends ObjectPool<Connection>
{
	private String dsn, usr, pwd;

	public JDBCConnectionPool(String driver, String dsn, String pwd, String usr)
	{
		super();
		try
		{
			Class.forName(driver).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		this.dsn = dsn;
		this.pwd = pwd;
		this.usr = usr;
	}

	@Override
	protected Connection create()
	{
		try
		{
			DriverManager.getConnection(dsn, usr, pwd);
		}
		catch (SQLException e)
		{
			return null;
		}
		return null;
	}

	@Override
	public boolean validate(Connection o)
	{
		try
		{
			return !o.isClosed();
		}
		catch (SQLException e)
		{
			return false;
		}
	}

	@Override
	public void expire(Connection o)
	{
		try
		{
			o.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
