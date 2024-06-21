package BackEnd;
public class CaesarCipher {
    public static String encrypt(String input, int key) {
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char newChar = (char) ((c + key - (c >= 'a' ? 97 : 65)) % 26 + (c >= 'a' ? 97 : 65));
                encryptedString.append(newChar);
            } else {
                encryptedString.append(c);
            }
        }
        return encryptedString.toString();
    }

    public static String decrypt(String input, int key) {
        return encrypt(input, -key);
    }
}
