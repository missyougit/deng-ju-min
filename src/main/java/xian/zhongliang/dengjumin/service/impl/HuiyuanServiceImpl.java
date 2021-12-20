package xian.zhongliang.dengjumin.service.impl;


import org.springframework.stereotype.Service;
import xian.zhongliang.dengjumin.mapper.HuiyuanMapper;
import xian.zhongliang.dengjumin.mapper.YuangongMapper;
import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Huiyuan;
import xian.zhongliang.dengjumin.model.HuiyuanResponse;
import xian.zhongliang.dengjumin.model.Yuangong;
import xian.zhongliang.dengjumin.service.HuiyuanService;
import xian.zhongliang.dengjumin.utils.Constant;
import xian.zhongliang.dengjumin.utils.DateUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HuiyuanServiceImpl implements HuiyuanService {

    @Resource
    private HuiyuanMapper huiyuanMapper;
    @Resource
    private YuangongMapper yuangongMapper;

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanById(int huiyuanid) {

        Huiyuan huiyuan = huiyuanMapper.getHuiyuanById(huiyuanid);
        if (huiyuan == null){
            return new CommonResponse<>(400,"无效的会员号",null);
        }
        int yuangongid = huiyuan.getYuangongid();

        Yuangong yuangong = yuangongMapper.getYuangongById(yuangongid);

        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        if (yuangong == null){
            huiyuanResponse.setHuiyuan(huiyuan);
            return new CommonResponse<>(206,"Warning",huiyuanResponse);
        }

        huiyuan.setYuangong(yuangong);
        huiyuanResponse.setHuiyuan(huiyuan);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(int yuangongid,int pageNo,int pageSize) {

        int offset = (pageNo - 1) * pageSize;
        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanByYuangongid(yuangongid,offset,pageSize);
        if (huiyuanList.isEmpty()){
            return new CommonResponse<>(400,"您还没有会员",null);
        }
        Yuangong yuangong = yuangongMapper.getYuangongById(yuangongid);

        for (Huiyuan huiyuan : huiyuanList) {
            huiyuan.setYuangong(yuangong);
        }
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);
        int huiyuanTotal = huiyuanMapper.getHuiyuanTotalByYuangongid(yuangongid);
        huiyuanResponse.setTotal(huiyuanTotal);
        Integer pageCount;

        if (huiyuanTotal % pageSize == 0){
            pageCount = huiyuanTotal / pageSize;
        }else {
            pageCount = (int)Math.ceil((double)huiyuanTotal / (double)pageSize);
        }

        huiyuanResponse.setPageCount(pageCount);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> addHuiyuan(Huiyuan huiyuan) {

        int age = DateUtils.getAge(huiyuan.getBirthday());
        huiyuan.setAge(age);
        LocalDateTime currentTime = LocalDateTime.now();
        String entrytime = currentTime.format(Constant.DATE_TIME_FORMATTER);
        huiyuan.setEntrytime(entrytime);
        int i = huiyuanMapper.addHuiyuan(huiyuan);
        if (i < 1){
            return new CommonResponse<>(500,"添加失败",null);
        }
        return new CommonResponse<>(200,"Success",null);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(int yuangongid) {

        int huiyuanTotal = huiyuanMapper.getHuiyuanTotalByYuangongid(yuangongid);
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setTotal(huiyuanTotal);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(int yuangongid, String searchText) {

        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanBySearchText(yuangongid,searchText);

        if (huiyuanList.isEmpty()){
            return new CommonResponse<>(400,"查无此人",null);
        }

        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);

        return new CommonResponse<>(200,"Success",huiyuanResponse);
    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanByOpenId(String openId, int pageNo, int pageSize) {

        int offset = (pageNo - 1) * pageSize;
        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanByOpenId(openId,offset,pageSize);
        if (huiyuanList.isEmpty()){
            return new CommonResponse<>(400,"您还没有会员",null);
        }
        Yuangong yuangong = yuangongMapper.getYuangongByOpenId(openId);
        for (Huiyuan huiyuan : huiyuanList) {
            huiyuan.setYuangong(yuangong);
        }
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);
        int huiyuanTotal = huiyuanMapper.getHuiyuanTotalByOpenId(openId);
        huiyuanResponse.setTotal(huiyuanTotal);
        Integer pageCount;
        if (huiyuanTotal % pageSize == 0){
            pageCount = huiyuanTotal / pageSize;
        }else {
            pageCount = (int)Math.ceil((double)huiyuanTotal / (double)pageSize);
        }
        huiyuanResponse.setPageCount(pageCount);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanByOpenIdAndSearchText(String openId, String searchText) {

        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanByOpenIdAndSearchText(openId,searchText);
        if (huiyuanList.isEmpty()){
            return new CommonResponse<>(400,"查无此人",null);
        }
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }


}
