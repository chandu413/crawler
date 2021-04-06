package com.company.crawl;

import org.junit.Before;
import org.junit.Test;

public class CrawlerTest
{
   private Crawler crawler;
   private WebPageDownloader webPageDownloader;

   @Before
   public void setUp() {
      webPageDownloader = new WebPageDownloader();
      crawler = new Crawler(webPageDownloader);
   }

   @Test
   public void shouldCrawlGivenUrl()
   {
      crawler.crawl("https://www.producthunt.com/");
   }
}