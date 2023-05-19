package sg.com.simplus.mvms.service.multicastservice;

import sg.com.simplus.mvms.framework.engine.MulticastEngine;
import sg.com.simplus.mvms.framework.util.ViewData;

public abstract class MulticastService extends MulticastEngine {
    public abstract void testHello();

    public abstract void executeGetUserInfo(ViewData viewData);
}
