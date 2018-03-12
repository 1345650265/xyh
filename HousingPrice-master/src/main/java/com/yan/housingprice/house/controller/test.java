package com.yan.housingprice.house.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        for(int i=1;i<15;i++){
            String url="http://nc.milike.com/estate/-pn-"+i+"-ps-15.htm";
            Document doc = Jsoup.connect(url).get();
            Element masthead = doc.select("div.leftcnt").first();
            System.out.println("----第"+i+"页----");
            for(Element e:masthead.children()){
                if(!e.className().equals("buildbox")){
                    continue;
                }
                System.out.println(e.select("a.b-title").html()+"::"+e.select("span.b-price").html());
            }
        }
    }
}
