package entity;

public class Address {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    public Address() {
    }
    public Address(Integer id, String name, String address, String phone) {
        setAddress(address);
        setId(id);
        setName(name);
        setPhone(phone);
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + address + " " + phone + "\n";
    }
}
