package xian.zhongliang.dengjumin.utils;

import java.time.format.DateTimeFormatter;

public class Constant {

    public static String DATE_FORMATTER = "yyyy-MM-dd HH:mm";

    public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    public static String AUTHORIZATION_CODE = "authorization_code";

    public static String GET_OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public static String APP_ID = "wxc22a21db169d83b7";

    public static String APP_SECRET = "f52dc18d7ad41a1087fa765a679abb1f";



}
