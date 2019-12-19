package tom.r.projetandroid4a.Model;

public class Personnage {
    private String id ;
    private String classe;
    private String name;
    private String gender;
    private String sorts;
    private String description_wakfu;
    private String description_dofus;
    private String description_dofus_retro;
    private String icone;
    private String image;
    private String image_wakfu;
    private String image_dofus;
    private String image_dofus_retro;
    private String lien_wakfu;
    private String lien_dofus;
    private String lien_dofus_retro;

    public Personnage() {
    }

    public Personnage(String id, String classe, String name, String gender, String sorts, String description_wakfu, String description_dofus, String description_dofus_retro, String icone, String image, String image_wakfu, String image_dofus, String image_dofus_retro, String lien_wakfu, String lien_dofus, String lien_dofus_retro) {
        this.id = id;
        this.classe = classe;
        this.name = name;
        this.gender = gender;
        this.sorts = sorts;
        this.description_wakfu = description_wakfu;
        this.description_dofus = description_dofus;
        this.description_dofus_retro = description_dofus_retro;
        this.icone = icone;
        this.image = image;
        this.image_wakfu = image_wakfu;
        this.image_dofus = image_dofus;
        this.image_dofus_retro = image_dofus_retro;
        this.lien_wakfu = lien_wakfu;
        this.lien_dofus = lien_dofus;
        this.lien_dofus_retro = lien_dofus_retro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getDescription_wakfu() {
        return description_wakfu;
    }

    public void setDescription_wakfu(String description_wakfu) {
        this.description_wakfu = description_wakfu;
    }

    public String getDescription_dofus() {
        return description_dofus;
    }

    public void setDescription_dofus(String description_dofus) {
        this.description_dofus = description_dofus;
    }

    public String getDescription_dofus_retro() {
        return description_dofus_retro;
    }

    public void setDescription_dofus_retro(String description_dofus_retro) {
        this.description_dofus_retro = description_dofus_retro;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_wakfu() {
        return image_wakfu;
    }

    public void setImage_wakfu(String image_wakfu) {
        this.image_wakfu = image_wakfu;
    }

    public String getImage_dofus() {
        return image_dofus;
    }

    public void setImage_dofus(String image_dofus) {
        this.image_dofus = image_dofus;
    }

    public String getImage_dofus_retro() {
        return image_dofus_retro;
    }

    public void setImage_dofus_retro(String image_dofus_retro) {
        this.image_dofus_retro = image_dofus_retro;
    }

    public String getLien_wakfu() {
        return lien_wakfu;
    }

    public void setLien_wakfu(String lien_wakfu) {
        this.lien_wakfu = lien_wakfu;
    }

    public String getLien_dofus() {
        return lien_dofus;
    }

    public void setLien_dofus(String lien_dofus) {
        this.lien_dofus = lien_dofus;
    }

    public String getLien_dofus_retro() {
        return lien_dofus_retro;
    }

    public void setLien_dofus_retro(String lien_dofus_retro) {
        this.lien_dofus_retro = lien_dofus_retro;
    }
}
