package models;

public class Guest {

    private final String name;
    private final String phoneNumber;
    private final String gender;
    private final String birthDate;
    private final String address;
    private final boolean termsAccepted;

    public Guest(String name, String phoneNumber, String gender, String birthDate, String address, boolean termsAccepted) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.termsAccepted = termsAccepted;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    @Override
    public String toString() {
        return name + ";" + phoneNumber + ";" + gender + ";" + birthDate + ";" + address + ";" + termsAccepted;
    }
}
