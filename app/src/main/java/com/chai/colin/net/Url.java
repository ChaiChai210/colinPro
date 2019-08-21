package com.chai.colin.net;

import rxhttp.wrapper.annotation.DefaultDomain;

public class Url {
//    @Domain(name = "Update9158") //设置非默认域名，name 可不传，不传默认为变量的名称
//    public static String update = "http://update.9158.com";

    @DefaultDomain() //设置为默认域名
//    http://192.168.0.122:8081/zh-member-web/userInfoMember/addUserInfoMember.do
    public static String baseUrl = "http://www.zhmember.f9186.com:8080/zh-member-web/";
//    public static String baseUrl = " https://www.wanandroid.com/";
}
