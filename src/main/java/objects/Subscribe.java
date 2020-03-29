package objects;

public class Subscribe {
    private int id_subscription;
    private int id_edition;
    private String reader_surname;
    private String edition_name;


    public int getId_subscription() {
        return id_subscription;
    }

    public void setId_subscription(int id_subscription) {
        this.id_subscription = id_subscription;
    }

    public String getReader_surname() {
        return reader_surname;
    }

    public void setReader_surname(String reader_surname) {
        this.reader_surname = reader_surname;
    }

    public String getEdition_name() {
        return edition_name;
    }

    public void setEdition_name(String edition_name) {
        this.edition_name = edition_name;
    }



    public int getId_edition() {
        return id_edition;
    }

    public void setId_edition(int id_edition) {
        this.id_edition = id_edition;
    }
    @Override
    public String toString() {
        return "Subscribe{" +
                "id_subscription=" + id_subscription +
                ", id_edition=" + id_edition +
                ", reader_surname='" + reader_surname + '\'' +
                ", edition_name='" + edition_name + '\'' +
                '}';
    }


}
