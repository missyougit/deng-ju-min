package xian.zhongliang.dengjumin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xian.zhongliang.dengjumin.model.Yuangong;


@Mapper
public interface YuangongMapper {

    @Select("select * from yuangong where id=#{id}")
    Yuangong getYuangongById(int id);

    @Select("select * from yuangong where phone=#{phone}")
    Yuangong getYuangongByPhone(String phone);

    @Insert("insert into yuangong (password,phone) values (#{password},#{phone})")
    int register(Yuangong yuangong);

}
