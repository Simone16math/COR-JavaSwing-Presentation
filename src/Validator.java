public interface Validator {
    void setNextValidator(Validator nextValidator);
    void validate(UserRegistration registration) throws ValidationException;
    // might need to    throw ValidationException
}
