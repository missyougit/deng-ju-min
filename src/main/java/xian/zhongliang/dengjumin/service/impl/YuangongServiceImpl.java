package xian.zhongliang.dengjumin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xian.zhongliang.dengjumin.mapper.YuangongMapper;
import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.OpenidAndSessionKey;
import xian.zhongliang.dengjumin.model.Yuangong;
import xian.zhongliang.dengjumin.service.YuangongService;
import xian.zhongliang.dengjumin.utils.Constant;

import javax.annotation.Resource;

@Service
public class YuangongServiceImpl implements YuangongService {


    @Autowired
    private RestTemplate restTemplate;
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

    @Override
    public CommonResponse<Yuangong> wechatLogon(Yuangong yuangong) {

        String code = yuangong.getCode();
        String url = new StringBuilder()
                .append(Constant.GET_OPEN_ID_URL)
                .append("?appid=")
                .append(Constant.APP_ID)
                .append("&secret=")
                .append(Constant.APP_SECRET)
                .append("&js_code=")
                .append(code)
                .append("&grant_type=")
                .append(Constant.AUTHORIZATION_CODE)
                .toString();
        OpenidAndSessionKey openidAndSessionKey = restTemplate.getForObject(url, OpenidAndSessionKey.class);
        if (openidAndSessionKey == null){
            return new CommonResponse<>(400,"登录失败",null);
        }
        String openid = openidAndSessionKey.getOpenid();

        Yuangong yg = yuangongMapper.wechatLogonByOpenId(openid);
        yuangong.setOpenId(openid);
        if (yg == null){

            int i = yuangongMapper.wechatLogon(yuangong);
            if (i < 1){
                return new CommonResponse<>(400,"登录失败",null);
            }
            return new CommonResponse<>(200,"Success",yuangong);
        }else {
            int j = yuangongMapper.updateYuangongByOpenId(yuangong);

            if (j < 0){
                return new CommonResponse<>(400,"登录失败",null);
            }
            return new CommonResponse<>(200,"Success",yuangong);

        }


    }

    @Override
    public CommonResponse<Yuangong> wechatLogonByOpenId(String openId) {

        Yuangong yuangong = yuangongMapper.wechatLogonByOpenId(openId);
        if (yuangong == null){
            yuangong = new Yuangong();
            yuangong.setOpenId(openId);
            int i = yuangongMapper.wechatLogon(yuangong);
            if (i < 1){
                return new CommonResponse<>(400,"登录失败",null);
            }
            return new CommonResponse<>(200,"Success",yuangong);
        }
        return new CommonResponse<>(200,"Success",null);

    }


}
