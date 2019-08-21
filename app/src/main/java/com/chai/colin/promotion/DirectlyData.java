package com.chai.colin.promotion;

import java.util.List;

public class DirectlyData
{
  int pageNo;
  int pageSize;
  List<PromoteNextData> result;
  int totalPage;
  int totalRecord;

  public int getPageNo()
  {
    return this.pageNo;
  }

  public int getPageSize()
  {
    return this.pageSize;
  }

  public List<PromoteNextData> getResult()
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

  public void setResult(List<PromoteNextData> paramList)
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
}
