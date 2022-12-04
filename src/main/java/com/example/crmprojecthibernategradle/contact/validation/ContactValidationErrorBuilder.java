package com.example.CRMProject.contact.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ContactValidationErrorBuilder {

    public static ContactValidationError fromBindingErrors(Errors errors) {
        ContactValidationError error = new ContactValidationError("Validation failed."
                + errors.getErrorCount() + " error(s)");

        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
