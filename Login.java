public class Login {
    public boolean Login (String user, String pass, RedBlackBST<String, String> loginInfo) {
    if (pass.equals(loginInfo.get(user)))
        return true;
    else
    return false;
    }
}
