package org.archive.modules.writer.boat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.io.IOUtils;

public class Record {
	HttpResponseBody body;
	Date date;
	String digest;
	int length;
	String url;
	String via;

	Record() {
	}

	Record setDigest(String digest) {
		this.digest = digest;
		return this;
	}

	public HttpResponseBody getBody() {
		return body;
	}

	public Date getDate() {
		return date;
	}

	public String getDigest() {
		return digest;
	}

	public int getLength() {
		return length;
	}

	public String getUrl() {
		return url;
	}

	public String getVia() {
		return this.via;
	}

	public int writeTo(OutputStream out) throws IOException {
		ByteArrayOutputStream headerBuffer = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(headerBuffer);
		writer.println(url);
		writer.println("Length: " + length);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		writer.println("Date: " + simpleDateFormat.format(this.date));
		writer.println("Via: " + this.via);
		writer.println();
		writer.close();

		byte[] header = headerBuffer.toByteArray();
		out.write(header);

		InputStream in = body.getInputStream();
		try {
			return IOUtils.copy(in, out) + header.length;
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
}