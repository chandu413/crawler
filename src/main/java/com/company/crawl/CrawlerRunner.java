package com.company.crawl;

public class CrawlerRunner
{
   public static void main(String args[]) {
      Crawler crawler = new Crawler(new WebPageDownloader(), new LinksRetriever());
      crawler.crawl("https://wiprodigital.com");
   }
}
