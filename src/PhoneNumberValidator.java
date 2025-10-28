public class PhoneNumberValidator implements Validator{
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration){

        String phoneNumber = registration.getPhoneNumber();

        if (phoneNumber != null){
            if (phoneNumber.length() == 10){
                // if the "phone number" is 10 digits
                // want to make sure that they are all numbers 0-9
                // how to do that?
            }
            // if valid
            if (nextValidator != null){
                nextValidator.validate(registration);
            }
        }
        // if the phone number is null what to do next?
    }
}
