package com.itany.utils;


import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    public static String doGet(String url, Map<String,String> params){

        String result ="";

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;


        try{
            URIBuilder builder = new URIBuilder(url);
            if(null != params){
                for(Map.Entry<String,String> param:params.entrySet()){
                    String key = param.getKey();
                    String value = param.getValue();
                    builder.addParameter( key,value);
                }
            }

            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            response = client.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
        }catch (Exception e){
            e.printStackTrace();
        }


        return result;
    }

    public static String doGet(String url){
        return doGet(url,null);
    }


    public static String doPost(String url,Map<String,String> params){

        String result = "";

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost post = new HttpPost(url);

        try {
            if(null != params){
                List<NameValuePair> paramList = new ArrayList<>();

                for(Map.Entry<String,String> param:params.entrySet()){
                    paramList.add(new BasicNameValuePair(param.getKey(),param.getValue()));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList,Charset.defaultCharset());
                post.setEntity(formEntity);
            }
            response = client.execute(post);
            result = EntityUtils.toString(response.getEntity(),Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client,response);
        }

        return result;
    }

    public static String doPost(String url){
        return doPost(url,null);
    }

    public static void close(CloseableHttpClient client,CloseableHttpResponse response){
        if(null != response){
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(null != client){
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
