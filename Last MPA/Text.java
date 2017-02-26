import java.util.Scanner;

/**
 * Created by Mary Danielle C. Amora on 12/10/2016.
 */
public class Text extends Files {
    private String text;
    private Scanner scan;
    private  int enter;
    public Text(){
        super();
        text = "";
    }

    public Text(String fileName){
        super(fileName);
        scan = new Scanner(System.in);
        enter = 0;
        text = "";
    }

    public void appendText(){
        if (text != ""){
            System.out.print(text);
        }
        String temp;
        while (true){
            temp = scan.nextLine();
            if (temp == null || temp.length() < 1){
                enter++;
            }else{
                enter = 1;
                text = text + temp + "\n";
            }
            if (enter > 1){
                break;
            }

        }

    }

    public void showText(){
        System.out.println(text);
    }

}
