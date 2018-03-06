package shiro.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjx on 2018/3/4.
 */
public class EntityHelper {

    /**
     * 将由逗号割开的id组成的string，例如“1,2,3,” 转换为 Long 的集合 {1,2,3}
     */
    public static List<Long> idStringToList(String ids, String token){
        String[] arr = ids.split(token);
        List<Long> list = new ArrayList<>(arr.length);

        for (String s : arr){
            if(s.trim().equals("")){
                continue;
            }
            list.add(Long.valueOf(s));
        }

        return list;
    }

    /**
     * 将Long的集合转换为以逗号隔开的string, 例如{1,2,3} -> “1,2,3”
     */
    public static String idLongListToString(List<Long> list){
        StringBuffer sb = new StringBuffer();

        for (int i = 0 ; i < list.size() ; i ++){
            sb.append(list.get(0));

            if(i < list.size() - 1 ){
                sb.append(",");
            }
        }

        return sb.toString();
    }

}
