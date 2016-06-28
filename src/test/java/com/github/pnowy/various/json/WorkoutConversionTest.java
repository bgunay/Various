package com.github.pnowy.various.json;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

/**
 * WorkoutLog conversion snippet
 */
public class WorkoutConversionTest {
	private static final Logger LOG = LoggerFactory.getLogger(WorkoutConversionTest.class);

	@Test
	public void convertWorkoutJson() {
		JSONObject jsonObject = new JSONObject(getJsonFromFile("workoutlogapp-prod-export.json"));
		lookup("/", null, 0, null, jsonObject);
		System.out.println(jsonObject);
	}

	private void lookup(String path, String currentKey, int keyIndex, JSONObject parent, JSONObject current) {
//		if (   path.matches("^/exercises/[a-zA-Z0-9-_]+/$") // ćwiczenia
//				|| path.matches("^/plans/google:[0-9]+/[a-zA-Z0-9-_]+/$") // pplany
//				|| path.matches("^/plans/google:[0-9]+/[a-zA-Z0-9-_]+/exercises/[a-zA-Z0-9-_]+/$") // ćwiczenia w planie
//				|| path.matches("^/plans/google:[0-9]+/[a-zA-Z0-9-_]+/exercises/[a-zA-Z0-9-_]+/series/[a-zA-Z0-9-_]+/$") // serie w planie
//				|| path.matches("^/trainings/google:[0-9]+/[a-zA-Z0-9-_]+/$") // treningi
//				|| path.matches("^/trainings/google:[0-9]+/[a-zA-Z0-9-_]+/exercises/[a-zA-Z0-9-_]+/$") // ćwiczenia w treningu
//				|| path.matches("^/trainings/google:[0-9]+/[a-zA-Z0-9-_]+/exercises/[a-zA-Z0-9-_]+/series/[a-zA-Z0-9-_]+/$")) {
//			System.out.println(path);
//			current.remove(".priority");
//			current.put(".priority", keyIndex);
//		}
		if (path.startsWith("/exercises/")) {
			return;
		}

		if (current.has("series")) {
			JSONObject series = current.getJSONObject("series");
			JSONArray jsonArray = new JSONArray();
			Iterator<String> keys = series.keys();
			while (keys.hasNext()) {
				JSONObject singleSeries = series.getJSONObject(keys.next());
				jsonArray.put(singleSeries);
			}
			current.put("series", jsonArray);
			System.out.println(path);
		}

		Iterator<String> keys = current.keys();
		int index = 1;
		while (keys.hasNext()) {
			String key = keys.next();
			Object object = current.get(key);
			if (object instanceof JSONObject) {
				lookup(path+key+"/", key, index, current, (JSONObject) object);
			} else if (object instanceof JSONArray) {
				JSONArray arr = (JSONArray) object;
				//serviceArray(k, object, (JSONArray) child);
			}
			index++;
		}
	}

	private static String getJsonFromFile(String fileName) {
		try {
			URL url = Resources.getResource(fileName);
			return Resources.toString(url, Charsets.UTF_8);
		} catch (IOException e) {
			throw new AssertionError("No filename: " + fileName, e);
		}
	}
}
