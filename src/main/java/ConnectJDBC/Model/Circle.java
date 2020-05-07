package ConnectJDBC.Model;

public class Circle {
    private int id;
    private String name;
    public Circle(){}

    public Circle(int circleId,String name){
        setName(name);
        setId(circleId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
