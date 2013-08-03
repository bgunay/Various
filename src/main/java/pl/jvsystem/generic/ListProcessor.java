package pl.jvsystem.generic;

import java.util.LinkedList;
import java.util.List;

public abstract class ListProcessor<T>
{

	public List<T> process(List<T> inputList)
	{
		List<T> newList = new LinkedList<T>();

		for (T e : inputList)
			newList.add(doProcess(e));

		return newList;
	}

	protected abstract T doProcess(T t);
}

class TestListProcessor
{

	public static void main(String... strings)
	{
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);

		ListProcessor<Integer> lp = new ListProcessor<Integer>()
		{
			@Override
			protected Integer doProcess(Integer t)
			{
				return t * 2;
			}

		};

		lp.process(list);
		System.out.println(list);
	}

}