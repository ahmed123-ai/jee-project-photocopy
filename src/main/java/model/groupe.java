package model;

public class groupe {
    int id;
    String label;

    public groupe(int id, String label) {
        super();
        this.id = id;
        this.label = label;
    }

    public groupe(String label) {
        super();
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
