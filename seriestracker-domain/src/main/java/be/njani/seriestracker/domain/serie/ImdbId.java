package be.njani.seriestracker.domain.serie;


import be.njani.seriestracker.domain.infrastructure.validator.SeriestrackerValidator;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ImdbId {

    @NotNull
    private String value;

    private ImdbId(){}

    public ImdbId(String value){
        this.value = value;
        SeriestrackerValidator.validator().validate(this);
    }

    public String getValue() {
        return value;
    }
}
