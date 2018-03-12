package com.yan.housingprice.house.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Tag;

import java.io.File;
import java.io.IOException;

public class pa {
    public static void main(String args[]) throws IOException {
        File input = new File("C:\\KDR\\a.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        Element link = doc.select("a").first();
        int a=link.childNodeSize();
        System.out.println(a);
        System.out.println(link.childNode(0));
        String absHref = link.attr("abs:href");
        System.out.println(link.html());
        link.html("23");
        System.out.println(link.html());
        System.out.println(absHref);
    }
}
