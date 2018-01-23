package hello;

public class CTest {

    private final long id;
    private final String content;

    public CTest(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
