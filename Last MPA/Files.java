/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public abstract class Files {
    private String fileName;
    private Folder parent;

    public Files(){
        fileName = "untitled";
    }
    public Files(String fileName){
        this.fileName = fileName;
    }

    public void rename(String newName){
        fileName = newName;
    }

    public String getFileName(){
        return fileName;
    }

    public void setParent(Folder thisFolder) {
        parent = thisFolder;
    }

    public Folder getParent(){return parent;}
}
