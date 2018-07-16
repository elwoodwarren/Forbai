public class Login {
    public boolean Login (String email, String pass, RedBlackBST<String, String> loginInfo) {
    if (pass.equals(loginInfo.get(email)))
        return true;
    else
    return false;
    }
}
