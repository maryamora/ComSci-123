import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public class General {
    public static void main(String[] args) throws IOException {

        //create head of folder
        Scanner command = new Scanner(System.in);
        CommandReader process = new CommandReader();

        if (args.length >= 1){
            //process.fileHandling(args[0]);
            //the file handling is not working properly, sir. haven't tested it, and it lacks the edit text part
        }

        //the console based cmd simulator works properly
        while (process.notExit()){
            process.doThis("path");
            process.doThis(command.nextLine());
        }

    }
}
