import java.util.ArrayList;

/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public class Folder extends Files {
    private ArrayList<Files> filesInside = new ArrayList<>();

    public Folder(){super();}

    public Folder(String fileName){super(fileName);}

    public void addFolder(String fileName) {
        Files newFolder = new Folder(fileName);
        newFolder.setParent(this);
        filesInside.add(newFolder);
    }

    public void addText(String fileName){
        Files newText = new Text(fileName);
        newText.setParent(this);
        filesInside.add(newText);
    }

    public void removeText(String fileName){
        int i = 0;
        for (Files f: filesInside){
            if (f.getFileName().equals(fileName) && f instanceof Text){
                filesInside.remove(i);
                break;
            }
            i++;
        }
    }

    public Folder findThisFolder(String fileName) {
        for (Files f : filesInside) {
            if (f instanceof Folder){
                if (f.getFileName().equals(fileName)){
                    return (Folder) f;
                }
            }
        }
        return null;
    }

    public boolean hasText(String fileName) {
        for (Files f : filesInside) {
            if (f instanceof Text){
                if (f.getFileName().equals(fileName)){
                    return true;
                }
            }
        }
        return false;
    }

    public Text getTextFile(String fileName) {
        for (Files f : filesInside) {
            if (f instanceof Text){
                if (f.getFileName().equals(fileName)){
                    return (Text) f;
                }
            }
        }
        return null;
    }



    public void displayItems(){
        for (Files f: filesInside){
            System.out.println(f.getFileName());
        }
    }

    public void removeDir(String fileName){
        int i = 0;
        for (Files f: filesInside){
            if (f.getFileName().equals(fileName) && f instanceof Folder){
                filesInside.remove(i);
                break;
            }
            i++;
        }
    }
}
