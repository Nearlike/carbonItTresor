package model;

public enum CellType {
    P("   .   "),
    M("   M   "),
    T("   T"),
    A("   A");

    private final String value;

    CellType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
