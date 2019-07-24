package com.chai.colin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPUtils
{
  private static final String BANK_USER_NAME = "bank_user_name";
  private static final String CUS_QQ = "cus_qq";
  private static final String CUS_URL = "cus_url";
  private static final String CUS_VX = "cus_vx";
  private static final String CUS_VX_IMG = "cus_vx_img";
  private static final String FIRST_ENTER = "firstEnter";
  private static final String MUSIC = "music";
  private static final String NICK_NAME = "nickname";
  private static final String PHONE_NUMBER = "telephone";
  private static final String SERVICETYPE = "servicetype";
  private static final String SHARE_NAME = "share_name";
  private static final String SP_NAME = "config";
  private static final String TAG = "SPUtils";
  private static final String USER_ACCOUNT = "userAccount";
  private static final String USER_ID = "userId";
  private static final String USER_NAME = "userName";
  private static final String USER_PASSWORD = "userPassword";
  private static final String VIP_LEVEL = "vip_level ;";
  private static final String VOLUM = "volum";
  private static final String WAKEUP = "wakeup";
  private static final String YESTERDAY = "yesterday";
  @SuppressLint({"StaticFieldLeak"})
  private static SPUtils ourInstance = new SPUtils();
  String a = "";
  private String bankUserName;
  private Context context;
  private Editor editor;
  private String imgCode = "";
  private String level = "vip1";
  private float music = 0.6F;
  private String nickName;
  private String onlineUrl = "";
  private String qq = "";
  private int serviceType = 0;
  private SharedPreferences sp;
  private String userAccount = "";
  private int userId;
  private String userPassword = "";
  private float volum = 0.6F;
  private String vx = "";
  private boolean wakeup = false;
  
  public static SPUtils getInstance()
  {
    return ourInstance;
  }
  
  public String getBankUserName()
  {
    return this.sp.getString("bank_user_name", this.bankUserName);
  }
  
  public boolean getFirstEnter()
  {
    return this.sp.getBoolean("firstEnter", true);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.sp.getInt(paramString, paramInt);
  }
  
  public float getMusic()
  {
    this.music = this.sp.getFloat("music", this.music);
    return this.music;
  }
  
  public int getMusic(int paramInt)
  {
    return this.sp.getInt("music", paramInt);
  }
  
  public String getNickName()
  {
    return this.sp.getString("nickname", "");
  }
  
  public String getOnlineUrl()
  {
    return this.sp.getString("cus_url", this.onlineUrl);
  }
  
  public String getPhonenumber()
  {
    this.a = this.sp.getString("telephone", null);
    return this.a;
  }
  
  public String getPwd()
  {
    this.userPassword = this.sp.getString("userPassword", null);
    return this.userPassword;
  }
  
  public String getQQ()
  {
    return this.sp.getString("cus_qq", this.qq);
  }
  
  public int getServiceType()
  {
    this.serviceType = this.sp.getInt("servicetype", 0);
    return this.serviceType;
  }
  
  public String getShareName()
  {
    return this.sp.getString("share_name", "");
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
  
  public String getUserAccount()
  {
    this.userAccount = this.sp.getString("userAccount", null);
    return this.userAccount;
  }
  
  public int getUserId()
  {
    this.userId = this.sp.getInt("userId", 0);
    return this.userId;
  }
  
  public String getVipLevel()
  {
    return this.sp.getString("vip_level ;", this.level);
  }
  
  public float getVolum()
  {
    this.volum = this.sp.getFloat("volum", this.volum);
    return this.volum;
  }
  
  public int getVolum(int paramInt)
  {
    return this.sp.getInt("volum", paramInt);
  }
  
  public String getVx()
  {
    return this.sp.getString("cus_vx", this.vx);
  }
  
  public String getVxImg()
  {
    return this.sp.getString("cus_vx_img", this.imgCode);
  }
  
  public boolean getWakeup()
  {
    this.wakeup = this.sp.getBoolean("wakeup", false);
    return this.wakeup;
  }
  
  public String getYesterday()
  {
    return this.sp.getString("yesterday", "");
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void init(Context paramContext)
  {
    this.context = paramContext;
    if (this.sp == null) {
      this.sp = paramContext.getSharedPreferences("config", 0);
    }
    if (this.editor == null) {
      this.editor = this.sp.edit();
    }
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.editor.putInt(paramString, paramInt).commit();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.editor.putString(paramString1, paramString2).commit();
  }
  
  public void setAccount(String paramString)
  {
    this.userAccount = paramString;
    this.editor.putString("userAccount", paramString).commit();
  }
  
  public void setBankUserName(String paramString)
  {
    this.bankUserName = paramString;
    this.editor.putString("bank_user_name", this.bankUserName).commit();
  }
  
  public void setFirstEnter(boolean paramBoolean)
  {
    this.editor.putBoolean("firstEnter", paramBoolean).commit();
  }
  
  public void setLevel(String paramString)
  {
    this.level = paramString;
    this.editor.putString("vip_level ;", paramString).commit();
  }
  
  public void setMusic(int paramInt)
  {
    this.music = paramInt;
    this.editor.putInt("music", paramInt).commit();
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
    this.editor.putString("nickname", paramString).commit();
  }
  
  public void setOnlineUrl(String paramString)
  {
    this.onlineUrl = paramString;
    this.editor.putString("cus_url", paramString).commit();
  }
  
  public void setPhonenumber(String paramString)
  {
    this.a = paramString;
    this.editor.putString("telephone", paramString).commit();
  }
  
  public void setPwd(String paramString)
  {
    this.userPassword = paramString;
    this.editor.putString("userPassword", paramString).commit();
  }
  
  public void setQQ(String paramString)
  {
    this.qq = paramString;
    this.editor.putString("cus_qq", paramString).commit();
  }
  
  public void setServiceType(int paramInt)
  {
    this.serviceType = paramInt;
    this.editor.putInt("servicetype", paramInt).commit();
  }
  
  public void setShareName(String paramString)
  {
    this.editor.putString("share_name", paramString).commit();
  }
  
  public void setUserId(int paramInt)
  {
    this.userId = paramInt;
    this.editor.putInt("userId", paramInt).commit();
  }
  
  public void setVolume(int paramInt)
  {
    this.volum = paramInt;
    this.editor.putInt("volum", paramInt).commit();
  }
  
  public void setVx(String paramString)
  {
    this.vx = paramString;
    this.editor.putString("cus_vx", paramString).commit();
  }
  
  public void setVxImg(String paramString)
  {
    this.imgCode = paramString;
    this.editor.putString("cus_vx_img", paramString).commit();
  }
  
  public void setWakeup(boolean paramBoolean)
  {
    this.wakeup = paramBoolean;
    this.editor.putBoolean("wakeup", paramBoolean).commit();
  }
  
  public void setYesterday(String paramString)
  {
    this.editor.putString("yesterday", paramString).commit();
  }
}



