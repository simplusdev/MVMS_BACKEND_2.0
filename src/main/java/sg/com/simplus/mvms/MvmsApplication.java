package sg.com.simplus.mvms;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sg.com.simplus.mvms.framework.engine.LabelPropertyEngine;
import sg.com.simplus.mvms.framework.engine.MulticastEngine;

@EnableEncryptableProperties
@SpringBootApplication
public class MvmsApplication  implements ApplicationRunner {

	@Autowired
	LabelPropertyEngine labelPropertyEngine;

	public static void main(String[] args) {
		SpringApplication.run(MvmsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner#run()");
		MulticastEngine.init();
		labelPropertyEngine.init();
	}
}
