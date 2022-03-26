import java.util.*;

class Animal{
    String species;
    String habitat;

    public Animal(String species, String habitat) {
        this.species = species;
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return (species+habitat).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Animal an = (Animal) obj;
        return (this.species == an.species) && (this.habitat == an.habitat);
    }
}

public class TestMain {

    public static void main(String[] args){
        HashSet<Animal> hash  = new HashSet<>();
        hash.add(new Animal("고양이","육지"));
        hash.add(new Animal("고양이","육지"));
        hash.add(new Animal("고양이","육지"));

        Iterator<Animal> it = hash.iterator();
        while(it.hasNext()){
            Animal an = it.next();
            // 내용이 같더라도 다른 주소에 할당되기 때문에 다른 해시값을 갖는다.
            System.out.println((an + "  | 해시코드 :")+an.hashCode());
        }

        System.out.println(hash.size());
    }

}
