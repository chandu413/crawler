package com.company.crawl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawler
{
   private final Logger log = LoggerFactory.getLogger(getClass().getName());

   public void crawl(String url) {
      log.info("Crawling start= {}", url);

      log.info("Crawling finish= {}", url);
   }
}
