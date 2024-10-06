package phucnph22239.poly.lovely_hotel.DTO;

public class LoaiPhong {
    private int id;
    private String name;

    public LoaiPhong() {
    }

    public LoaiPhong(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
