package com.github.pnowy.various.concurrency.forkjoin;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import com.github.pnowy.various.concurrency.threadexecutor.LinkHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * LinkFinderAction
 */
public class LinkFinderAction extends RecursiveAction {

	private String url;
	private LinkHandler linkHandler;
	/**
	 * Used for statistics
	 */
	private static final long t0 = System.nanoTime();

	public LinkFinderAction(String url, LinkHandler linkHandler) {
		this.url = url;
		this.linkHandler = linkHandler;
	}

	@Override
	public void compute() {
		if (!linkHandler.visited(url)) {
			try {
				List<RecursiveAction> actions = new ArrayList<>();
				URL uriLink = new URL(url);
				Parser parser = new Parser(uriLink.openConnection());
				NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));

				for (int i = 0; i < list.size(); i++) {
					LinkTag extracted = (LinkTag) list.elementAt(i);

					if (!extracted.extractLink().isEmpty()
							&& !linkHandler.visited(extracted.extractLink())) {

						actions.add(new LinkFinderAction(extracted.extractLink(), linkHandler));
					}
				}
				linkHandler.addVisited(url);

				if (linkHandler.size() == 1500) {
					System.out.println("Time for visit 1500 distinct links= " + (System.nanoTime() - t0));
				}

				//invoke recursively
				invokeAll(actions);
			} catch (Exception e) {
				//ignore 404, unknown protocol or other server errors
			}
		}
	}

}
