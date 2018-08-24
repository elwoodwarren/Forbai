public class Encrypt {
    // hashes the password
    public static int encrypt(String p) {
        int hash = 7;
        for (int i = 0; i < p.length(); i++) {
            hash = hash*31 + p.charAt(i);
        }
        return hash;
    }
}
