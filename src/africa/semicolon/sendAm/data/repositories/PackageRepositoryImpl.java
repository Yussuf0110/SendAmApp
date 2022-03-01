package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository {

     private List<Package> db = new ArrayList<>();
     private int id =0;

    @Override
    public Package save(Package aPackage) {
        int id = generateId();
        aPackage.setId(id);
        db.add(aPackage);
        return aPackage;
//        return db.get(id-1);
    }

    private int generateId() {
        return ++id;
//        return id;
//        return db.size()+1;
    }

    @Override
    public Package findById(int id) {
        for (Package aPackage : db) {
            if (aPackage.getId() == id)
                return aPackage;
            }
            return null;
        }


    @Override
    public List<Package> findAll() {
        return db;
    }

    @Override
    public void delete(Package aPackage) {
    db.remove(aPackage);
    }

    @Override
    public void delete(int id){
    Package foundPackage = findById(id);
//    db.remove(foundPackage);
    delete(foundPackage);

    }

    @Override
    public int count() {
        return db.size();
    }
}
