package be.njani.seriestracker.domain.infrastructure.ddd;

import java.io.Serializable;

public abstract class Id extends ValueObject implements Serializable{

    public abstract String getValue();
}
