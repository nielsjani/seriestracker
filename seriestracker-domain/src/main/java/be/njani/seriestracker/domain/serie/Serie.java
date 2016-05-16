package be.njani.seriestracker.domain.serie;

import be.njani.seriestracker.domain.infrastructure.ddd.Builder;
import be.njani.seriestracker.domain.infrastructure.ddd.AggregateRoot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Serie.TABLE_NAME)
public class Serie extends AggregateRoot<SerieId>{

    public static final String TABLE_NAME = "SERIE";

    @Id
    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "SERIE_ID", unique = true, nullable = false, updatable = false, length = 36))
    private SerieId id;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "IMDB_ID", unique = true, nullable = false, updatable = false, length = 36))
    private ImdbId imdbId;

    @Override
    public SerieId getId() {
        return id;
    }

    private Serie(){
    }

    private Serie(SerieBuilder builder){
        this.id = builder.id;
        this.imdbId = builder.imdbId;
    }

    public ImdbId getImdbId() {
        return imdbId;
    }

    public static class SerieBuilder extends Builder<Serie> {

        private SerieId id;
        private ImdbId imdbId;

        @Override
        protected Serie buildInternal() {
            return new Serie(this);
        }

        private SerieBuilder(){}

        public static SerieBuilder serie(){
            return new SerieBuilder();
        }

        public SerieBuilder withId(SerieId id) {
            this.id = id;
            return this;
        }

        public SerieBuilder withImdbId(ImdbId imdbId) {
            this.imdbId = imdbId;
            return this;
        }
    }
}
