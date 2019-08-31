package com.chai.colin.entity;

public class CategoryBean {
    private String gamingType;
    private boolean isOpen ;
      private boolean isSelected;
    private int sort;

    public CategoryBean(String gamingType,boolean isOpen,boolean isSelected){
        this.gamingType = gamingType;
        this.isOpen = isOpen;
        this.isSelected = isSelected;
    }
    public String getGamingType() {
        return this.gamingType;
    }

    public int getSort() {
        return this.sort;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setGamingType(String paramString) {
        this.gamingType = paramString;
    }

    public void setOpen(boolean paramBoolean) {
        this.isOpen = paramBoolean;
    }


    public void setSort(int paramInt) {
        this.sort = paramInt;
    }
}
