package com.xh.vdcluster.registry;

/**
 * Created by bloom on 2017/7/13.
 */
public interface StateListener {
    void onChanged(StateEvent stateEvent) throws Exception;

}
