package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.Service.AnimeService;
import academy.devdojo.springboot2.Util.Dateutil;
import academy.devdojo.springboot2.domain.Anime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final Dateutil dateUtil;
    private final AnimeService animeService;

    @RequestMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));

        return animeService.listAll();
    }
}
