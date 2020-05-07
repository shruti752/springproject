package ConnectJDBC.Model;

public class Triangle {
    private int id;
    private String name;
    public Triangle(){}
    public Triangle(int trinagleId,String name){
        setId(trinagleId);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
