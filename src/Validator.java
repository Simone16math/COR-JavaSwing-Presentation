public interface Validator {
    void setNextValidator(Validator nextValidator);
    void validate(UserRegistration registration);
    // might need to    throws ValidationException
}
