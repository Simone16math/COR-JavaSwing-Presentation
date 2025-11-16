public class EmailValidator implements Validator{
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

        String email = registration.getEmail();

        // if the email is null, or it does not contain the characters below
        if (email == null || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
            // where \\w is a-zA-Z0-9, \\. is literal dot, and {2,6} matches sequence
            // of 2 to 6 characters for the domain

            // throw a new exception that the email is invalid
            throw new ValidationException("Invalid email format.");
        }

        // if the email is valid
        if (nextValidator != null){
                nextValidator.validate(registration);
            }
    }
}
