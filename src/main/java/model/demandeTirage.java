package model;

import java.util.Date;

public class demandeTirage {
    private int id;
    private int user_id;
    private int matier_id;
    private String dateArriver;
    private int nbCopier;
    private int statu;

    public demandeTirage(int id, int user_id, int matier_id, String dateArriver, int nbCopier, int statu) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.matier_id = matier_id;
        this.dateArriver = dateArriver;
        this.nbCopier = nbCopier;
        this.statu = statu;
    }
    
    public demandeTirage( int user_id, int matier_id, String dateArriver, int nbCopier, int statu) {
        super();
        
        this.user_id = user_id;
        this.matier_id = matier_id;
        this.dateArriver = dateArriver;
        this.nbCopier = nbCopier;
        this.statu = statu;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMatier_id() {
        return matier_id;
    }

    public void setMatier_id(int matier_id) {
        this.matier_id = matier_id;
    }

    public String getDateArriver() {
        return dateArriver;
    }

    public void setDateArriver(String dateArriver) {
        this.dateArriver = dateArriver;
    }

    public int getNbCopier() {
        return nbCopier;
    }

    public void setNbCopier(int nbCopier) {
        this.nbCopier = nbCopier;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }
}
