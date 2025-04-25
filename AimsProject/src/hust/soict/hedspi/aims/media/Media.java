package hust.soict.hedspi.aims.media;


public class Media extends java.lang.Object {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    @Override public boolean equals(Object obj) {
        Media other = (Media) obj;
        return this.title.equals(other.getTitle());
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(int id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public void play() {}

    

    
}
