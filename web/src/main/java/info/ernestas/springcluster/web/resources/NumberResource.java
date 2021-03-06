package info.ernestas.springcluster.web.resources;

public class NumberResource {

    private final long number;

    public NumberResource() {
        this(0);
    }

    public NumberResource(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }
}
