public class PhoneNumberValidator implements Validator{
    // Attributes
    private Validator nextValidator;

    // sets the next validator
    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration) throws ValidationException{

        String phoneNumber = registration.getPhoneNumber();

        // if the phone number is null, or it does not have 10 digits
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")){
            throw new ValidationException("Phone number must be exactly 10 digits");
        }

        // if the phone number is valid
        if (nextValidator != null){
               nextValidator.validate(registration);
        }
    }
}
