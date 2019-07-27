package com.chai.colin.util;

public class UrlHelper {
    public static String APP_ID;
    public static String BAIDU_URL;
    public static String BASE_URL;
    public static String BUGLY_ID;
    public static String CC_HOST = "https://codefly.cc/api/";
    public static String COMPANY;
    public static boolean IS_DEBUG = false;
    public static String MARQUEE_URL;
    public static String MENU_STATUS;
    public static String OFFICIAL_URL;
    public static String[] OGDF_URL;
    public static String PHP_COMPANY;
    public static String[] QP178_URL;
    public static String[] QP383_URL;
    public static String[] QP761_URL;
    public static String[] QP95_URL;
    public static String[] QP981_URL = {"https://api.981api1.com:7443/", "https://api.981api2.com:7443/", "https://api.981api3.com:7443/", "https://api.981api4.com:7443/", "https://api.981api5.com:7443/"};
    public static String[] QPBM_URL = {"https://api.bmwapi1.com:7443/", "https://api.bmwapi2.com:7443/", "https://api.bmwapi3.com:7443/", "https://api.bmwapi4.com:7443/", "https://api.bmwapi5.com:7443/"};
    public static String[] QPDY_URL;
    public static String[] QPKY_URL;
    public static String[] QPVG_URL;
    public static String[] QPXY_URL;
    public static String[] QPYJ_URL;
    public static String QQ_ID;
    public static String SHARE_NAME;
    public static String[] TYC_URL;
    public static String URL_AGENT;
    public static String URL_FIX;
    public static String URL_VIP = "https://beautygirl.cc/383/vip.html";
    public static boolean canControl;

    static {
        URL_AGENT = "https://beautygirl.cc/383/extension.html";
        URL_FIX = "https://beautygirl.cc/383/503.html";
        canControl = true;
        APP_ID = "wx11d0bd038af490b3";
        BUGLY_ID = "15b77575b7";
        QQ_ID = "1108476984";
        OFFICIAL_URL = "www.383.com";
        SHARE_NAME = "383.com";
        COMPANY = "383";
        PHP_COMPANY = "383";
        MENU_STATUS = "kaiyuan";
        MARQUEE_URL = "";
        BAIDU_URL = "https://www.baidu.com/";
        OGDF_URL = new String[]{"http://api.oggame1.com:7001/", "http://api.oggame2.com:7001/", "http://api.oggame3.com:7001/"};
        TYC_URL = new String[]{"http://api.tycgame1.com:7001/", "http://api.tycgame2.com:7001/", "http://api.tycgame3.com:7001/", "http://api.tycgame4.com:7001/", "http://api.tycgame5.com:7001/"};
        QP95_URL = new String[]{"https://api.95api95.com:7443/", "https://api.95api9595.com:7443/", "https://api.95game9595.com:7443/", "https://api.95game2345.com:7443/", "https://api.9595game5.com:7443/"};
        QPYJ_URL = new String[]{"http://api.yjgame1.com:7001/", "http://api.yjgame2.com:7001/", "http://api.yjgame3.com:7001/", "http://api.yjgame4.com:7001/", "http://api.yjgame5.com:7001/"};
        QP178_URL = new String[]{"http://api.178game01.com:7001/", "http://api.178game02.com:7001/", "http://api.178game03.com:7001/"};
        QP383_URL = new String[]{"https://api.383game7dg.com:8553/", "https://api.383game1xv.com:8553/", "https://api.383gameoi2.com:8553/", "https://api.383game824.com:8553/", "https://api.383game153.com:8553/", "https://api.383game101.com:8553/", "https://api.383game7a1.com:8553/", "https://api.383game102.com:8553/", "https://api.383game1x9.com:8553/", "https://api.383game491.com:8553/"};
        QP761_URL = new String[]{"http://api.761game1.com:7001/", "http://api.761game2.com:7001/", "http://api.761game3.com:7001/"};
        QPKY_URL = new String[]{"http://api.kgky1523.com:7001/", "http://api.kgky8392.com:7001/", "http://api.kgky8293.com:7001/", "http://api.kgky9237.com:7001/", "http://api.kgky2392.com:7001/", "http://api.kgky0239.com:7001/", "http://api.kgky9328.com:7001/", "http://api.kgky8372.com:7001/", "http://api.kgky7263.com:7001/", "http://api.kgky2373.com:7001/"};
        QPVG_URL = new String[]{"http://api.vggame1.com:7001/", "http://api.vggame2.com:7001/", "http://api.vggame3.com:7001/"};
        QPDY_URL = new String[]{"https://api.douyinapi1.com:7443/", "https://api.douyinapi2.com:7443/", "https://api.douyinapi3.com:7443/", "https://api.douyinapi4.com:7443/", "https://api.douyinapi5.com:7443/"};
        QPXY_URL = new String[]{"https://api.xingyunapi2.com:7443/", "https://api.xingyunapi3.com:7443/", "https://api.xingyunapi4.com:7443/", "https://api.xingyunapi5.com:7443/"};
    }

    private static String getBaseUrl() {
        String str;
        if (IS_DEBUG) {
            str = "http://newh5.430v.com/";
        } else {
            str = "https://api.383game7dg.com:8553/";
        }
        return str;
    }

    public static String getPayUrl() {
        StringBuilder localStringBuilder;
        String str;
        if (IS_DEBUG) {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(BASE_URL);
            str = "#/topayment?";
        } else {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(BASE_URL);
            str = "pay.html?";
        }
        localStringBuilder.append(str);
        return localStringBuilder.toString();
    }
}

