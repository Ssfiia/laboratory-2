public class Name {
    private final String surname;
    private final String name;
    private final String patronymic;

    public Name(String surname, String name, String patronymic) {
        this.surname = normalize(surname);
        this.name = normalize(name);
        this.patronymic = normalize(patronymic);
    }

    public Name(String name) {
        this(null, name, null);
    }

    public Name(String name, String surname) {
        this(surname, name, null);
    }

    private static String normalize(String s) {
        if (s == null) return null;
        s = s.trim();
        return s.isEmpty() ? null : s;
    }

    public String getSurname() { return surname; }
    public String getname() { return name; }
    public String getPatronymic() { return patronymic; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (surname != null) sb.append(surname).append(' ');
        if (name != null) sb.append(name).append(' ');
        if (patronymic != null) sb.append(patronymic);
        return sb.toString().trim();
    }
}
