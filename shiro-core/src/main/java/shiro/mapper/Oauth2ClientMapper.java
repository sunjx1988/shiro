package shiro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import shiro.entity.Oauth2Client;
import shiro.entity.Oauth2ClientExample;

public interface Oauth2ClientMapper {
    int countByExample(Oauth2ClientExample example);

    int deleteByExample(Oauth2ClientExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Oauth2Client record);

    int insertSelective(Oauth2Client record);

    List<Oauth2Client> selectByExample(Oauth2ClientExample example);

    Oauth2Client selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Oauth2Client record, @Param("example") Oauth2ClientExample example);

    int updateByExample(@Param("record") Oauth2Client record, @Param("example") Oauth2ClientExample example);

    int updateByPrimaryKeySelective(Oauth2Client record);

    int updateByPrimaryKey(Oauth2Client record);
}