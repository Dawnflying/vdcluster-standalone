package com.xh.vdcluster.repository.model;

public class VdServant {
    private Integer id;

    private String servantId;

    private String streamId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServantId() {
        return servantId;
    }

    public void setServantId(String servantId) {
        this.servantId = servantId == null ? null : servantId.trim();
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId == null ? null : streamId.trim();
    }
}