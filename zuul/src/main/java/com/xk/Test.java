package com.xk;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Test {

    //获取服务器信息并写道txt中
    public static void main(String[] args) throws IOException {
        //信息源
        Properties properties = System.getProperties();
        //获取真实项目路径（'.../webapps' + '/images/testLog.txt'）
        String logRealPath = "D:/test.txt";
        //开启流
        OutputStream out=new FileOutputStream(logRealPath,true);
        //拿到系统信息
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        //打印到文件当中
        for(Map.Entry entry : entries) {
            out.write(entry.getKey().toString().getBytes("UTF-8"));
            out.write("-->".getBytes("UTF-8"));
            out.write(entry.getValue().toString().getBytes("UTF-8"));
            out.write("\n".getBytes("UTF-8"));
        }

        //关闭流
        out.close();
    }


}
