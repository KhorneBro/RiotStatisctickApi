package App.RiotApi;

import com.merakianalytics.orianna.Orianna;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiotApiApplication {

    public static void main(String[] args) {
        Orianna.setRiotAPIKey("RGAPI-9bd162f8-1ada-4c91-83f7-7e2e9dfaddd2");
        SpringApplication.run(RiotApiApplication.class, args);
    }

}
