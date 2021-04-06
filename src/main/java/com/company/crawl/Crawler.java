package com.company.crawl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawler
{
   private final Logger log = LoggerFactory.getLogger(getClass().getName());

   private final WebPageDownloader webPageDownloader;

   public Crawler(WebPageDownloader webPageDownloader)
   {
      this.webPageDownloader = webPageDownloader;
   }

   public void crawl(String url)
   {
      log.info("Crawling start= {}", url);

      String htmlPage = webPageDownloader.downloadPage(url);
      log.debug("htmlPage= {}", htmlPage);

      log.info("Crawling finish= {}", url);
   }
}
