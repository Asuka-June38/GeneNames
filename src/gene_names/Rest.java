package gene_names;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Rest {
//    public static ArrayList<String> httpGet(String urlStr) throws IOException {
//        URL url = new URL(urlStr);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        if (conn.getResponseCode() != 200) {
//            throw new IOException(conn.getResponseMessage());
//        } // Buffer the result into a string
//        BufferedReader rd = new BufferedReader(new InputStreamReader(
//                conn.getInputStream()));
//        ArrayList<String> sb = new ArrayList<String>();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.add(line.toString());
//        }
//        rd.close();
//        conn.disconnect();
//        return sb;
//    } // Returns strings from https file.
//
//    public static ArrayList<String> listOfStringsGet (){
//        ArrayList<String> stringsFromKegg = new ArrayList<String>();
//        String request = "http://rest.kegg.jp/list/hsa";
//        try {
//            stringsFromKegg = httpGet(request); // Asking for getting new string from file.
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return stringsFromKegg;
//    } // Returns list of strings from exact url.

    public static ArrayList<String> listOfStringsGet() throws IOException{
        ArrayList<String> stringsFromKegg = new ArrayList<String>();
        FileReader file = new FileReader("src/gene_names/hsa.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            stringsFromKegg.add(scan.nextLine());
        }
        file.close();
        return stringsFromKegg;
    } // Returns list of strings from exact file.

    public static ArrayList<ObjectFromKegg> getListOfObjects(ArrayList<String> listOfStrings) throws IOException{
        ArrayList<ObjectFromKegg> objectsFromKegg = new ArrayList<ObjectFromKegg>();
        for (String i : listOfStrings){
            String[] tokens = i.split("\\t"); // Making tokens from string.
            String[] tokens1 = tokens[1].split(";");
            String[] tokens10 = tokens1[0].split(", ");
            for (String token_gene : tokens10) {
                ObjectFromKegg serialObject = new ObjectFromKegg(); // Creating new object for every string using tokes.
                serialObject.geneName = token_gene;
                serialObject.hsa = tokens[0];
                objectsFromKegg.add(serialObject);
            }// Adding object to the list.
        }
        return objectsFromKegg;
    } // Returns list of objects from list of strings.

    public static ArrayList<String> getListOfNeededGenes() throws IOException{
        ArrayList<String> neededGenes = new ArrayList<String>();
        FileReader file = new FileReader("src/gene_names/GENE.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            neededGenes.add(scan.nextLine());
        }
        file.close();
        return neededGenes;
    } // Returns list of needed genes.

    public static ArrayList<ObjectFromKegg> getNeededGenesWithHsa(ArrayList<String> listOfNeededGenes, ArrayList<ObjectFromKegg> listOfObjects) throws IOException{
        ArrayList<ObjectFromKegg> neededGenesWithHsa = new ArrayList<ObjectFromKegg>();
            for (String j : listOfNeededGenes){
                int a = 0;
                while (!listOfObjects.get(a).geneName.equals(j.trim()))
                    a++;
                neededGenesWithHsa.add(listOfObjects.get(a));
            }
        return neededGenesWithHsa;
    } // Returns list of needed genes with hsa.
}


