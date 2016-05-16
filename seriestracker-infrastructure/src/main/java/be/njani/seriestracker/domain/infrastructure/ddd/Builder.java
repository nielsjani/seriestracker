package be.njani.seriestracker.domain.infrastructure.ddd;

import javax.validation.ConstraintViolationException;

import static be.njani.seriestracker.domain.infrastructure.validator.SeriestrackerValidator.validator;

public abstract class Builder<T> {

    protected abstract T buildInternal();

    public final T build() throws ConstraintViolationException {
        T object = buildInternal();
        validator().validate(object);
        return object;
    }
}
