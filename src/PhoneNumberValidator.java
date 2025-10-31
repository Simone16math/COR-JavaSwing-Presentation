public class PhoneNumberValidator implements Validator{
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator){
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration registration) throws ValidationException{

        String phoneNumber = registration.getPhoneNumber();

//        if (phoneNumber != null){
//            if (phoneNumber.length() == 10){
//                // if the "phone number" is 10 digits
//                // want to make sure that they are all numbers 0-9
//                // how to do that?
//            }
//            // if valid
//            if (nextValidator != null){
//                nextValidator.validate(registration);
//            }
//        }
//        // if the phone number is null what to do next?


        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")){
            throw new ValidationException("Phone number must be exactly 10 digits");
        }

        // if the phone number is valid
        if (nextValidator != null){
               nextValidator.validate(registration);
        }
    }
}
