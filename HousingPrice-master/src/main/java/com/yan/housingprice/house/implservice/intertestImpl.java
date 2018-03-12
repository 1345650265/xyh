package com.yan.housingprice.house.implservice;

import com.yan.housingprice.house.interservice.intertest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class intertestImpl implements intertest {
    @Override
    public Map<String, Integer> returnhouseprice() throws IOException {
        Map<String, Integer> houseInfo=new HashMap<>();
        for(int i=1;i<2;i++){
            String url="http://nc.milike.com/estate/-pn-"+i+"-ps-15.htm";
            Document doc = Jsoup.connect(url).get();
            Element masthead = doc.select("div.leftcnt").first();
            System.out.println("----第"+i+"页----");
            for(Element e:masthead.children()){
                if(!e.className().equals("buildbox")){
                    continue;
                }
                String houseName=e.select("a.b-title").html();
                String housePrice=e.select("span.b-price").html();
                if (housePrice.equals("售价待定")){
                    houseInfo.put(houseName,0);
                }
                else {
                    int price = Integer.parseInt(housePrice = housePrice.substring(0, housePrice.length() - 3));
                    System.out.println(houseName);
                    System.out.println(price);
                    houseInfo.put(houseName, price);
                }
            }
        }
        return houseInfo;
    }
}
