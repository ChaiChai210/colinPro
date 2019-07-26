package com.chai.colin.entity;

public class WithdrawalRange
{
  private double abnormalFeeProportion;
  private int abnormalWithdraw;
  private String creationBy;
  private long creationTime;
  private String currentUser;
  private int damaMultiple;
  private int damaMultipleId;
  private Object dataSourceKey;
  private int discountDamaMultiple;
  private int discountProportion;
  private String inspectResult;
  private String lastUpdatedBy;
  private Object lastUpdatedTime;
  private int maxDiscountValue;
  private int maxWithdraw;
  private int maxWithdrawFee;
  private int minWithdraw;
  private int mustInt;
  private int type;
  private double withdrawFeeProportion;
  
  public double getAbnormalFeeProportion()
  {
    return this.abnormalFeeProportion;
  }
  
  public int getAbnormalWithdraw()
  {
    return this.abnormalWithdraw;
  }
  
  public String getCreationBy()
  {
    return this.creationBy;
  }
  
  public long getCreationTime()
  {
    return this.creationTime;
  }
  
  public String getCurrentUser()
  {
    return this.currentUser;
  }
  
  public int getDamaMultiple()
  {
    return this.damaMultiple;
  }
  
  public int getDamaMultipleId()
  {
    return this.damaMultipleId;
  }
  
  public Object getDataSourceKey()
  {
    return this.dataSourceKey;
  }
  
  public int getDiscountDamaMultiple()
  {
    return this.discountDamaMultiple;
  }
  
  public int getDiscountProportion()
  {
    return this.discountProportion;
  }
  
  public String getInspectResult()
  {
    return this.inspectResult;
  }
  
  public String getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public Object getLastUpdatedTime()
  {
    return this.lastUpdatedTime;
  }
  
  public int getMaxDiscountValue()
  {
    return this.maxDiscountValue;
  }
  
  public int getMaxWithdraw()
  {
    return this.maxWithdraw;
  }
  
  public int getMaxWithdrawFee()
  {
    return this.maxWithdrawFee;
  }
  
  public int getMinWithdraw()
  {
    return this.minWithdraw;
  }
  
  public int getMustInt()
  {
    return this.mustInt;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public double getWithdrawFeeProportion()
  {
    return this.withdrawFeeProportion;
  }
  
  public void setAbnormalFeeProportion(double paramDouble)
  {
    this.abnormalFeeProportion = paramDouble;
  }
  
  public void setAbnormalWithdraw(int paramInt)
  {
    this.abnormalWithdraw = paramInt;
  }
  
  public void setCreationBy(String paramString)
  {
    this.creationBy = paramString;
  }
  
  public void setCreationTime(long paramLong)
  {
    this.creationTime = paramLong;
  }
  
  public void setCurrentUser(String paramString)
  {
    this.currentUser = paramString;
  }
  
  public void setDamaMultiple(int paramInt)
  {
    this.damaMultiple = paramInt;
  }
  
  public void setDamaMultipleId(int paramInt)
  {
    this.damaMultipleId = paramInt;
  }
  
  public void setDataSourceKey(Object paramObject)
  {
    this.dataSourceKey = paramObject;
  }
  
  public void setDiscountDamaMultiple(int paramInt)
  {
    this.discountDamaMultiple = paramInt;
  }
  
  public void setDiscountProportion(int paramInt)
  {
    this.discountProportion = paramInt;
  }
  
  public void setInspectResult(String paramString)
  {
    this.inspectResult = paramString;
  }
  
  public void setLastUpdatedBy(String paramString)
  {
    this.lastUpdatedBy = paramString;
  }
  
  public void setLastUpdatedTime(Object paramObject)
  {
    this.lastUpdatedTime = paramObject;
  }
  
  public void setMaxDiscountValue(int paramInt)
  {
    this.maxDiscountValue = paramInt;
  }
  
  public void setMaxWithdraw(int paramInt)
  {
    this.maxWithdraw = paramInt;
  }
  
  public void setMaxWithdrawFee(int paramInt)
  {
    this.maxWithdrawFee = paramInt;
  }
  
  public void setMinWithdraw(int paramInt)
  {
    this.minWithdraw = paramInt;
  }
  
  public void setMustInt(int paramInt)
  {
    this.mustInt = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setWithdrawFeeProportion(double paramDouble)
  {
    this.withdrawFeeProportion = paramDouble;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WithdrawalRange{creationTime=");
    localStringBuilder.append(this.creationTime);
    localStringBuilder.append(", creationBy='");
    localStringBuilder.append(this.creationBy);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastUpdatedTime=");
    localStringBuilder.append(this.lastUpdatedTime);
    localStringBuilder.append(", lastUpdatedBy='");
    localStringBuilder.append(this.lastUpdatedBy);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dataSourceKey=");
    localStringBuilder.append(this.dataSourceKey);
    localStringBuilder.append(", currentUser='");
    localStringBuilder.append(this.currentUser);
    localStringBuilder.append('\'');
    localStringBuilder.append(", damaMultipleId=");
    localStringBuilder.append(this.damaMultipleId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", discountProportion=");
    localStringBuilder.append(this.discountProportion);
    localStringBuilder.append(", maxDiscountValue=");
    localStringBuilder.append(this.maxDiscountValue);
    localStringBuilder.append(", discountDamaMultiple=");
    localStringBuilder.append(this.discountDamaMultiple);
    localStringBuilder.append(", minWithdraw=");
    localStringBuilder.append(this.minWithdraw);
    localStringBuilder.append(", maxWithdraw=");
    localStringBuilder.append(this.maxWithdraw);
    localStringBuilder.append(", withdrawFeeProportion=");
    localStringBuilder.append(this.withdrawFeeProportion);
    localStringBuilder.append(", maxWithdrawFee=");
    localStringBuilder.append(this.maxWithdrawFee);
    localStringBuilder.append(", mustInt=");
    localStringBuilder.append(this.mustInt);
    localStringBuilder.append(", abnormalWithdraw=");
    localStringBuilder.append(this.abnormalWithdraw);
    localStringBuilder.append(", abnormalFeeProportion=");
    localStringBuilder.append(this.abnormalFeeProportion);
    localStringBuilder.append(", damaMultiple=");
    localStringBuilder.append(this.damaMultiple);
    localStringBuilder.append(", inspectResult='");
    localStringBuilder.append(this.inspectResult);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}



/* Location:           E:\22\projects\383\ProjectSrc\smali\

 * Qualified Name:     com.game.app.entity.WithdrawalRange

 * JD-Core Version:    0.7.0.1

 */