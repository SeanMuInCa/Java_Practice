public class RandomCharacter
{
    public static char getRandomLetter(char c1, char c2) {
        return (char) (c1 + Math.random() * (c2 - c1 + 1));
    }
    public static char getRandomLetterInUppercase() {
        return getRandomLetter('A','Z');
    }
    public static char getRandomLetterInLowercase() {
        return getRandomLetter('a','z');
    }
    public static char getRandomDigit() {
        return getRandomLetter('0','9');
    }
    public static char getRandomCharacter() {
        return getRandomLetter('\u0000','\uFFFF');
    }
}
