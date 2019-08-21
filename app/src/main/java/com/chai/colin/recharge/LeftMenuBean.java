package com.chai.colin.recharge;

public class LeftMenuBean
{
  private String isRecommend;
  private boolean isSelected;
  private String payTypeIcon;
  private String payTypeIcon2;
  private int payTypeId;
  private String payTypeName;

  public String getIsRecommend()
  {
    return this.isRecommend;
  }

  public String getPayTypeIcon()
  {
    return this.payTypeIcon;
  }

  public String getPayTypeIcon2()
  {
    return this.payTypeIcon2;
  }

  public int getPayTypeId()
  {
    return this.payTypeId;
  }

  public String getPayTypeName()
  {
    return this.payTypeName;
  }

  public boolean isSelected()
  {
    return this.isSelected;
  }

  public void setIsRecommend(String paramString)
  {
    this.isRecommend = paramString;
  }

  public void setPayTypeIcon(String paramString)
  {
    this.payTypeIcon = paramString;
  }

  public void setPayTypeIcon2(String paramString)
  {
    this.payTypeIcon2 = paramString;
  }

  public void setPayTypeId(int paramInt)
  {
    this.payTypeId = paramInt;
  }

  public void setPayTypeName(String paramString)
  {
    this.payTypeName = paramString;
  }

  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LeftMenuBean{payTypeId=");
    localStringBuilder.append(this.payTypeId);
    localStringBuilder.append(", payTypeName='");
    localStringBuilder.append(this.payTypeName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", payTypeIcon='");
    localStringBuilder.append(this.payTypeIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isRecommend='");
    localStringBuilder.append(this.isRecommend);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSelected=");
    localStringBuilder.append(this.isSelected);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
