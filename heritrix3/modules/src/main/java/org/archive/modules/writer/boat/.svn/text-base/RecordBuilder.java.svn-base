package org.archive.modules.writer.boat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class RecordBuilder {
	public static void main(String[] args) throws IOException {
		Record b = new RecordBuilder()
				.setBody(new HttpResponseBody() {

					@Override
					public InputStream getInputStream() throws IOException {
						return new FileInputStream("/home/leon/t.dat");
					}
				})
				.setLength(72)
				.setDate(new Date())
				.setUrl("http://www.nowebsite.com/t.dat")
				.setVia("http://www.shanhubay.com")
				.build();

		b.writeTo(System.out);

		b = new RecordBuilder()
				.setBody(new HttpResponseBody() {

					@Override
					public InputStream getInputStream() throws IOException {
						return new FileInputStream("/home/leon/t.dat");
					}
				})
				.setLength(72)
				.setDate(new Date())
				.setUrl("http://www.nowebsite.com/x.dat")
				.setVia("http://www.shanhubay.com")
				.build();
		b.writeTo(System.out);

	}

	private Record record = new Record();

	public Record build() {
		try {
			return record;
		} finally {
			this.record = null;
		}
	}

	public RecordBuilder setBody(HttpResponseBody body) {
		record.body = body;
		return this;
	}

	public RecordBuilder setDate(Date date) {
		record.date = date;
		return this;
	}

	public RecordBuilder setDigest(String digest) {
		record.digest = digest;
		return this;
	}

	public RecordBuilder setLength(int length) {
		record.length = length;
		return this;
	}

	public RecordBuilder setUrl(String url) {
		record.url = url;
		return this;
	}

	public RecordBuilder setVia(String via) {
		record.via = via;
		return this;
	}
}
