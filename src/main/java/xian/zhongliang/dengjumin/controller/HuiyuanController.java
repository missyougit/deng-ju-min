package xian.zhongliang.dengjumin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Huiyuan;
import xian.zhongliang.dengjumin.model.HuiyuanResponse;
import xian.zhongliang.dengjumin.service.HuiyuanService;


@RestController
@RequestMapping("huiyuan")
public class HuiyuanController {

    @Autowired
    private HuiyuanService huiyuanService;

//    @GetMapping("/wechat/{openId}")
//    public CommonResponse<HuiyuanResponse> getHuiyuanByOpenId(@PathVariable("openId")String openId, int pageNo, int pageSize){
//
//        return huiyuanService.getHuiyuanByOpenId(openId,pageNo,pageSize);
//    }
//
//    @GetMapping("/wechat/{openId}/search")
//    public CommonResponse<HuiyuanResponse> getHuiyuanByOpenIdAndSearchText(@PathVariable("openId")String openId, String searchText){
//
//        return huiyuanService.getHuiyuanByOpenIdAndSearchText(openId,searchText);
//    }


    @GetMapping("/{huiyuanid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanById(@PathVariable("huiyuanid")int huiyuanid){
        return huiyuanService.getHuiyuanById(huiyuanid);
    }

    @GetMapping("/by/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(@PathVariable("yuangongid")int yuangongid, int pageNo, int pageSize){

        return huiyuanService.getHuiyuanByYuangongid(yuangongid,pageNo,pageSize);
    }

    @PostMapping("/addHuiyuan")
    public CommonResponse<HuiyuanResponse> addHuiyuan(@RequestBody Huiyuan huiyuan){

        return huiyuanService.addHuiyuan(huiyuan);
    }

    @GetMapping("/getTotal/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(@PathVariable("yuangongid")int yuangongid){

        return huiyuanService.getHuiyuanTotalByYuangongid(yuangongid);
    }


    @GetMapping("/search/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(@PathVariable("yuangongid")int yuangongid, String searchText){

        return huiyuanService.getHuiyuanBySearchText(yuangongid,searchText);
    }

}
