package com.company.crawl;

import org.junit.Before;
import org.junit.Test;

public class CrawlerTest
{
   private Crawler crawler;

   @Before
   public void setUp() {
      crawler = new Crawler();
   }

   @Test
   public void shouldCrawlGivenUrl()
   {
      crawler.crawl("https://google.co.uk");
   }
}