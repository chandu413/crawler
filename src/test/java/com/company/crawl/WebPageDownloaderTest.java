package com.company.crawl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WebPageDownloaderTest
{

   private WebPageDownloader webPageDownloader;

   @Before
   public void setUp() {
      webPageDownloader = new WebPageDownloader();
   }

   @Test
   public void shouldReturnStringHtmlWebPageForValidURL() {
      String webPage = webPageDownloader.downloadPage("https://google.co.uk");
      assertTrue(webPage.startsWith("<!DOCTYPE html>"));
      assertTrue(webPage.endsWith("</html>"));
   }

   @Test
   public void shouldReturnEmptyStringForInvalidURL() {
      String webPage = webPageDownloader.downloadPage("abcd");
      assertTrue(webPage.isEmpty());
   }
}