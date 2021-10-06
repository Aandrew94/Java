package C22_Colectia_LinkedList;

public class Town implements Comparable<Town> {
    private String name;
    private int km;

    public Town(String name, int km){
        this.name = name;
        this.km = km;
    }

    @Override
    public String toString(){
        return this.name + " " + this.km;
    }


    @Override
    public int compareTo(Town o) {
        if(this.km < o.km)  return -1;
        else if (this.km == o.km)   return 0;
        else return 1;
    }
}
