package be.njani.seriestracker.domain.infrastructure.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static javax.validation.Validation.buildDefaultValidatorFactory;

public class SeriestrackerValidator {

    private static SeriestrackerValidator instance;

    private Validator validator;

    private SeriestrackerValidator() {
        validator = buildDefaultValidatorFactory().getValidator();
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(
                constraintViolationErrorMessage(violations),
                new HashSet<ConstraintViolation<?>>(violations));
        }
    }

    private String constraintViolationErrorMessage(Set<ConstraintViolation<Object>> violations) {
        Set<String> violationMessages = violations.stream()
            .map(violation -> String.format("%s#%s can not have value %s because %s", violation.getRootBeanClass(), violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()))
            .collect(toSet());
        return StringUtils.join(violationMessages, ", ");
    }

    public static SeriestrackerValidator validator() {
        if (instance == null) {
            instance = new SeriestrackerValidator();
        }
        return instance;
    }
}
