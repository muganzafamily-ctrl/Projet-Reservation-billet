package Model;

public class CompagnieAerienne {

    private String code;
    private String pays;

    public CompagnieAerienne(String code, String pays) throws InvalidDataException {
        setCode(code);
        setPays(pays);
    }

    public void setCode(String code) throws InvalidDataException {
        if (code == null || code.trim().length() < 2)
            throw new InvalidDataException("Code compagnie invalide");
        this.code = code.trim().toUpperCase();
    }

    public void setPays(String pays) throws InvalidDataException {
        if (pays == null || pays.trim().isEmpty())
            throw new InvalidDataException("Pays invalide");
        this.pays = pays.trim();
    }

    public String getCode() { return code; }

    @Override
    public String toString() {
        return code + " (" + pays + ")";
    }
}
