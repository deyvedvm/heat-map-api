package dev.deyve.heatmapapi;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class HeatMapApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(HeatMapApiApplication.class, args);

        log.info("Running on java: {}", System.getProperty("java.version"));
    }

}
