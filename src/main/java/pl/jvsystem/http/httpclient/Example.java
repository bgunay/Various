package pl.jvsystem.http.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

/**
 * Date: 20.09.13 09:08
 */
public class Example {

	private static final String STR_ANALYSIS_URL = "http://resjbdev01:18212/stranalysis/stra";

	public static void main(String[] args) throws IOException {

//		HttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost post = new HttpPost(STR_ANALYSIS_URL);
//		MultipartEntity entity = MultipartEntityBuilder.create().build();
//
//		File f = new File("C:\\Dropbox\\Query_Template.xlsx");
//		ByteArrayBody body = new ByteArrayBody(IOUtils.toByteArray(new FileInputStream(f)), f.getName());
//		entity.addPart("file",body);
//		entity.addPart("fileType", new StringBody("T", ContentType.DEFAULT_TEXT));
//
//		entity.addPart("user", new StringBody("power", ContentType.DEFAULT_TEXT));
//
//		entity.addPart("trackingId", new StringBody("116c", ContentType.DEFAULT_TEXT));
//		entity.addPart("Amel", new StringBody("X", ContentType.DEFAULT_TEXT));
//		entity.addPart("CSF1PO", new StringBody("11", ContentType.DEFAULT_TEXT));
//		entity.addPart("D13S317", new StringBody("8", ContentType.DEFAULT_TEXT));
//		entity.addPart("D16S539", new StringBody("11", ContentType.DEFAULT_TEXT));
//		entity.addPart("D5S818", new StringBody("9", ContentType.DEFAULT_TEXT));
//		entity.addPart("D7S820", new StringBody("8", ContentType.DEFAULT_TEXT));
//		entity.addPart("TH01", new StringBody("6", ContentType.DEFAULT_TEXT));
//		entity.addPart("TPOX", new StringBody("8", ContentType.DEFAULT_TEXT));
//		entity.addPart("vWA", new StringBody("18", ContentType.DEFAULT_TEXT));
//
//		post.setEntity(entity);
//
//
//		HttpResponse response = httpClient.execute(post);
//		File nf = new File("C:\\Dropbox\\response.xlsx");
//		IOUtils.copy(response.getEntity().getContent(), new FileOutputStream(nf));
//		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//		String line;
//		while((line = rd.readLine()) != null) {
//			System.out.println(line+"\n");
//		}

	}
}
