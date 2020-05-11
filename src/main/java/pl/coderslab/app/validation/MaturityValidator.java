package pl.coderslab.app.validation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class MaturityValidator implements ConstraintValidator<IsMature,Integer> {
    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        int currentYear = LocalDateTime.now().getYear();
        return currentYear-yearOfBirth>=18;
    }



}
