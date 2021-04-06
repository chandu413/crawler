package com.company.crawl;

public class CrawlerRunner
{
   public static void main(String args[]) {
      Crawler crawler = new Crawler();
      crawler.crawl("https://google.co.uk");
   }
}
