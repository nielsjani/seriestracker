package be.njani.seriestracker.domain.serie;

import be.njani.seriestracker.domain.DomainIntegrationTest;
import org.junit.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class SerieRepositoryIntegrationTest extends DomainIntegrationTest{

    @Inject
    private SerieRepository repository;

    @Test
    public void save(){
        SerieId id = SerieId.serieId();
        String imdbID = "tt112233";
        Serie savedSerie = repository.save(Serie.SerieBuilder.serie()
                .withId(id)
                .withImdbId(new ImdbId(imdbID))
                .build());

        assertThat(savedSerie.getId()).isEqualTo(id);
        assertThat(savedSerie.getVersie()).isEqualTo(0);
        assertThat(savedSerie.getImdbId().getValue()).isEqualTo(imdbID);
    }

    @Test
    public void findOne(){
        SerieId id = SerieId.serieId();
        String imdbID = "tt112233";
        Serie savedSerie = repository.save(Serie.SerieBuilder.serie()
                .withId(id)
                .withImdbId(new ImdbId(imdbID))
                .build());

        assertThat(repository.findOne(savedSerie.getId())).isEqualTo(savedSerie);
    }
}