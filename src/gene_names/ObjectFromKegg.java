package gene_names;

public class ObjectFromKegg {
    public String hsa;
    public String geneName;

    public ObjectFromKegg(){
        hsa = "HSA";
        geneName = "geneName";
    }

    public ObjectFromKegg(String hsa, String geneName){
        this.hsa = hsa;
        this.geneName = geneName;
    }

    public String objectToString(){
        String object = (this.geneName + " " + this.hsa);
        System.out.println(object);
        return object;
    }
}
