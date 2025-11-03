public class PasswordValidator implements Validator{
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration) throws ValidationException{

        String password = registration.getPassword();

        // if the password is null OR is less than 8 characters OR
        // if the passwords does not contain at least one uppercase letter, one lowercase letter and one digit
        if (password == null || password.length() <8 ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*[a-z].*") ||
                !password.matches(".*[0-9].*")) {
            throw new ValidationException("Password muct be at least 8 characters long with at least one " +
                    "uppercase, one lowercase and one digit.");
        }
        // if the password is valid
        if (nextValidator != null){
                nextValidator.validate(registration);
            }
    }
}
