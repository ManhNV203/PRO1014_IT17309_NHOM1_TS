package DomainModel;

public class Size {

    private Integer id;
    private String ma;
    private String theTich;

    public Size() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTheTich() {
        return theTich;
    }

    public void setTheTich(String theTich) {
        this.theTich = theTich;
    }

    @Override
    public String toString() {
        return "Size{" + "id=" + id + ", ma=" + ma + ", theTich=" + theTich + '}';
    }

}
