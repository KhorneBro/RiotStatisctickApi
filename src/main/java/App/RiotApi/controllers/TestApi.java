package App.RiotApi.controllers;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScore;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestApi {

    @GetMapping("api")
    public ResponseEntity getChampionStatus() {
        List<Summoner> summoners = Orianna.summonersNamed("FatalElement", "Kalturi").withRegion(Region.NORTH_AMERICA).get();
        List<Champion> champions = Orianna.championsNamed("Annie", "Thresh").withRegion(Region.NORTH_AMERICA).get();

        ChampionMasteries masteries = Orianna.championMasteriesForSummoner(summoners.get(0)).get();
        ChampionMastery mastery = Orianna.championMasteryForSummoner(summoners.get(0)).withChampion(champions.get(0)).get();
        ChampionMasteryScore score = Orianna.championMasteryScoreForSummoner(summoners.get(0)).get();

        List<ChampionMasteries> manyMasteries = Orianna.championMasteriesForSummoners(summoners).get();
        List<ChampionMastery> manyMastery = Orianna.championMasteriesForSummoner(summoners.get(0)).withChampions(champions).get();
        List<ChampionMasteryScore> manyScores = Orianna.championMasteryScoresForSummoners(summoners).get();

        return ResponseEntity.ok().body(champions);
    }
}
