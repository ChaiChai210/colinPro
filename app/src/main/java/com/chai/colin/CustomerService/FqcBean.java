package com.chai.colin.CustomerService;

public class FqcBean {
    private String creationBy;
    private String creationTime;
    private String currentUser;
    private String dataSourceKey;
    private String lastUpdatedBy;
    private String lastUpdatedTime;
    private String problemConcent;
    private String problemID;
    private String problemName;

    public FqcBean(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {
        this.creationTime = paramString1;
        this.creationBy = paramString2;
        this.lastUpdatedTime = paramString3;
        this.lastUpdatedBy = paramString4;
        this.dataSourceKey = paramString5;
        this.currentUser = paramString6;
        this.problemID = paramString7;
        this.problemName = paramString8;
        this.problemConcent = paramString9;
    }

    public FqcBean() {

    }

    public String getCreationBy() {
        return this.creationBy;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public String getCurrentUser() {
        return this.currentUser;
    }

    public String getDataSourceKey() {
        return this.dataSourceKey;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public String getProblemConcent() {
        return this.problemConcent;
    }

    public String getProblemID() {
        return this.problemID;
    }

    public String getProblemName() {
        return this.problemName;
    }

    public void setCreationBy(String paramString) {
        this.creationBy = paramString;
    }

    public void setCreationTime(String paramString) {
        this.creationTime = paramString;
    }

    public void setCurrentUser(String paramString) {
        this.currentUser = paramString;
    }

    public void setDataSourceKey(String paramString) {
        this.dataSourceKey = paramString;
    }

    public void setLastUpdatedBy(String paramString) {
        this.lastUpdatedBy = paramString;
    }

    public void setLastUpdatedTime(String paramString) {
        this.lastUpdatedTime = paramString;
    }

    public void setProblemConcent(String paramString) {
        this.problemConcent = paramString;
    }

    public void setProblemID(String paramString) {
        this.problemID = paramString;
    }

    public void setProblemName(String paramString) {
        this.problemName = paramString;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FqcBean{creationTime='");
        localStringBuilder.append(this.creationTime);
        localStringBuilder.append('\'');
        localStringBuilder.append(", creationBy='");
        localStringBuilder.append(this.creationBy);
        localStringBuilder.append('\'');
        localStringBuilder.append(", lastUpdatedTime='");
        localStringBuilder.append(this.lastUpdatedTime);
        localStringBuilder.append('\'');
        localStringBuilder.append(", lastUpdatedBy='");
        localStringBuilder.append(this.lastUpdatedBy);
        localStringBuilder.append('\'');
        localStringBuilder.append(", dataSourceKey='");
        localStringBuilder.append(this.dataSourceKey);
        localStringBuilder.append('\'');
        localStringBuilder.append(", currentUser='");
        localStringBuilder.append(this.currentUser);
        localStringBuilder.append('\'');
        localStringBuilder.append(", problemID='");
        localStringBuilder.append(this.problemID);
        localStringBuilder.append('\'');
        localStringBuilder.append(", problemName='");
        localStringBuilder.append(this.problemName);
        localStringBuilder.append('\'');
        localStringBuilder.append(", problemConcent='");
        localStringBuilder.append(this.problemConcent);
        localStringBuilder.append('\'');
        localStringBuilder.append('}');
        return localStringBuilder.toString();
    }
}



/* Location:           E:\22\projects\383\ProjectSrc\smali\

 * Qualified Name:     com.game.app.entity.FqcBean

 * JD-Core Version:    0.7.0.1

 */