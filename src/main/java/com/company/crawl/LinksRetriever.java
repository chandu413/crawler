package com.company.crawl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksRetriever
{
   private final Pattern hrefPattern = Pattern.compile("(?i)(?s)<\\s*?a.*?href=\"(.*?)\".*?>");
   private final Pattern imagesPattern = Pattern.compile("(?i)(?s)<img\\s.*?src=\"(.*?)\".*?>");
   private final Pattern importsPattern = Pattern.compile("(?i)(?s)<\\s*?link.*?href=\"(.*?)\".*?>");

   public Map<String, Set<String>> getPageLinks(String url, String htmlPage)
   {
      Map<String, Set<String>> linksMap = new HashMap<>();
      Set<String> hrefLinks = getLinksByType(htmlPage, hrefPattern);
      Set<String> internalLinks = new HashSet<>();
      Set<String> externalLinks = new HashSet<>();
      hrefLinks.forEach(link -> {
                           if (link.startsWith(url))
                           {
                              internalLinks.add(link);
                           } else
                           {
                              externalLinks.add(link);
                           }
                        }
      );
      linksMap.put("internal", internalLinks);
      linksMap.put("external", externalLinks);
      Set<String> imagesLinks = getLinksByType(htmlPage, imagesPattern);
      linksMap.put("images", imagesLinks);
      Set<String> importsLinks = getLinksByType(htmlPage, importsPattern);
      linksMap.put("imports", importsLinks);
      return linksMap;
   }

   private Set<String> getLinksByType(String htmlPage, Pattern pattern)
   {
      Matcher matcher = pattern.matcher(htmlPage);

      Set<String> links = new HashSet<>();
      while (matcher.find())
      {
         links.add(matcher.group(1));
      }
      return links;
   }
}
