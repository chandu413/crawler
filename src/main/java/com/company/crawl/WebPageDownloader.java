package com.company.crawl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPageDownloader
{
   private final Logger log = LoggerFactory.getLogger(getClass().getName());

   public String downloadPage(String url)
   {
      try (final CloseableHttpClient httpclient = HttpClients.createDefault())
      {
         final HttpGet httpget = new HttpGet(url);

         log.info("Executing request {} {}", httpget.getMethod(), httpget.getUri());

         final HttpClientResponseHandler<String> responseHandler = response -> {
            final int status = response.getCode();
            if (status == HttpStatus.SC_SUCCESS)
            {
               final HttpEntity entity = response.getEntity();
               try
               {
                  return entity != null ? EntityUtils.toString(entity) : null;
               } catch (final ParseException ex)
               {
                  throw new ClientProtocolException(ex);
               }
            } else
            {
               log.warn("Invalid response code {} received while retreiving web page", status);
               return "";
            }
         };
         return httpclient.execute(httpget, responseHandler);
      } catch (IOException | URISyntaxException e)
      {
         log.error("Error while downloading the web page= {}", url, e);
      }
      return "";
   }
}
