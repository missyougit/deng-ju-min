package xian.zhongliang.dengjumin.service;


import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Huiyuan;
import xian.zhongliang.dengjumin.model.HuiyuanResponse;

public interface HuiyuanService {

    CommonResponse<HuiyuanResponse> getHuiyuanById(int huiyuanid);

    CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(int yuangongid, int pageNo, int pageSize);

    CommonResponse<HuiyuanResponse> addHuiyuan(Huiyuan huiyuan);

    CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(int yuangongid);

    CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(int yuangongid, String searchText);
}
