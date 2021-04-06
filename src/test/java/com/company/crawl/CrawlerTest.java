package com.company.crawl;

import org.junit.Before;
import org.junit.Test;

public class CrawlerTest
{
   private Crawler crawler;
   private WebPageDownloader webPageDownloader;
   private LinksRetriever linksRetriever;

   @Before
   public void setUp() {
      webPageDownloader = new WebPageDownloader();
      linksRetriever = new LinksRetriever();
      crawler = new Crawler(webPageDownloader, linksRetriever);
   }

   @Test
   public void shouldCrawlGivenUrl()
   {
      crawler.crawl("https://wiprodigital.com");
   }
}