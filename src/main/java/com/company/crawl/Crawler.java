package com.company.crawl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawler
{
   private static final List<String> traversedLinks = new ArrayList<>();
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
      if (traversedLinks.contains(url))
      {
         return;
      }
      log.info("Crawling start= {}", url);

      String htmlPage = webPageDownloader.downloadPage(url);

      Map<String, Set<String>> pageLinksMap = linksRetriever.getPageLinks(url, htmlPage);

      traversedLinks.add(url);

      log.info("Crawled info for url= {}", url);
      pageLinksMap.forEach((key, value) -> log.info("{}: {}", key, value.size()));

      Set<String> internalLinks = pageLinksMap.get("internal");
      internalLinks.forEach(this::crawl);

      log.info("Crawling finish= {}", url);
   }
}
