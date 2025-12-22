package exhodus.demo.DTOS;

public class PatronSimpleDTO {

    private long _id;
    private String patronName;
    private String url;

    public PatronSimpleDTO() {
    }

    public PatronSimpleDTO(long _id, String patronName, String url) {
        this._id = _id;
        this.patronName = patronName;
        this.url = url;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PatronSimpleDTO{" +
                "_id=" + _id +
                ", patronName='" + patronName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
