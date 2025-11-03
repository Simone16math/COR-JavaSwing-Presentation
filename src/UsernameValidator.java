public class UsernameValidator implements Validator{
    // Attribute
    private Validator nextValidator;

    // sets the next validator
    @Override
    public void setNextValidator(Validator nextValidator){
        // sets the next validator
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration) throws ValidationException{
        // Get the username from the registration
        String username = registration.getUsername();

        // if the username is null or less than 5 characters long
        if (username == null || username.length() < 5){
            // throw an exception that the username needs to be longer
            throw new ValidationException("Username must be at least 5 characters long");
        }

        // if the username is 5 or more characters long, we can proceed to the next
        // validator as the username is validated
        if (nextValidator != null) {
            nextValidator.validate(registration);
        }
    }
}
