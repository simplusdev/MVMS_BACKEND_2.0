package sg.com.simplus.mvms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import sg.com.simplus.mvms.framework.engine.LabelPropertyEngine;
import sg.com.simplus.mvms.framework.engine.MulticastEngine;
import sg.com.simplus.mvms.mq.GeofenceLookupService;
import sg.com.simplus.mvms.mq.ProducerService;
import sg.com.simplus.mvms.mq.VesselTypeLookupService;

@EnableEncryptableProperties
@SpringBootApplication
@EnableJms
public class MvmsApplication  implements ApplicationRunner {

	@Autowired
	LabelPropertyEngine labelPropertyEngine;

	@Autowired
	GeofenceLookupService geofenceLookupService;

	@Autowired
	VesselTypeLookupService vesselTypeLookupService;

	public static void main(String[] args) throws JsonProcessingException {
		ConfigurableApplicationContext appContext = SpringApplication.run(MvmsApplication.class, args);
		ProducerService producerService = appContext.getBean(ProducerService.class);
		//producerService.sendToQueue();
		//producerService.sendToTopic();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner#run()");
		MulticastEngine.init();
		labelPropertyEngine.init();
		geofenceLookupService.fetch();
		vesselTypeLookupService.fetch();
	}
}
