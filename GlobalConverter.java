import java.util.Scanner;

public class GlobalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String base = "";
        boolean validBase = false;

        // Saisie de la chaîne de caractères à traduire
        System.out.print("Entrez une chaîne de caractères à traduire : ");
        input = scanner.nextLine();

        // Vérification de la validité de la chaîne de caractères entrée par l'utilisateur
        if (!isValidInput(input)) {
            System.out.println("Erreur : la chaîne de caractères contient des caractères non valides. Utilisez uniquement des lettres, des chiffres, des accents et des espaces.");
            scanner.close();
            return;
        }

        // Vérification de la base de traduction
        if (args.length > 0) {
            base = args[0].toLowerCase();
            if (base.equals("-h")) {
                base = "hexadecimal";
            } else if (base.equals("-o")) {
                base = "octal";
            } else if (base.equals("-d")) {
                base = "decimal";
            } else if (base.equals("-b")) {
                base = "binary";
            } else if (base.equals("-t")) {
                base = "text";
            }
            validBase = true;
        } else {
            do {
                System.out.print("Entrez la base de traduction souhaitée (hexadecimal, octal, decimal, binary, text) : ");
                base = scanner.nextLine().toLowerCase();
                if (base.equals("hexadecimal") || base.equals("octal") || base.equals("decimal") || base.equals("binary") || base.equals("text") || base.equals("-h") || base.equals("-o") || base.equals("-d") || base.equals("-b") || base.equals("-t")) {
                    validBase = true;
                } else {
                    System.out.println("Erreur : la base de traduction n'est pas valide.");
                }
            } while (!validBase);
        }

        // Conversion de la chaîne de caractères en valeurs ASCII
        int[] asciiValues = convertToASCII(input);

        // Conversion des valeurs ASCII en chaîne de caractères traduite
        String convertedString = convertFromASCII(asciiValues, base);

        // Affichage de la chaîne de caractères traduite
        System.out.println("Chaîne de caractères traduite : " + convertedString);

        scanner.close();
    }

    // Méthode pour convertir une chaîne de caractères en tableau d'entiers contenant les valeurs ASCII de chaque caractère
    public static int[] convertToASCII(String input) {
        int[] asciiValues = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            asciiValues[i] = (int) input.charAt(i);
        }
        return asciiValues;
    }

    // Méthode pour convertir un tableau d'entiers contenant les valeurs ASCII en chaîne de caractères traduite dans la base souhaitée
    public static String convertFromASCII(int[] asciiValues, String base) {
        StringBuilder convertedString = new StringBuilder();
        for (int i = 0; i < asciiValues.length; i++) {
            convertedString.append(convertValue(asciiValues[i], base));
        }
        return convertedString.toString();
    }

    // Méthode pour convertir une valeur ASCII en chaîne de caractères traduite dans la base souhaitée
    public static String convertValue(int value, String base) {
        String result = "";
        if (base.equals("hexadecimal") || base.equals("-h")) {
            result = Integer.toHexString(value);
        } else if (base.equals("octal") || base.equals("-o")) {
            result = Integer.toOctalString(value);
        } else if (base.equals("decimal") || base.equals("-d")) {
            result = Integer.toString(value);
        } else if (base.equals("binary") || base.equals("-b")) {
            result = Integer.toBinaryString(value);
        } else if (base.equals("text") || base.equals("-t")) {
            result = Character.toString((char) value);
        }
        return result;
    }

    // Méthode pour vérifier la validité de la chaîne de caractères entrée par l'utilisateur
    public static boolean isValidInput(String input) {
        return input.chars().allMatch(c -> Character.isLetterOrDigit(c) || Character.isSpaceChar(c) || isAccent(c));
    }

    // Méthode pour vérifier si un caractère est une lettre accentuée
    public static boolean isAccent(int c) {
        return String.valueOf((char) c).matches("[\\p{L}&&[\\p{M}]]");
    }
}

