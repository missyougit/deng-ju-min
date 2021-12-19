package xian.zhongliang.dengjumin.model;

import java.util.List;

public class HuiyuanResponse {

    private List<Huiyuan> huiyuanList;
    private Huiyuan huiyuan;
    private Integer total;
    private Integer pageCount;

    public List<Huiyuan> getHuiyuanList() {
        return huiyuanList;
    }

    public void setHuiyuanList(List<Huiyuan> huiyuanList) {
        this.huiyuanList = huiyuanList;
    }

    public Huiyuan getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(Huiyuan huiyuan) {
        this.huiyuan = huiyuan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
