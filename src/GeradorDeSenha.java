import java.util.Random;

public class GeradorDeSenha {
    public static final String LOWERCASE_CARACTERES = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "123456789";
    public static final String SPECIAL_SIMBOLOS = "!@#$%*()_+[]{};.<>,/?&^=-";

    private final Random random;

    public GeradorDeSenha(){random = new Random();}

    public String gerarSenha(int tamanho,boolean incluirUpperCase, boolean incluirLowerCase,
                             boolean incluirNumeros,boolean incluirSimbolos){
        StringBuilder senhaBuilder = new StringBuilder();

        String caracteresValidos = "";
        if (incluirUpperCase) caracteresValidos += UPPERCASE_CARACTERES;
        if (incluirLowerCase) caracteresValidos += LOWERCASE_CARACTERES;
        if (incluirNumeros) caracteresValidos += NUMBERS;
        if (incluirSimbolos) caracteresValidos += SPECIAL_SIMBOLOS;

        for (int i = 0; i < tamanho; i++){

            int randomIndex = random.nextInt(caracteresValidos.length());

            char randomChar = caracteresValidos.charAt(randomIndex);

            senhaBuilder.append(randomChar);

        }

        return senhaBuilder.toString();
    }
}
