package hello.baidu.ai.demo;

import hello.baidu.ai.utils.AuthService;
import hello.baidu.ai.utils.HttpUtil;

/**
* 网络图片文字识别
*/
public class WebImage {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,hello.baidu.ai.utils.Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String webImage(String imageUrl) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";
        try {
            // 本地文件路径
            String filePath = "[本地文件路径]";
            String paramUrlPrefix = "url=";

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();


            String result = HttpUtil.post(url, accessToken, paramUrlPrefix +imageUrl);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

       String  imageUrl = "url=http://www.lixia.gov.cn/picture/0/8cc032676a924e63a9407595adb34845.jpg";
        WebImage.webImage(imageUrl);
    }
}