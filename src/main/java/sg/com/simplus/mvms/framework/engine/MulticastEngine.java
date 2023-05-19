package sg.com.simplus.mvms.framework.engine;


import org.reflections.Reflections;
import sg.com.simplus.mvms.service.multicastservice.MulticastService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class MulticastEngine {
    private static Map<String,Object> multicastServiceMap = new HashMap<>();

    private static MulticastEngine instance;

    public static void init(){
        Reflections reflections = new Reflections("sg.com.simplus.mvms.service.multicastservice");
        Set<Class<? extends MulticastService>> subMulticast = reflections.getSubTypesOf(MulticastService.class);
        for (Class<? extends MulticastService> aClass : subMulticast) {
            System.out.println(aClass.getName());
            try {
                MulticastService multicastService = aClass.newInstance();
                multicastService.registerMulticast();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static MulticastEngine getInstance(){
//        if(instance == null) {
//            instance = new MulticastEngine();
//        }
        return instance ;
    }

    public static    MulticastService getMulticastService(String env){
        return (MulticastService) multicastServiceMap.get(env);
    }


    public abstract void registerMulticast( );

    public static void registerMulticast(String id, MulticastService multicastService){
        multicastServiceMap.put(id,multicastService);
        System.out.println("registerMulticast id: "+id);
    }
}
