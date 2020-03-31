package com.net;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Net {
    public static String sendGetRequest(String url, String params) {
        StringBuilder result = new StringBuilder();
        String realUrl = url + "?" + params;
        InputStream in = null;
        BufferedReader br = null;
        try {

            URL u = new URL(realUrl);
            URLConnection conn = u.openConnection();
            conn.setRequestProperty("accept", "/*");
            conn.setRequestProperty("connection", "keep-alive");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String key = it.next();
                System.out.println(key + ":::" + map.get(key));
            }
            //获取响应数据
            in = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
//            抓取到了网页源码
//            null:::[HTTP/1.1 200 OK]
//            Server:::[bfe]
//            Content-Length:::[2443]
//            Date:::[Wed, 11 Mar 2020 07:18:15 GMT]
//            Content-Type:::[text/html]
//         <!DOCTYPE html><!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;
//            charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><
//            link rel=stylesheet
//            type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>
//            // 百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper>
//            // <div class=s_form> <div class=s_form_wrapper> <div id=lg>
//            // <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129>
//            // </div> <form id=form name=f action=//www.baidu.com/s class=fm>
//            // <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8>
//            // <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1>
//            // <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu>
//            // <span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus>
//            // </span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span>
//            // </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻
//            // </a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com nam

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }

    //post请求案例:发送post请求,参数单独发到服务器
    public static String sendPostRequest(String url, String params) {
        StringBuilder result = new StringBuilder();
        String realUrl = null;
        InputStream in = null;
        BufferedReader br = null;
        try {
            //与服务器创建连接
            URL u = new URL(realUrl);
            URLConnection conn = u.openConnection();
            conn.setRequestProperty("accept", "/*");
            conn.setRequestProperty("connection", "keep-alive");
            //post请求必须设置请求头
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();
            //发送参数到服务器
            OutputStream out = conn.getOutputStream();

            PrintStream pw = new PrintStream(String.valueOf(new OutputStreamWriter(out, "utf-8")));
            pw.print(params);
            pw.flush();
            pw.close();
            //获取响应头

            Map<String, List<String>> map = conn.getHeaderFields();
            Set<Map.Entry<String, List<String>>> entry = map.entrySet();
            Iterator<Map.Entry<String, List<String>>> it = entry.iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<String>> en = it.next();
                System.out.println(en.getKey() + "::::" + en.getValue());
            }
            //获取响应头数据
            in = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException E) {
                    E.printStackTrace();
                }
            }
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }

        return realUrl;
    }

    public static void main(String[] args) {


        String url = "https://www.baidu.com/";
        String params = "tname=employee";
        // 测试get请求
//        System.out.println(Net.sendGetRequest(url, params));
        // 测试post请求
        System.out.println(Net.sendPostRequest(url, params));
//报异常
    }
}
