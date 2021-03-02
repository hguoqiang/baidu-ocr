package hello.baidu.ai.demo2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlParse {

	// 获取的http页面
	// 提取数据存到excel
	// 只第一页调用这个方法
	public void parseHtmlToExcel(String html) {

		Document doc = Jsoup.parse(html);

		Element table = doc.getElementsByClass("hq_table").first();

		Element tbody = table.children().first();

		Elements trs = tbody.children();// 所有的 tr，第一个tr是表头，每个tr
										// 里面有八个td,最后一个td没有用

		for (int x = 0; x < trs.size(); x++) { // 遍历每一行，取前七个子元素td

			Element element = trs.get(x); // 得到每一行是tr，
			// 得到前七个td的文本内容
			String td1 = element.child(0).text();// 名字
			String td2 = element.child(1).text();// 最低价
			String td3 = element.child(2).text();// 平均价
			String td4 = element.child(3).text();// 最高价
			String td5 = element.child(4).text();// 规格类型
			String td6 = element.child(5).text();// 计量单位
			String td7 = element.child(6).text();// 发布时间

			String[] rowData = { td1, td2, td3, td4, td5, td6, td7 };
			// 插入一行数据

		}

	}


	

}