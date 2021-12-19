package xian.zhongliang.dengjumin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xian.zhongliang.dengjumin.model.CommonResponse;
import xian.zhongliang.dengjumin.model.Yuangong;
import xian.zhongliang.dengjumin.service.YuangongService;

@RestController
@RequestMapping("yuangong")
public class YuangongController {


    @Autowired
    private YuangongService yuangongService;

    @GetMapping("/{id}")
    public CommonResponse<Yuangong> getYuangongById(@PathVariable("id")int id){
        return yuangongService.getYuangongById(id);
    }

    @PostMapping("/logon")
    public CommonResponse<Yuangong> logon(@RequestBody Yuangong yuangong){

        return yuangongService.logon(yuangong);
    }

    @PostMapping("/register")
    public CommonResponse<Yuangong> register(@RequestBody Yuangong yuangong){

        return yuangongService.register(yuangong);
    }


}
