package pl.jvsystem.java7.watchService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com> Date: 07.12.13 22:22
 */
public class WatchDirectoryDemo {

	public static void main(String[] args) {
		final Path path = Paths.get("D:\\Dropbox");
		WatchDirectory watch = new WatchDirectory();
		try {
			watch.watchDir(path);
		} catch (IOException | InterruptedException ignored) {

		}
	}
}
