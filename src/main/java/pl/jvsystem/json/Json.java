package pl.jvsystem.json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * Date: 28.10.13 16:04
 */
public class Json {
	public static void main(String[] args) {
		String t = "ala";

		System.out.println(new Gson().toJson(Maps.newHashMap().put("code", t)));
	}
}
