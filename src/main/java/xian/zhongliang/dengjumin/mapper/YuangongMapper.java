package xian.zhongliang.dengjumin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xian.zhongliang.dengjumin.model.Yuangong;


@Mapper
public interface YuangongMapper {

    @Select("select * from yuangong where id=#{id}")
    Yuangong getYuangongById(int id);

    @Select("select * from yuangong where phone=#{phone}")
    Yuangong getYuangongByPhone(String phone);

    @Insert("insert into yuangong (password,phone) values (#{password},#{phone})")
    int register(Yuangong yuangong);

    @Select("select * from yuangong where openId=#{openId}")
    Yuangong wechatLogonByOpenId(String openId);

    @Insert("insert into yuangong (gender,openId,nickName,avatarUrl) values (#{gender},#{openId},#{nickName},#{avatarUrl})")
    int wechatLogon(Yuangong yuangong);

    @Update("update yuangong set gender=#{gender},nickName=#{nickName},avatarUrl=#{avatarUrl} where openId=#{openId}")
    int updateYuangongByOpenId(Yuangong yuangong);

    @Select("select * from yuangong where openId=#{openId}")
    Yuangong getYuangongByOpenId(String openId);
}
