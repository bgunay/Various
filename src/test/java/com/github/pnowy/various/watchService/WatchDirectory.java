package com.github.pnowy.various.watchService;

import java.io.IOException;
import java.nio.file.*;

import static java.lang.System.out;
import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.12.13 22:18
 */
public class WatchDirectory
{

	/**
	 * This method used to register the path to be watched for file & folders
	 * notifications with the Watch Service.
	 *
	 * @param path which will be watched
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void watchDir(Path path) throws IOException, InterruptedException
	{
		/**
		 * 1. Creating a WatchService.
		 * 9. Closing the Watch Service.
		 */
		try (WatchService watchService = FileSystems.getDefault().newWatchService())
		{

			//2. Registering Objects with the Watch Service.
			path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
			/**
			 * 3. Waiting for the Incoming Events.
			 * start an infinite loop
			 */
			while (true)
			{

				/**
				 * 4.Getting a Watch Key.
				 * retrieve and remove the next watch key
				 */
				final WatchKey key = watchService.take();
//				final WatchKey key = watchService.poll(60, TimeUnit.SECONDS);

				// poll(): If no key is available, it returns immediately a null value.
				// poll(long, TimeUnit): If no key is available, it waits the specified time and tries again. If still no key is available, then it returns null. The time period is indicated as a long number, while the TimeUnit argument determines whether the specified time is minutes, seconds, milliseconds, or some other unit of time.
				// take():If no key is available, it waits until a key is queued or the infinite loop is stopped for any of several different reasons.

				/**
				 * 5. Retrieving Pending Events for a Key.
				 * get list of pending events for the watch key *
				 */
				for (WatchEvent<?> watchEvent : key.pollEvents())
				{

					/**
					 * 6. Retrieving the Event Type and Count.
					 * get the kind of event (create, modify, delete) *
					 */
					final WatchEvent.Kind<?> kind = watchEvent.kind();

					//handle OVERFLOW event
					if (kind == StandardWatchEventKinds.OVERFLOW)
					{
						continue;
					}

					/**
					 * 7. Retrieving the File Name Associated with an Event.
					 * get the filename for the event *
					 */
					final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
					final Path entry = watchEventPath.context();

					//print it out
					out.println(kind + " -> " + entry);
				}

				/**
				 * 8. Putting the Key Back in Ready State.
				 * reset the key
				 */
				key.reset();

				//exit loop if the key is not valid (if the directory was deleted, for example)
				if (!key.isValid())
				{
					break;
				}
			}
		}
	}
}
