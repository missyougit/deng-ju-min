package xian.zhongliang.dengjumin.service;


import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Yuangong;

public interface YuangongService {

    CommonResponse<Yuangong> getYuangongById(int id);

    CommonResponse<Yuangong> logon(Yuangong yuangong);

    CommonResponse<Yuangong> register(Yuangong yuangong);

    CommonResponse<Yuangong> wechatLogon(Yuangong yuangong);

    CommonResponse<Yuangong> wechatLogonByOpenId(String openId);
}
