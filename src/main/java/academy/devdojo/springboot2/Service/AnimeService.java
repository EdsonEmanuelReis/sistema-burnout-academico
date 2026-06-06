package academy.devdojo.springboot2.Service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll (){
        return List.of(new Anime ("Boku No Hero",1L), new Anime ("Berserk",2L));

    }
}
