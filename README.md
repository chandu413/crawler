# Crawler
Web page crawler.

Lists the links by category:

* same domain (internal)
* external
* images
* imports

### Run
Copy the source. 

Run the command.

`mvn clean install`

`cd target`

`java -jar crawler-0.0.1-SNAPSHOT-shaded.jar`

The logs should show the stats for the url as below:

```
com.company.crawl.Crawler - Crawling start= https://wiprodigital.com
com.company.crawl.WebPageDownloader - Executing request GET https://wiprodigital.com/
com.company.crawl.Crawler - Crawled info for url= https://wiprodigital.com
com.company.crawl.Crawler - internal: 45
com.company.crawl.Crawler - external: 4
com.company.crawl.Crawler - images: 3
com.company.crawl.Crawler - imports: 9
.
.
.
com.company.crawl.Crawler - Crawling start= https://wiprodigital.com/join-our-team
com.company.crawl.WebPageDownloader - Executing request GET https://wiprodigital.com/join-our-team
com.company.crawl.Crawler - Crawled info for url= https://wiprodigital.com/join-our-team
com.company.crawl.Crawler - internal: 6
com.company.crawl.Crawler - external: 33
com.company.crawl.Crawler - images: 3
com.company.crawl.Crawler - imports: 9
.
.
.
```

### Next steps / Enhancements
* More tests / negative paths
* Use interfaces and make more modular classes 
* Parallel threads for crawling multiple sites
