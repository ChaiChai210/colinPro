package com.chai.colin.userinfo;

public class RightsBean {
    private boolean isCanXima;
    private String levelName;
    private float monthAmount;
    private String monthStatus;
    private float promotionGold;
    private String status;
    private float weekAmount;
    private String weekStatus;
    private float xima;

    public String getLevelName() {
        return this.levelName;
    }

    public float getMonthAmount() {
        return this.monthAmount;
    }

    public String getMonthStatus() {
        return this.monthStatus;
    }

    public float getPromotionGold() {
        return this.promotionGold;
    }

    public String getStatus() {
        return this.status;
    }

    public float getWeekAmount() {
        return this.weekAmount;
    }

    public String getWeekStatus() {
        return this.weekStatus;
    }

    public float getXima() {
        return this.xima;
    }

    public boolean isCanXima() {
        return this.isCanXima;
    }

    public void setCanXima(boolean paramBoolean) {
        this.isCanXima = paramBoolean;
    }

    public void setLevelName(String paramString) {
        this.levelName = paramString;
    }

    public void setMonthAmount(float paramFloat) {
        this.monthAmount = paramFloat;
    }

    public void setMonthStatus(String paramString) {
        this.monthStatus = paramString;
    }

    public void setPromotionGold(float paramFloat) {
        this.promotionGold = paramFloat;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
    }

    public void setWeekAmount(float paramFloat) {
        this.weekAmount = paramFloat;
    }

    public void setWeekStatus(String paramString) {
        this.weekStatus = paramString;
    }

    public void setXima(float paramFloat) {
        this.xima = paramFloat;
    }
}

