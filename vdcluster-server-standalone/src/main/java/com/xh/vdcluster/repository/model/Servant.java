package com.xh.vdcluster.repository.model;

import java.util.Date;

public class Servant {
    private Integer id;

    private String servantid;

    private Integer userid;

    private Integer streamid;

    private Date starttime;

    private Date expiretime;

    private Integer framewidth;

    private Integer frameheight;

    private Integer decodemode;

    private Integer streamtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServantid() {
        return servantid;
    }

    public void setServantid(String servantid) {
        this.servantid = servantid == null ? null : servantid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStreamid() {
        return streamid;
    }

    public void setStreamid(Integer streamid) {
        this.streamid = streamid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public Integer getFramewidth() {
        return framewidth;
    }

    public void setFramewidth(Integer framewidth) {
        this.framewidth = framewidth;
    }

    public Integer getFrameheight() {
        return frameheight;
    }

    public void setFrameheight(Integer frameheight) {
        this.frameheight = frameheight;
    }

    public Integer getDecodemode() {
        return decodemode;
    }

    public void setDecodemode(Integer decodemode) {
        this.decodemode = decodemode;
    }

    public Integer getStreamtype() {
        return streamtype;
    }

    public void setStreamtype(Integer streamtype) {
        this.streamtype = streamtype;
    }
}