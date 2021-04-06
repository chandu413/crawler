package com.company.crawl;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawler
{
   private final Logger log = LoggerFactory.getLogger(getClass().getName());

   private final WebPageDownloader webPageDownloader;
   private final LinksRetriever linksRetriever;

   public Crawler(WebPageDownloader webPageDownloader, LinksRetriever linksRetriever)
   {
      this.webPageDownloader = webPageDownloader;
      this.linksRetriever = linksRetriever;
   }

   public void crawl(String url)
   {
      log.info("Crawling start= {}", url);

      String htmlPage = webPageDownloader.downloadPage(url);
      log.trace("htmlPage= {}", htmlPage);

      Map<String, Set<String>> pageLinksMap = linksRetriever.getPageLinks(url, htmlPage);
      pageLinksMap.entrySet().forEach(listEntry -> log.info("{}: {}", listEntry.getKey(), listEntry.getValue().size()));

      log.info("Crawling finish= {}", url);
   }
}
