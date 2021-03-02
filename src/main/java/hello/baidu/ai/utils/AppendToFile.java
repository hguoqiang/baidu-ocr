package hello.baidu.ai.utils;

import java.io.*;

public class AppendToFile {

    //获取对应操作系统的换行符
    private final static String EOL = System.getProperty("line.separator");

    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数  
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。  
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //按行写文件，将list中的字符串，按行写入file_name文件中
    public static void writeForLine( String fileName, String content) {

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(fileName,true));

            //writer.write(content + EOL);//按行写文件，后面追加行分隔符EOL
            writer.write(content );
            writer.newLine();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        String fileName = "C:/temp/newTemp.txt";
        String content = "new append!";
        //按方法A追加文件  
        AppendToFile.appendMethodA(fileName, content);
        AppendToFile.appendMethodA(fileName, "append end. \n");
        //显示文件内容  
        ReadFromFile.readFileByLines(fileName);
        //按方法B追加文件  
        AppendToFile.appendMethodB(fileName, content);
        AppendToFile.appendMethodB(fileName, "append end. \n");
        //显示文件内容  
        ReadFromFile.readFileByLines(fileName);
    }
}