public class EmailValidator implements Validator{
    private Validator nextValidator;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9.+_-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration){
        /*
        The email should follow a standard format eg username@domain.com
         */
        String email = registration.getEmail();

        if (email == null || !email.matches(EMAIL_REGEX)){
            throw new IllegalArgumentException("Invalid email format");
        }

        // if the email is valid
        if (nextValidator != null){
            nextValidator.validate(registration);
        }
    }
}
