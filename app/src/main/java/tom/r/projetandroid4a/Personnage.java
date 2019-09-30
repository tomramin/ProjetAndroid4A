package tom.r.projetandroid4a;

public class Personnage {

    private String id;
    private String name;
    private String sort;
    private String description;
    private String icone;
    private String image;

    public Personnage(String id, String name, String sort, String description, String icone, String image) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.description = description;
        this.icone = icone;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSort() {
        return sort;
    }

    public String getDescription() {
        return description;
    }

    public String getIcone() {
        return icone;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
