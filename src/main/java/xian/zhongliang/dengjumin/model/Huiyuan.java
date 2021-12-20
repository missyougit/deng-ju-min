package xian.zhongliang.dengjumin.model;


public class Huiyuan {

    private int id;
    private String name;
    private int gender;
    private int age;
    private String birthday;
    private String phone;
    private int yuangongid;
    private String entrytime;
    private Yuangong yuangong;
    private String remarks;
    private String zhiye;
    private String openId;
    private String address;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZhiye() {
        return zhiye;
    }

    public void setZhiye(String zhiye) {
        this.zhiye = zhiye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYuangongid() {
        return yuangongid;
    }

    public void setYuangongid(int yuangongid) {
        this.yuangongid = yuangongid;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public Yuangong getYuangong() {
        return yuangong;
    }

    public void setYuangong(Yuangong yuangong) {
        this.yuangong = yuangong;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
