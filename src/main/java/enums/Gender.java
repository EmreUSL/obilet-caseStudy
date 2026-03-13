package enums;

public enum Gender {
    FEMALE("F"),
    MALE("M"),
    FEMALESEAT("female"),
    MALESEAT("male");


    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
