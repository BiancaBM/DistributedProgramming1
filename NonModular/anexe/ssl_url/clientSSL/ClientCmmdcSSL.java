import java.io.File;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.client.utils.URIBuilder;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.NameValuePair; 
import org.apache.http.message.BasicNameValuePair;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.net.URI;

public class ClientCmmdcSSL{
  public final static void main(String[] args) throws Exception {
    SSLContext sslcontext = SSLContexts.custom()
      .loadTrustMaterial(new File("tomcatKeystore.jks"), "1q2w3e".toCharArray(),
             new TrustSelfSignedStrategy())
      .build();
    // Allow TLSv1 protocol only
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
      sslcontext,
      new String[] { "TLSv1" },
      null,
      SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      //SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    CloseableHttpClient httpclient = HttpClients.custom()
            .setSSLSocketFactory(sslsf)
            .build();
    
    try{  
      Scanner scanner=new Scanner(System.in);
      System.out.println("m=");
      String m=scanner.nextLine().trim();
      System.out.println("n=");
      String n=scanner.nextLine().trim();
      List<NameValuePair> qparams = new ArrayList<NameValuePair>();
      qparams.add(new BasicNameValuePair("m", m));
      qparams.add(new BasicNameValuePair("n", n));
      qparams.add(new BasicNameValuePair("tip", "text/plain"));
      URI uri=new URIBuilder("https://localhost:8443/myservlet/cmmdc")
        .addParameters(qparams)
        .build();
      HttpGet httpget = new HttpGet(uri);
      
      System.out.println("executing request" + httpget.getRequestLine());

      HttpResponse response = httpclient.execute(httpget);
      HttpEntity entity = response.getEntity();

      System.out.println("----------------------------------------");
      System.out.println(response.getStatusLine());
      if (entity != null) {
				InputStream is=entity.getContent();
				int l;
				byte[] tmp=new byte[2048];
				while((l=is.read(tmp))!=-1){}
				System.out.println("Cmmdc = "+(new String(tmp).trim()));
			}		
    } 
    finally {
      // When HttpClient instance is no longer needed,
      // shut down the connection manager to ensure
      // immediate deallocation of all system resources
      httpclient.close();
    }
  }
}
