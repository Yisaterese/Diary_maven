package data.models;
import lombok.Getter;
public class Diary {
    @Getter
    private String userName;
    @Getter
    private String password;
    private boolean isLocked;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {this.password = password;}
    public void setLock(boolean trueOrFalse) {
        isLocked = trueOrFalse;
    }
    public boolean isLocked(){ return isLocked = false;}

    public boolean isUnlocked() {
        return isLocked = true;
    }

    public Entry getEntry() {
        return null;
    }

}
