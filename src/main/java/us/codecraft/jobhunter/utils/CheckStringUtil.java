package us.codecraft.jobhunter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiboo on 2017/3/22.
 */
public class CheckStringUtil {

    //抽取字符串中的邮箱
    public static String findEmail(String str){
        Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"); //使用正则表达式匹配
        Matcher m = p.matcher(str);
        while(m.find()){
            return m.group();
        }
        return "";
    }

//    public static void main(String args[]) {
//        String content = "weieo2093我饿哦osdfiedifoas.difijf@qq.com";
//        System.out.println(findEmail(content));
//    }


}
