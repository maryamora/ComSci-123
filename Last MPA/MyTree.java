/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public class MyTree{
    private Folder head;
    private Folder currentFile;
    private String path = "";

    public MyTree(){
        head = new Folder("root");
        head.setParent(null);
        currentFile = head;
    }

    public void printPath(){
        path = "";
        Files temp;
        temp = currentFile;
        while (temp != null){
            path = "/"+temp.getFileName()+ path;
            temp = temp.getParent();
        }
        System.out.print(path+ "> ");
    }

    public void changeDirectory(String fileName){
        if (currentFile.findThisFolder(fileName) != null) {
            currentFile = currentFile.findThisFolder(fileName);
        }else{
            System.out.println(fileName+ " not found.");
        }
    }

    public void previousDirectory(){
        if (currentFile.getParent() != null){
            currentFile = currentFile.getParent();
        }else {
            System.out.println("End of directory. Cannot go to previous.");
        }
    }

    public void displayItems(){
        currentFile.displayItems();
    }

    public void addFolder(String fileName){
        if (currentFile.findThisFolder(fileName) == null){
            currentFile.addFolder(fileName);
        }else{
            System.out.println("A folder has already been named "+fileName+". Rename current folder or rename folder to be added.");
        }
    }

    public void editText(String fileName){
        if (currentFile.hasText(fileName)){
            currentFile.getTextFile(fileName).appendText();
        }else{
            currentFile.addText(fileName);
        }
    }

    public void rename(String originalFileName, String newFileName){
        if (currentFile.hasText(originalFileName)) {
            currentFile.getTextFile(originalFileName).rename(newFileName);
        }else{
            System.out.println(originalFileName+ " not found.");
        }
    }

    public void remove(String fileName){
        if (currentFile.findThisFolder(fileName) != null){
            currentFile.removeDir(fileName);
        }else{
            System.out.println(fileName+" not found.");
        }
    }

    public void removeFile(String fileName){
        if (currentFile.hasText(fileName)){
            currentFile.removeText(fileName);
        }else{
            System.out.println(fileName+" not found.");
        }
    }
}
