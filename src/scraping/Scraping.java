/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraping;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Titan
 */
public class Scraping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        
      //betway();
      jumia();
      
       
    }

    public static void betway() {

        try {
            Document doc = Jsoup.connect("https://www.betway.co.ke/").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0").timeout(0).get();
            Elements links = doc.select("div.inplayStatusDetails");
            for (Element s : links) {
                Elements n = s.select("div.inplayStatusDetails > label.ellips ").eq(1);
                System.out.println(n.text());

            }
        } catch (IOException ex) {
            Logger.getLogger(Scraping.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void jumia(){
        
             try {
            Document doc = Jsoup.connect("https://www.jumia.co.ke/home-decor/").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0").timeout(0).get();
            Elements links = doc.select("div.sku");
            for (Element s : links) {
                Elements n = s.select("span.name");
                String name=n.text();               
                Elements p=s.select("span.price").eq(0);
                String price=p.text();
                
                 System.out.println(name+" "+price);
                 
                
                 

            }
        } catch (IOException ex) {
            Logger.getLogger(Scraping.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
