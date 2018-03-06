package shiro.helper;

/**
 * Created by sunjx on 2018/3/4.
 */
public class StringHelper {

    /**
     * 将多个字符串以token为间隔组合起来
     */
    public static String mergeStringArray(String[] strings, String token){
        StringBuffer sb = new StringBuffer();

        for (String s : strings){
            sb.append(s).append(token);
        }

        return sb.toString().substring(0,sb.length()-1);
    }


}
