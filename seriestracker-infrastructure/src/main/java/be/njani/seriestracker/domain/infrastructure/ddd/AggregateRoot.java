package be.njani.seriestracker.domain.infrastructure.ddd;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AggregateRoot<ID extends Id> extends BaseEntity<ID> {

    @Version
    @Column(nullable = false)
    private int versie;

    protected AggregateRoot() {
    }

    public int getVersie() {
        return versie;
    }
}
