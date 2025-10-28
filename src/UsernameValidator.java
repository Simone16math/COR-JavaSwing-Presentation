public class UsernameValidator implements Validator{
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration){
        String username = registration.getUsername();
        if (username != null){
            if (username.length() < 5){
                // the username is too short
                // send message or something like that
            }
            // indicate that the username is valid to be used
            if (nextValidator != null){
                nextValidator.validate(registration);
            }
        }
        // the usernemae is null so we have to do something here
    }
}
