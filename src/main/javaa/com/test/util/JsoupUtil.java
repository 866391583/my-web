package com.test.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date Created at:2016年4月23日上午10:46:11
 */
class MyX509TrustManager implements X509TrustManager {

	/*
	 * The default X509TrustManager returned by SunX509. We’ll delegate
	 * decisions to it, and fall back to the logic in this class if the default
	 * X509TrustManager doesn’t trust it.
	 */
	X509TrustManager sunJSSEX509TrustManager;

MyX509TrustManager() throws Exception {
// create a “default” JSSE X509TrustManager.

KeyStore ks = KeyStore.getInstance("JKS");
ks.load(new FileInputStream("E:/Program Files/Java/jre7/lib/security/cacerts"),
"passphrase".toCharArray());

TrustManagerFactory tmf =
TrustManagerFactory.getInstance("SunX509", "SunJSSE");

tmf.init(ks);

TrustManager tms [] = tmf.getTrustManagers();

/*
* Iterate over the returned trustmanagers, look
* for an instance of X509TrustManager.  If found,
* use that as our “default” trust manager.
*/
for (int i = 0; i < tms.length; i++) {
if (tms[i] instanceof X509TrustManager) {
sunJSSEX509TrustManager = (X509TrustManager) tms[i];
return;
}
}

/*
* Find some other way to initialize, or else we have to fail the
* constructor.
*/
}

	/*
	 * Delegate to the default trust manager.
	 */
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		try {
			sunJSSEX509TrustManager.checkClientTrusted(chain, authType);
		} catch (CertificateException excep) {
			// do any special handling here, or rethrow exception.
		}
	}

	/*
	 * Delegate to the default trust manager.
	 */
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		try {
			sunJSSEX509TrustManager.checkServerTrusted(chain, authType);
		} catch (CertificateException excep) {
			/*
			 * Possibly pop up a dialog box asking whether to trust the cert
			 * chain.
			 */
		}
	}

	/*
	 * Merely pass this through.
	 */
	public X509Certificate[] getAcceptedIssuers() {
		return sunJSSEX509TrustManager.getAcceptedIssuers();
	}
}

public class JsoupUtil {

	public static String getTitleFromUrl(String url) {
		boolean isHttp = true;
		if (url.startsWith("https"))
			isHttp = false;
		InputStream inputStream = null;
		String html = "";
		String tmp = "";
		try {
			URL urlObj = new URL(url);
			if (isHttp) {
				inputStream = urlObj.openConnection().getInputStream();

			} else {
				TrustManager[] tm = { new MyX509TrustManager() };
				SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

				sslContext.init(null, tm, new java.security.SecureRandom());

				SSLSocketFactory ssf = sslContext.getSocketFactory();
				HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
				connection.setSSLSocketFactory(ssf);
				inputStream = connection.getInputStream();

			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			while ((tmp = reader.readLine()) != null) {
				html += tmp;
			}
			Document document = Jsoup.parse(html);
			Element title = document.select("title").first();

			if (title != null)
				return title.text();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
