import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    private long id;
    private String tile;
    @Transient
    private Set adverts = new HashSet();

    public Category(String tile, Set adverts) {
        this.tile = tile;
        this.adverts = adverts;
    }

    public Category() {
    }

    public Category(String tile) {
        this.tile = tile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public Set getAdverts() {
        return adverts;
    }

    public void setAdverts(Set adverts) {
        this.adverts = adverts;
    }
}