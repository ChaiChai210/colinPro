package com.chai.colin.userinfo;

import java.util.List;

public class VIPLevelInfoBean
{
  private List<GoldListBean> goldList;
  private List<LevelListBean> levelList;
  private SalaryStatusBean salaryStatus;
  
  public List<GoldListBean> getGoldList()
  {
    return this.goldList;
  }
  
  public List<LevelListBean> getLevelList()
  {
    return this.levelList;
  }
  
  public SalaryStatusBean getSalaryStatus()
  {
    return this.salaryStatus;
  }
  
  public void setGoldList(List<GoldListBean> paramList)
  {
    this.goldList = paramList;
  }
  
  public void setLevelList(List<LevelListBean> paramList)
  {
    this.levelList = paramList;
  }
  
  public void setSalaryStatus(SalaryStatusBean paramSalaryStatusBean)
  {
    this.salaryStatus = paramSalaryStatusBean;
  }
  
  public static class GoldListBean
  {
    private String newLevel;
    private int promotionGold;
    private String status;
    
    public String getNewLevel()
    {
      return this.newLevel;
    }
    
    public int getPromotionGold()
    {
      return this.promotionGold;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public void setNewLevel(String paramString)
    {
      this.newLevel = paramString;
    }
    
    public void setPromotionGold(int paramInt)
    {
      this.promotionGold = paramInt;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
  }
  
  public static class LevelListBean
  {
    private String creationBy;
    private long creationTime;
    private Object currentUser;
    private Object dataSourceKey;
    private Object integralValue;
    private String lastUpdatedBy;
    private long lastUpdatedTime;
    private Object levelConfigCode;
    private int levelConfigId;
    private int levelEndPoint;
    private String levelIcon;
    private String levelName;
    private int levelStartPoint;
    private int monthAmount;
    private int promotionGold;
    private int weekAmount;
    private double xima;
    
    public String getCreationBy()
    {
      return this.creationBy;
    }
    
    public long getCreationTime()
    {
      return this.creationTime;
    }
    
    public Object getCurrentUser()
    {
      return this.currentUser;
    }
    
    public Object getDataSourceKey()
    {
      return this.dataSourceKey;
    }
    
    public Object getIntegralValue()
    {
      return this.integralValue;
    }
    
    public String getLastUpdatedBy()
    {
      return this.lastUpdatedBy;
    }
    
    public long getLastUpdatedTime()
    {
      return this.lastUpdatedTime;
    }
    
    public Object getLevelConfigCode()
    {
      return this.levelConfigCode;
    }
    
    public int getLevelConfigId()
    {
      return this.levelConfigId;
    }
    
    public int getLevelEndPoint()
    {
      return this.levelEndPoint;
    }
    
    public String getLevelIcon()
    {
      return this.levelIcon;
    }
    
    public String getLevelName()
    {
      return this.levelName;
    }
    
    public int getLevelStartPoint()
    {
      return this.levelStartPoint;
    }
    
    public int getMonthAmount()
    {
      return this.monthAmount;
    }
    
    public int getPromotionGold()
    {
      return this.promotionGold;
    }
    
    public int getWeekAmount()
    {
      return this.weekAmount;
    }
    
    public double getXima()
    {
      return this.xima;
    }
    
    public void setCreationBy(String paramString)
    {
      this.creationBy = paramString;
    }
    
    public void setCreationTime(long paramLong)
    {
      this.creationTime = paramLong;
    }
    
    public void setCurrentUser(Object paramObject)
    {
      this.currentUser = paramObject;
    }
    
    public void setDataSourceKey(Object paramObject)
    {
      this.dataSourceKey = paramObject;
    }
    
    public void setIntegralValue(Object paramObject)
    {
      this.integralValue = paramObject;
    }
    
    public void setLastUpdatedBy(String paramString)
    {
      this.lastUpdatedBy = paramString;
    }
    
    public void setLastUpdatedTime(long paramLong)
    {
      this.lastUpdatedTime = paramLong;
    }
    
    public void setLevelConfigCode(Object paramObject)
    {
      this.levelConfigCode = paramObject;
    }
    
    public void setLevelConfigId(int paramInt)
    {
      this.levelConfigId = paramInt;
    }
    
    public void setLevelEndPoint(int paramInt)
    {
      this.levelEndPoint = paramInt;
    }
    
    public void setLevelIcon(String paramString)
    {
      this.levelIcon = paramString;
    }
    
    public void setLevelName(String paramString)
    {
      this.levelName = paramString;
    }
    
    public void setLevelStartPoint(int paramInt)
    {
      this.levelStartPoint = paramInt;
    }
    
    public void setMonthAmount(int paramInt)
    {
      this.monthAmount = paramInt;
    }
    
    public void setPromotionGold(int paramInt)
    {
      this.promotionGold = paramInt;
    }
    
    public void setWeekAmount(int paramInt)
    {
      this.weekAmount = paramInt;
    }
    
    public void setXima(double paramDouble)
    {
      this.xima = paramDouble;
    }
  }
  
  public static class SalaryStatusBean
  {
    private String levelName;
    private String monthStatus;
    private String weekStatus;
    
    public String getLevelName()
    {
      return this.levelName;
    }
    
    public String getMonthStatus()
    {
      return this.monthStatus;
    }
    
    public String getWeekStatus()
    {
      return this.weekStatus;
    }
    
    public void setLevelName(String paramString)
    {
      this.levelName = paramString;
    }
    
    public void setMonthStatus(String paramString)
    {
      this.monthStatus = paramString;
    }
    
    public void setWeekStatus(String paramString)
    {
      this.weekStatus = paramString;
    }
  }
}


