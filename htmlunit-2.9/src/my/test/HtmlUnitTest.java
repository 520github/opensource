package my.test;

import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class HtmlUnitTest {
	 public static void testHomePage() throws Exception {   
		 // �½�һ��WebClient���󣬴˶����൱�������   
	        WebClient webClient=new WebClient();   
	        // ����һ��URL,ָ����Ҫ���Ե�URL����http://www.iteye.com      
	        URL url=new URL("http://topic.csdn.net/u/20120508/14/5b28f49e-d7c7-421a-a7e3-255794137c75.html");   
	         // ͨ��getPage()������������Ӧ��ҳ��   
	        HtmlPage page = webClient.getPage(url);   
	        String title = page.getTitleText();
	        String content = page.getTextContent();
	        System.out.println("title:" + title);
	        System.out.println("content:" + content);
	        //System.out.println("sss"+page.getTitleText());  
	 }
	 
	 public static void main(String[] args) {
		try {
			HtmlUnitTest.testHomePage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
