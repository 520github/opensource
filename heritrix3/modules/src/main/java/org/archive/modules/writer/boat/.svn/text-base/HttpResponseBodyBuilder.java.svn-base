package org.archive.modules.writer.boat;

import java.io.IOException;
import java.io.InputStream;

import org.archive.modules.CrawlURI;

public class HttpResponseBodyBuilder {

	public HttpResponseBody build(final CrawlURI crawUri) {
		return new HttpResponseBody() {

			@Override
			public InputStream getInputStream() throws IOException {
				return crawUri.getRecorder().getReplayInputStream();
			}
		};
	}
}
