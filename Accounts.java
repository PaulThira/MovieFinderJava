import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Accounts {
    private LinkedList<Person> listOfAccounts;
    public void AddAccount(Person P){
        listOfAccounts.push(P);
    }
    public boolean SearchFor(String names,String passwords){
        Person james = listOfAccounts.stream()
                .filter(customer -> names.equals(customer.getName()))
                .findAny()
                .orElse(null);
        if(james==null){
            System.out.println("account not found or wrong password");
            return false;
        }
        else{
            for(int i=0;i<listOfAccounts.size();i++){
                if(listOfAccounts.get(i)==james){
                    listOfAccounts.get(i).LogIn();
                    System.out.println("Login successful!");
                    return true;
                }
            }
        }
        return false;
    }
    public void LookingForWho(String names){
        LinkedList<String>AccountNames=new LinkedList<String>();
        for(int i=0;i<listOfAccounts.size();i++){
            AccountNames.push(listOfAccounts.get(i).getName());
        }
        Pattern pattern = Pattern.compile(names, Pattern.CASE_INSENSITIVE);
        LinkedList<Matcher> SimilarPeople=new LinkedList<Matcher>();
        for(int i=0;i<listOfAccounts.size();i++){
            SimilarPeople.push(pattern.matcher(names));
        }

        for(int i=0;i<listOfAccounts.size();i++){
            if(SimilarPeople.get(i).find()==true){
                listOfAccounts.get(i).Print();
            }
        }
    }
public Accounts(){
        listOfAccounts=new LinkedList<Person>();
}


}
