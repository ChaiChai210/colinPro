package com.chai.colin.promotion;

import java.util.List;

public class MyPerformanceBean
{
  private int pageNo;
  private int pageSize;
  private List<ResultBean> result;
  private int totalPage;
  private int totalRecord;
  
  public int getPageNo()
  {
    return this.pageNo;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public List<ResultBean> getResult()
  {
    return this.result;
  }
  
  public int getTotalPage()
  {
    return this.totalPage;
  }
  
  public int getTotalRecord()
  {
    return this.totalRecord;
  }
  
  public void setPageNo(int paramInt)
  {
    this.pageNo = paramInt;
  }
  
  public void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
  
  public void setResult(List<ResultBean> paramList)
  {
    this.result = paramList;
  }
  
  public void setTotalPage(int paramInt)
  {
    this.totalPage = paramInt;
  }
  
  public void setTotalRecord(int paramInt)
  {
    this.totalRecord = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MyPerformanceBean{pageNo=");
    localStringBuilder.append(this.pageNo);
    localStringBuilder.append(", pageSize=");
    localStringBuilder.append(this.pageSize);
    localStringBuilder.append(", totalPage=");
    localStringBuilder.append(this.totalPage);
    localStringBuilder.append(", totalRecord=");
    localStringBuilder.append(this.totalRecord);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.result);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class ResultBean
  {
    private String allCommission;
    private String batch;
    private int childNodeNewNum;
    private int childNodeNum;
    private int childPerformance;
    private int commissionRatio;
    private int contributeCommission;
    private String ownerPerformance;
    private String proxymode;
    private String selfCommission;
    private int teamNewNum;
    private int teamNum;
    private String teamPerformance;
    private int userId;
    
    public String getAllCommission()
    {
      return this.allCommission;
    }
    
    public String getBatch()
    {
      return this.batch;
    }
    
    public int getChildNodeNewNum()
    {
      return this.childNodeNewNum;
    }
    
    public int getChildNodeNum()
    {
      return this.childNodeNum;
    }
    
    public int getChildPerformance()
    {
      return this.childPerformance;
    }
    
    public int getCommissionRatio()
    {
      return this.commissionRatio;
    }
    
    public int getContributeCommission()
    {
      return this.contributeCommission;
    }
    
    public String getOwnerPerformance()
    {
      return this.ownerPerformance;
    }
    
    public String getProxymode()
    {
      return this.proxymode;
    }
    
    public String getSelfCommission()
    {
      return this.selfCommission;
    }
    
    public int getTeamNewNum()
    {
      return this.teamNewNum;
    }
    
    public int getTeamNum()
    {
      return this.teamNum;
    }
    
    public String getTeamPerformance()
    {
      return this.teamPerformance;
    }
    
    public int getUserId()
    {
      return this.userId;
    }
    
    public void setAllCommission(String paramString)
    {
      this.allCommission = paramString;
    }
    
    public void setBatch(String paramString)
    {
      this.batch = paramString;
    }
    
    public void setChildNodeNewNum(int paramInt)
    {
      this.childNodeNewNum = paramInt;
    }
    
    public void setChildNodeNum(int paramInt)
    {
      this.childNodeNum = paramInt;
    }
    
    public void setChildPerformance(int paramInt)
    {
      this.childPerformance = paramInt;
    }
    
    public void setCommissionRatio(int paramInt)
    {
      this.commissionRatio = paramInt;
    }
    
    public void setContributeCommission(int paramInt)
    {
      this.contributeCommission = paramInt;
    }
    
    public void setOwnerPerformance(String paramString)
    {
      this.ownerPerformance = paramString;
    }
    
    public void setProxymode(String paramString)
    {
      this.proxymode = paramString;
    }
    
    public void setSelfCommission(String paramString)
    {
      this.selfCommission = paramString;
    }
    
    public void setTeamNewNum(int paramInt)
    {
      this.teamNewNum = paramInt;
    }
    
    public void setTeamNum(int paramInt)
    {
      this.teamNum = paramInt;
    }
    
    public void setTeamPerformance(String paramString)
    {
      this.teamPerformance = paramString;
    }
    
    public void setUserId(int paramInt)
    {
      this.userId = paramInt;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResultBean{allCommission='");
      localStringBuilder.append(this.allCommission);
      localStringBuilder.append('\'');
      localStringBuilder.append(", batch='");
      localStringBuilder.append(this.batch);
      localStringBuilder.append('\'');
      localStringBuilder.append(", childNodeNewNum=");
      localStringBuilder.append(this.childNodeNewNum);
      localStringBuilder.append(", childNodeNum=");
      localStringBuilder.append(this.childNodeNum);
      localStringBuilder.append(", childPerformance=");
      localStringBuilder.append(this.childPerformance);
      localStringBuilder.append(", commissionRatio=");
      localStringBuilder.append(this.commissionRatio);
      localStringBuilder.append(", contributeCommission=");
      localStringBuilder.append(this.contributeCommission);
      localStringBuilder.append(", ownerPerformance='");
      localStringBuilder.append(this.ownerPerformance);
      localStringBuilder.append('\'');
      localStringBuilder.append(", proxymode='");
      localStringBuilder.append(this.proxymode);
      localStringBuilder.append('\'');
      localStringBuilder.append(", teamNewNum=");
      localStringBuilder.append(this.teamNewNum);
      localStringBuilder.append(", teamNum=");
      localStringBuilder.append(this.teamNum);
      localStringBuilder.append(", teamPerformance='");
      localStringBuilder.append(this.teamPerformance);
      localStringBuilder.append('\'');
      localStringBuilder.append(", userId=");
      localStringBuilder.append(this.userId);
      localStringBuilder.append(", selfCommission='");
      localStringBuilder.append(this.selfCommission);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}



/* Location:           E:\22\projects\383\ProjectSrc\smali\

 * Qualified Name:     com.game.app.entity.mypromotion.MyPerformanceBean

 * JD-Core Version:    0.7.0.1

 */