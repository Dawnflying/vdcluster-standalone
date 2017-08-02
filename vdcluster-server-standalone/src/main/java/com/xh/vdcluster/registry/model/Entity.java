package com.xh.vdcluster.registry.model;

import java.util.Date;

/**
 * Created by bloom on 2017/7/18.
 */
public class Entity {

    private int id;

    private Date created;

    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
