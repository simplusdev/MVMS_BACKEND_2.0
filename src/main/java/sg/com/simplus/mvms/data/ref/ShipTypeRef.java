package sg.com.simplus.mvms.data.ref;

import sg.com.simplus.mvms.framework.util.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public enum ShipTypeRef {
    UNDEFINED(0);

    private ShipTypeRef(Integer code ) {
        this.code=code;
    }

    private Integer code;
    private String value;
    private static Map map = new HashMap<>();

    static {
        map.put(0, "Undefined");
        map.put(1, "Not available");
        map.put(2, "Not available");
        map.put(3, "Not available");
        map.put(4, "Not available");
        map.put(5, "Not available");
        map.put(6, "Not available");
        map.put(7, "Not available");
        map.put(8, "Not available");
        map.put(9, "Not available");
        map.put(10, "Not available");
        map.put(11, "Not available");
        map.put(12, "Not available");
        map.put(13, "Not available");
        map.put(14, "Not available");
        map.put(15, "Not available");
        map.put(16, "Not available");
        map.put(17, "Not available");
        map.put(18, "Not available");
        map.put(19, "Not available");
        map.put(20, "Wing in ground (WIG), all ships of this type");
        map.put(21,"Wing in ground (WIG), Hazardous category A");
        map.put(22,"Wing in ground (WIG), Hazardous category B");
        map.put(23,"Wing in ground (WIG), Hazardous category C");
        map.put(24,"Wing in ground (WIG), Hazardous category D");
        map.put(25,"Wing in ground (WIG), Reserved for future use");
        map.put(26,"Wing in ground (WIG), Reserved for future use");
        map.put(27,"Wing in ground (WIG), Reserved for future use");
        map.put(28,"Wing in ground (WIG), Reserved for future use");
        map.put(29,"Wing in ground (WIG), Reserved for future use");
        map.put(30,"Fishing");
        map.put(31,"Towing");
        map.put(32,"Towing: length exceeds 200m or breadth exceeds 25m");
        map.put(33,"Dredging or underwater ops");
        map.put(34,"Diving ops");
        map.put(35,"Military ops");
        map.put(36,"Sailing");
        map.put(37,"Pleasure Craft");
        map.put(38,"Reserved");
        map.put(39,"Reserved");
        map.put(40,"High speed craft (HSC), all ships of this type");
        map.put(41,"High speed craft (HSC), Hazardous category A");
        map.put(42,"High speed craft (HSC), Hazardous category B");
        map.put(43,"High speed craft (HSC), Hazardous category C");
        map.put(44,"High speed craft (HSC), Hazardous category D");
        map.put(45,"High speed craft (HSC), Reserved for future use");
        map.put(46,"High speed craft (HSC), Reserved for future use");
        map.put(47,"High speed craft (HSC), Reserved for future use");
        map.put(48,"High speed craft (HSC), Reserved for future use");
        map.put(49,"High speed craft (HSC), No additional information");
        map.put(50,"Pilot Vessel");
        map.put(51,"Search and Rescue vessel");
        map.put(52,"Tug");
        map.put(53,"Port Tender");
        map.put(54,"Anti-pollution equipment");
        map.put(55,"Law Enforcement");
        map.put(56,"Spare - Local Vessel");
        map.put(57,"Spare - Local Vessel");
        map.put(58,"Medical Transport");
        map.put(59,"Noncombatant ship according to RR Resolution No. 18");
        map.put(60,"Passenger, all ships of this type");
        map.put(61,"Passenger, Hazardous category A");
        map.put(62,"Passenger, Hazardous category B");
        map.put(63,"Passenger, Hazardous category C");
        map.put(64,"Passenger, Hazardous category D");
        map.put(65,"Passenger, Reserved for future use");
        map.put(66,"Passenger, Reserved for future use");
        map.put(67,"Passenger, Reserved for future use");
        map.put(68,"Passenger, Reserved for future use");
        map.put(69,"Passenger, No additional information");
        map.put(70,"Cargo, all ships of this type");
        map.put(71,"Cargo, Hazardous category A");
        map.put(72,"Cargo, Hazardous category B");
        map.put(73,"Cargo, Hazardous category C");
        map.put(74,"Cargo, Hazardous category D");
        map.put(75,"Cargo, Reserved for future use");
        map.put(76,"Cargo, Reserved for future use");
        map.put(77,"Cargo, Reserved for future use");
        map.put(78,"Cargo, Reserved for future use");
        map.put(79,"Cargo, No additional information");
        map.put(80,"Tanker, all ships of this type");
        map.put(81,"Tanker, Hazardous category A");
        map.put(82,"Tanker, Hazardous category B");
        map.put(83,"Tanker, Hazardous category C");
        map.put(84,"Tanker, Hazardous category D");
        map.put(85,"Tanker, Reserved for future use");
        map.put(86,"Tanker, Reserved for future use");
        map.put(87,"Tanker, Reserved for future use");
        map.put(88,"Tanker, Reserved for future use");
        map.put(89,"Tanker, No additional information");
        map.put(90,"Other Type, all ships of this type");
        map.put(91,"Other Type, Hazardous category A");
        map.put(92,"Other Type, Hazardous category B");
        map.put(93,"Other Type, Hazardous category C");
        map.put(94,"Other Type, Hazardous category D");
        map.put(95,"Other Type, Reserved for future use");
        map.put(96,"Other Type, Reserved for future use");
        map.put(97,"Other Type, Reserved for future use");
        map.put(98,"Other Type, Reserved for future use");
        map.put(99,"Other Type, no additional information");

    }

    public static String descOf(Integer code){
        if(code!=null) {
            return (String) map.get(code);
        }
        return null;
    }

    public static Integer codeOf(String desc){
        return (Integer) PropertyUtil.getKey(map, desc);
    }

    public Integer getCode() {
        return code;
    }
}
