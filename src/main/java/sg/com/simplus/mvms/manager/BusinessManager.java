package sg.com.simplus.mvms.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.com.simplus.mvms.Constants;
import sg.com.simplus.mvms.data.repository.VesselRepository;
import sg.com.simplus.mvms.framework.util.ViewData;
import sg.com.simplus.mvms.mq.ProducerService;
import sg.com.simplus.mvms.service.businessservice.*;
import sg.com.simplus.mvms.service.dataservice.FleetDataService;


@RequestMapping(Constants.ROOT_ENDPOINT_CONTEXT)
public class BusinessManager {
    public ViewData viewData = new ViewData();

    @Autowired
    public AlertBusinessService alertBusinessService;

    @Autowired
    public BuoyBusinessService buoyBusinessService;

    @Autowired
    public FleetBusinessService fleetBusinessService;

    @Autowired
    public GeofenceAlertTriggerBusinessService geofenceAlertTriggerBusinessService;

    @Autowired
    public GeofenceBusinessService geofenceBusinessService;

    @Autowired
    public NoteBusinessService noteBusinessService;

    @Autowired
    public PositionReportBusinessService positionReportBusinessService;

    @Autowired
    public PositionReportLastBusinessService positionReportLastBusinessService;

    @Autowired
    public ProjectVesselTypeBusinessService projectVesselTypeBusinessService;

    @Autowired
    public RouteBusinessService routeBusinessService;

    @Autowired
    public SettingConfigurationBusinessService settingConfigurationBusinessService;

    @Autowired
    public UnAlertBusinessService unAlertBusinessService;

    @Autowired
    public UserBusinessService userBusinessService;

    @Autowired
    public UserSettingBusinessService userSettingBusinessService;

    @Autowired
    public UserLogBusinessService userLogBusinessService;

    @Autowired
    public VesselBusinessService vesselBusinessService;

    @Autowired
    public VesselTypeProjectBusinessService vesselTypeProjectBusinessService;

    @Autowired
    public VesselTypeAisBusinessService vesselTypeAisBusinessService;

    @Autowired
    ProducerService producerService;
}
