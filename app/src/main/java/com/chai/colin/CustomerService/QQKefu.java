package com.chai.colin.CustomerService;

public class QQKefu
{
  private String qq;
  private String qqName;
  private String qqTempUrl;
  private String qqUrlCode;
  
  public String getQq()
  {
    return this.qq;
  }
  
  public String getQqName()
  {
    return this.qqName;
  }
  
  public String getQqTempUrl()
  {
    return this.qqTempUrl;
  }
  
  public String getQqUrlCode()
  {
    return this.qqUrlCode;
  }
  
  public void setQq(String paramString)
  {
    this.qq = paramString;
  }
  
  public void setQqName(String paramString)
  {
    this.qqName = paramString;
  }
  
  public void setQqTempUrl(String paramString)
  {
    this.qqTempUrl = paramString;
  }
  
  public void setQqUrlCode(String paramString)
  {
    this.qqUrlCode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQKefu{qq1='");
    localStringBuilder.append(this.qq);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qqName ='");
    localStringBuilder.append(this.qqName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qqTempUrl ='");
    localStringBuilder.append(this.qqTempUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qqUrlCode ='");
    localStringBuilder.append(this.qqUrlCode);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

