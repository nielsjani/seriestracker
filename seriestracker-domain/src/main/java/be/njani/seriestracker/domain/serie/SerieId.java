package be.njani.seriestracker.domain.serie;

import be.njani.seriestracker.domain.infrastructure.ddd.Id;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import static be.njani.seriestracker.domain.infrastructure.validator.SeriestrackerValidator.validator;
import static java.util.UUID.randomUUID;

@Embeddable
public class SerieId extends Id{

    @NotNull
    private String value;

    private SerieId(String value){
        this.value = value;
        validator().validate(this);
    }

    protected SerieId(){
        this(randomUUID().toString());
    }

    public static SerieId serieId(){
        return new SerieId();
    }

    @Override
    public String getValue() {
        return value;
    }
}
