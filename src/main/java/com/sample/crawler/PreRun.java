package com.sample.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class PreRun implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String Jijum = "동대문점";
        String URL_Qna = "http://www.beautymade.com/kor/contents.php?code=030501&search_target=wr_2&search_keyword="+Jijum;
        String URL_Review = "http://www.beautymade.com/kor/contents.php?code=040101&search_target=wr_2&search_keyword="+Jijum;

        Document doc = Jsoup.connect(URL_Review).get();
        Elements table = doc.body().select("#c_contents > table.write_top > tbody");
        Elements trs = table.select("tr");
        Elements tds = trs.select("td");
        String[] items = new String[] { "번호", "분류", "제목", "작성자", "작성일", "조회수"};

        System.out.println(tds.size());

        for(int i = 0; i < tds.size(); i++){
            if(i % 6 == 0){
                System.out.println("=========================");
            }
            System.out.println(tds.get(i) + " \t " + tds.get(i).text());
        }


    }

}
