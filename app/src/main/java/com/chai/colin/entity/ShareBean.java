package com.chai.colin.entity;

import java.io.Serializable;

public class ShareBean
  implements Serializable
{
  private String content;
  private int id;
  private String image;
  private String name;
  private String share;
  private String title;
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getImage()
  {
    return this.image;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getShare()
  {
    return this.share;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImage(String paramString)
  {
    this.image = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setShare(String paramString)
  {
    this.share = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareBean{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", image='");
    localStringBuilder.append(this.image);
    localStringBuilder.append('\'');
    localStringBuilder.append(", share='");
    localStringBuilder.append(this.share);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}



/* Location:           E:\22\projects\383\ProjectSrc\smali\

 * Qualified Name:     com.game.app.entity.ShareBean

 * JD-Core Version:    0.7.0.1

 */