
package DomainModel;

public class ComBoChiTiet {
    private Integer id_CB;
    private Integer id_SP;

    public ComBoChiTiet() {
    }

    public ComBoChiTiet(Integer id_CB, Integer id_SP) {
        this.id_CB = id_CB;
        this.id_SP = id_SP;
    }

    public Integer getId_CB() {
        return id_CB;
    }

    public void setId_CB(Integer id_CB) {
        this.id_CB = id_CB;
    }

    public Integer getId_SP() {
        return id_SP;
    }

    public void setId_SP(Integer id_SP) {
        this.id_SP = id_SP;
    }

    @Override
    public String toString() {
        return "ComBoChiTiet{" + "id_CB=" + id_CB + ", id_SP=" + id_SP + '}';
    }

    
    
}
