package pl.sda.zadaniaGrzegorz.zad14_03_2023;

public enum Gender {

    FEMALE (1, "Kobieta", "Woman", "f"),
    MALE (2, "Mężczyzna", "Man", "m");

    private int index;
    private String plTranslation;
    private String enTranslation;
    private String abbrev;

    Gender(int index, String plTranslation, String enTranslation, String abbrev) {
        this.index = index;
        this.plTranslation = plTranslation;
        this.enTranslation = enTranslation;
        this.abbrev = abbrev;
    }

    public static Gender findByAbbrev(String abbreviation) {
        for (Gender current : Gender.values()) {
            if (abbreviation.equalsIgnoreCase(current.abbrev)) {
                return current;
            }
        }
        return null;
    }
}
