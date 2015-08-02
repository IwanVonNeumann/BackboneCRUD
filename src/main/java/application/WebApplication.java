package application;

import config.SpringConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * Created by Iwan on 01.06.2015
 */

public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfiguration.class, args);
    }
}
