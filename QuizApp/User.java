
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    private String username;
    private final long UID;
    private String password;
    private static long UIDCount = 0;
    User(String username, String password){
        this.username = username;
        this.password = password;
        UID = assignUID();
    }
    private static long assignUID(){
        return UIDCount++;
    }
}
