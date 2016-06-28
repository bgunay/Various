package com.github.pnowy.various.watchService;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.12.13 21:29
 */
public class Demo
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Path path = Paths.get("D:\\Dropbox");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

		WatchKey watchKey;
		do
		{
			watchKey = watchService.take();
			for (final WatchEvent<?> event : watchKey.pollEvents())
			{
				System.out.println(event.kind() + ": " + event.context());
			}
		}
		while (watchKey.reset());
	}

}
