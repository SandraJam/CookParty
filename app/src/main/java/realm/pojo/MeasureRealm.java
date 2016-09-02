package realm.pojo;

import com.example.octo_sdu.core.coreRecipes.model.Measure;

import io.realm.RealmObject;

public class MeasureRealm extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure realmToPojo() {
        return new Measure(name);
    }
}
