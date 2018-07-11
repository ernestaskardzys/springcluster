package info.ernestas.springcluster.web.resources;

public class CounterResource {

    private final long id;
    private final String message;

    public CounterResource() {
        this(0, null);
    }

    public CounterResource(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
