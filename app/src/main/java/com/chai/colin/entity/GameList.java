package com.chai.colin.entity;

public class GameList {
    private String gameKind;
    private String liveCode;   //分类
    private String url;
    public GameList(String url){
        this.url = url;
    }

    public String getGameKind() {
        return gameKind;
    }

    public String getLiveCode() {
        return liveCode;
    }

    public String getUrl() {
        return url;
    }
}
