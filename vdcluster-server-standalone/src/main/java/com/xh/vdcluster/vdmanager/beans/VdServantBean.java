package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.repository.model.Stream;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServantBean {

    public static final int RUNNING = 0;
    public static final int STOPPED = 1;
    public static final int CREATED = 2;
    public static final int DELETING = 3;
    public static final int DELETED = 4;

    private String servantId;

    private Stream stream;

    private int state;

    private DetectServiceConfiguration configuration;

    public VdServantBean(DetectServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getServantId() {
        return servantId;
    }

    public void setServantId(String servantId) {
        this.servantId = servantId;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
