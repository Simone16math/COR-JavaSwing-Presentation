public class EmailValidator implements Validator{
    private Validator nextValidator;

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

        if (email != null){
            if (email.contains("@") && email.contains(".")){
                // if the email contains an @ and it contains a . we might be okay
                // need to test this as the example code seems like it should be more complicated
            }
            // if the email is valid
            if (nextValidator != null){
                nextValidator.validate(registration);
            }
        }
        // the email is null so do something here
    }
}
