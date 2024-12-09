package example.task3;

public class Result {
    private int id;
    private String value;

    public Result(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
