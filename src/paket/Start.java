package paket;

import java.io.File;
import java.net.URL;

public class Start
{
    public static void main(String args[]) throws Exception
    {
        Funkcije f = new Funkcije();

        System.out.println("\nBRUT v0.1 - napad recnikom na HTTP autentifikaciju");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Autor: Stevan Cvetkovic");
        System.out.println("E-posta: cvetkovic.stevan@gmail.com");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        if(args.length != 2)
        {
            System.out.println("Pokretanje: java -jar brut-0.1.jar URLAdresa recnik.txt");
            System.out.println("Obavezna upotreba \"http://\" prefiksa URL adrese, npr: http://www.sajt.com\n");
            System.exit(0);
        }

        f.napad(new URL(args[0]), new File(args[1]));
    }
}
