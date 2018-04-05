package gene_names;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static gene_names.Rest.*;

public class Application {
    public static void main (String[] args) throws IOException {
        ArrayList<ObjectFromKegg> objectsFromKegg = new ArrayList<ObjectFromKegg>();
        objectsFromKegg = getListOfObjects(listOfStringsGet());

        ArrayList<String> listOfNeededGenes = new ArrayList<String>();
        listOfNeededGenes = getListOfNeededGenes();

        ArrayList<ObjectFromKegg> neededGenesWithHsa = new ArrayList<ObjectFromKegg>();
        neededGenesWithHsa = getNeededGenesWithHsa(listOfNeededGenes, objectsFromKegg);

        FileWriter result = new FileWriter("src/gene_names/result.txt");
        for (ObjectFromKegg b : neededGenesWithHsa) {
            result.write(b.objectToString());
            result.write('\n');
        }
        result.close();
    }
}
