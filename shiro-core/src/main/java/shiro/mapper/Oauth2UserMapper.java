package shiro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import shiro.entity.Oauth2User;
import shiro.entity.Oauth2UserExample;

public interface Oauth2UserMapper {
    int countByExample(Oauth2UserExample example);

    int deleteByExample(Oauth2UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Oauth2User record);

    int insertSelective(Oauth2User record);

    List<Oauth2User> selectByExample(Oauth2UserExample example);

    Oauth2User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Oauth2User record, @Param("example") Oauth2UserExample example);

    int updateByExample(@Param("record") Oauth2User record, @Param("example") Oauth2UserExample example);

    int updateByPrimaryKeySelective(Oauth2User record);

    int updateByPrimaryKey(Oauth2User record);
}