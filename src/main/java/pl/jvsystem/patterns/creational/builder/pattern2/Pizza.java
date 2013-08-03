package pl.jvsystem.patterns.creational.builder.pattern2;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:51
 */
public class Pizza
{
	private int size;
	private boolean cheese;
	private boolean pepperoni;
	private boolean bacon;

	public Pizza(Builder builder)
	{
		this.size = builder.size;
		this.cheese = builder.cheese;
		this.pepperoni = builder.pepperoni;
		this.bacon = builder.bacon;
	}

	public static class Builder
	{
		private final int size;
		private boolean cheese = false;
		private boolean pepperoni = false;
		private boolean bacon = false;

		public Builder(int size)
		{
			this.size = size;
		}

		public Builder cheese(boolean value)
		{
			cheese = value;
			return this;
		}

		public Builder pepperoni(boolean value)
		{
			pepperoni = value;
			return this;
		}

		public Builder bacon(boolean value)
		{
			bacon = value;
			return this;
		}

		public Pizza build()
		{
			return new Pizza(this);
		}

	}

	@Override
	public String toString()
	{
		return "Pizza{" +
				"bacon=" + bacon +
				", size=" + size +
				", cheese=" + cheese +
				", pepperoni=" + pepperoni +
				'}';
	}
}
