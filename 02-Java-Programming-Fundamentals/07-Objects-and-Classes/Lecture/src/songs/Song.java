package songs;

public class Song {

    private String typeList;
    private String name;
    private String time;


    public Song(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public String getTypeList() {
        return this.typeList;
    }

    public String getName() {
        return this.name;
    }
}
