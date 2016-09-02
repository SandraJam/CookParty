package realm;

import realm.pojo.MeasureRealm;
import com.example.octo_sdu.core.coreRecipes.MeasuresRepository;
import com.example.octo_sdu.core.coreRecipes.model.Measure;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MeasuresRepositoryRealmImpl implements MeasuresRepository {

    @Override
    public void add(String name) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        MeasureRealm measureRealm = realm.createObject(MeasureRealm.class);
        measureRealm.setName(name);
        realm.commitTransaction();
    }

    @Override
    public List<Measure> allMeasures() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<MeasureRealm> measureRealms = realm.where(MeasureRealm.class).findAll();
        List<Measure> measures = new ArrayList<>();
        for (MeasureRealm mes: measureRealms) {
            measures.add(mes.realmToPojo());
        }
        return measures;
    }

    @Override
    public int checkFirstTime() {
        final Realm realm = Realm.getDefaultInstance();
        return realm.where(MeasureRealm.class).findAll().size();
    }
}
