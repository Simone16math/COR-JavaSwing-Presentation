public class PhoneNumberValidator implements Validator{
    private Validator nextValidator;
    private static final String PHONE_REGEX = "^\\d{10}$";

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration){

        String phoneNumber = registration.getPhoneNumber();

        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
            // if valid
        if (nextValidator != null){
                nextValidator.validate(registration);
        }
    }
}
