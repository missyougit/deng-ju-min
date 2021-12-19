package xian.zhongliang.dengjumin.service.impl;


import org.springframework.stereotype.Service;
import xian.zhongliang.dengjumin.mapper.YuangongMapper;
import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Yuangong;
import xian.zhongliang.dengjumin.service.YuangongService;

import javax.annotation.Resource;

@Service
public class YuangongServiceImpl implements YuangongService {

    @Resource
    private YuangongMapper yuangongMapper;

    @Override
    public CommonResponse<Yuangong> getYuangongById(int id) {
        Yuangong yuangong = yuangongMapper.getYuangongById(id);
        if (yuangong == null){
            return new CommonResponse<>(400, "无效的员工id",null);
        }

        return new CommonResponse<>(200,"Success",yuangong);
    }

    @Override
    public CommonResponse<Yuangong> logon(Yuangong yuangong){
        String phone = yuangong.getPhone();
        Yuangong staff = yuangongMapper.getYuangongByPhone(phone);

        if (staff == null){

            return new CommonResponse<>(400,"电话号码有误",null);

        }

        String password = staff.getPassword();
        String pwd = yuangong.getPassword();
        if (password.equals(pwd)){
            return new CommonResponse<>(200,"Success",staff);
        }
        return new CommonResponse<>(403,"密码错误",null);

    }

    @Override
    public CommonResponse<Yuangong> register(Yuangong yuangong) {

        String phone = yuangong.getPhone();
        Yuangong staff = yuangongMapper.getYuangongByPhone(phone);

        if (staff == null){

            int register = yuangongMapper.register(yuangong);

            if (register < 1){
                return new CommonResponse<>(500,"注册失败",null);
            }
            return new CommonResponse<>(200,"Success",null);

        }

        return new CommonResponse<>(400,"账号已存在",null);
    }

}
