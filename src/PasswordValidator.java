public class PasswordValidator implements Validator{
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration){
        /*
        We want the password to be at least 8 characters long, contain at least one uppercase letter,
        contain at least on lowercase letter, and contain at least one digit.
        Look up .matches() for String to see what we can do with it Simone
         */
        String password = registration.getPassword();

        if (password != null){
            if (password.length() < 8){
                // the password is too short
                // do something so that it stops
            }

            // need to check if uppercase, lowercase and digit is present
            // message saying that the password is valid

            if (nextValidator != null){
                nextValidator.validate(registration);
            }

        }
        // the password is null so do something here
    }
}
