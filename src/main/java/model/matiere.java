package model;

public class matiere {
	  int id;
    private String label;
    private int group_id;


    public matiere( int id  , String label, int group_id) {
    	this.id = id ; 
        this.label = label;
        this.group_id = group_id;
    }
    
    public matiere(String label, int group_id) {
        this.label = label;
        this.group_id = group_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
