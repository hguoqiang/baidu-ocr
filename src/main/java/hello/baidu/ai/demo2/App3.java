package hello.baidu.ai.demo2;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import hello.baidu.ai.demo.WebImage;
import hello.baidu.ai.utils.AppendToFile;
import hello.baidu.ai.utils.ReadFromFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class App3 {


    public static void main(String[] args) {

        String url = "http://www.lixia.gov.cn/art/2020/6/17/art_37116_4489015.html";


        List<String> imageUrls = new ArrayList<String>();
        //imageUrls = parHtml(imageUrls, url);

        imageUrls = ReadFromFile.readForLine(imageUrls, "C:\\Users\\hguoq\\Desktop\\xiaoxueurl2222.txt");

        for (String imageUrl : imageUrls) {
            String result = WebImage.webImage(imageUrl);

            JSONObject object = (JSONObject) JSONObject.parse(result);
            JSONArray words_results =(JSONArray)object.get("words_result");
          //  System.out.println(words_result);
            for (Object words_result : words_results) {
                JSONObject  word= (JSONObject)words_result;
                String text = (String)word.get("words");
                AppendToFile.writeForLine("C:\\Users\\hguoq\\Desktop\\xiaoxueurl_parse.txt", text);
            }
        }

    }


    public static List<String> parHtml(List<String> list, String url) {
        String paramUrlPrefix = "http://www.lixia.gov.cn";

        GetHtmlPage getHtmlPage = new GetHtmlPage();

        // 访问url，获取html
        String html = getHtmlPage.getHtml(url);

        //System.out.println(html);
        //解析并完成
        Document doc = Jsoup.parse(html);

        Element zoom = doc.getElementById("zoom");
        Elements elements = zoom.getElementsByAttributeValue("target", "_blank");


        for (Element element : elements) {
            String href = element.attr("href");
            //System.out.println(paramUrlPrefix +href);
            //list.add(paramUrlPrefix + href);
            AppendToFile.writeForLine("C:\\Users\\hguoq\\Desktop\\xiaoxueurl.txt", paramUrlPrefix + href);
        }

        return list;

    }


}