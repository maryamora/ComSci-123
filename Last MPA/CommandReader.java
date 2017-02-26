import java.io.*;

/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public class CommandReader {
    private boolean onGoing;
    private String command;
    private String[] line;
    private String commandOne = "mkdir";
    private String commandTwo = "rmdir";
    private String commandThree = "cd";
    private String commandFour = "cd..";
    private String commandFive = "edit";
    private String commandSix = "rm";
    private String commandSeven = "rn";
    private String commandShowAll = "ls";
    private String commandPrintPath = "path";
    private String commandExit = "exit";
    private MyTree thisFolder;
    private int runOn;
    private BufferedWriter bw;

    public CommandReader(){
        command = null;
        onGoing = true;
        thisFolder = new MyTree();
        runOn = 1;

        try {

            File file = new File("output.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            bw = new BufferedWriter(new FileWriter(file));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileHandling(String args){
        runOn = 1;
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(args));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                //doThis("path");
                //doThis(sCurrentLine);
            }

            System.out.println("-End of File--");
            runOn = 2;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public boolean notExit(){
        return onGoing;
    }

    public void doThis(String commandLine) throws IOException {
        try {
            command = parseThis(commandLine);
            execute();
        }catch(ArrayIndexOutOfBoundsException e){
            wrongCommand();
        }
    }

    public void execute() throws IOException {
        if (line[0] == null){
            wrongCommand();
        }else if (command.equals(commandPrintPath)) {
            thisFolder.printPath();
        } else if (command.equals(commandExit)) {
            onGoing = false;
        } else if (command.equals(commandShowAll)) {
            thisFolder.displayItems();
        } else if (command.equals(commandFour)) {
            thisFolder.previousDirectory();
        }else if (line[1] == null || line[1] == " " || line[1] == ""){
            wrongCommand();
        } else if (command.equals(commandOne)) {
            thisFolder.addFolder(line[1]);
        } else if (command.equals(commandTwo)) {
            thisFolder.remove(line[1]);
        } else if (command.equals(commandThree)) {
            thisFolder.changeDirectory(line[1]);
        } else if (command.equals(commandFive)) {
            thisFolder.editText(line[1]);
        } else if(command.equals(commandSix)){
            thisFolder.removeFile(line[1]);
        }else if(command.equals(commandSeven)){
            if (line[1] != null && line[2] != null){
                thisFolder.rename(line[1], line[2]);
            }else{
                if (runOn == 1){
                    bw.write("Renaming files need two parameters: the file intended to be renamed and the new name of the file.");
                }
                System.out.println("Renaming files need two parameters: the file intended to be renamed and the new name of the file.");
            }
        }else {
            wrongCommand();
        }
    }

    public void wrongCommand() throws IOException {
        System.out.println("Command not recognized.");
        if (runOn == 1) {
            bw.write("Command not recognized");
        }
    }

    public String parseThis(String commandLine) throws IOException {
        try {
            line = commandLine.split(" ");

        }catch(ArrayIndexOutOfBoundsException e){
            wrongCommand();
            line[0] = null;
            line[1] = null;
        }

        return line[0];
    }
}
