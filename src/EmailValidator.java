public class EmailValidator implements Validator{
    // Attribute
    private Validator nextValidator;

    @Override

    public void setNextValidator(Validator nextValidator){
        // sets the next validator
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration) throws ValidationException{

        String email = registration.getEmail();
        // if the email is null, or it does not contain the characters below
        if (email == null || !email.matches("^[\\w._%+-]+@[w=\\w.-]+\\.[a-zA-Z]{2,6}$")){
            // throw a new exception that the email is invalid
            throw new ValidationException("Invalid email format.");
        }

        // if the email is valid
        if (nextValidator != null){
                nextValidator.validate(registration);
            }
    }
}
