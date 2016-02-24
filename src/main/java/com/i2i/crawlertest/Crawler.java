/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2i.crawlertest;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringEscapeUtils;


public class Crawler extends WebCrawler {
    
    
@Override
public boolean shouldVisit(Page referringPage,WebURL url) {
    
     // Sadece günün fırsatına ait ürünleri kontrol etmeye devam ediyoruz.
     boolean a = url.getURL().startsWith("http://www.gittigidiyor.com/super-firsatlar/gunun-firsati");
    
     return a;
}



@Override
public void visit(Page page) {
     String url = page.getWebURL().getURL();
  
    try {
	Document document = Jsoup.connect(url).get();
	Elements titles = document.select("div");
        
        for (Element eleman : titles) {
                   
         if (eleman.className().equals("lp-title-content")) {
             
             System.out.println(eleman.html());
             
         }
        }
        

     }
     catch (IOException e) {
         e.printStackTrace();
    }
 }
}
