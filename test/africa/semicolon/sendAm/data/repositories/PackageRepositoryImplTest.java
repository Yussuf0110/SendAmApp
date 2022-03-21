package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PackageRepositoryImplTest {
    private PackageRepository packageRepository = new PackageRepositoryImpl();

//    @BeforeEach
//     public void setUp(){
//        packageRepository = new PackageRepositoryImpl();
//    }

    @Test
    public void repositorySaveTest() {
//        given there is a package
        Package aPackage = new Package();
//        when i try to save in the repository
        Package savedPackage = packageRepository.save(aPackage);
//        assert that the returned has an id
        assertEquals(1,savedPackage.getId());
//         assert the count is 1
        assertEquals(1,packageRepository.count());
    }

    @Test
    public void repositoryFindIdTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        Package foundPackage = packageRepository.findById(2);
        assertEquals(secondPackage,foundPackage);
        assertEquals(2,secondPackage.getId());
    }

@Test
    public void deleteByIdTest(){
    saveThreePackages();

    packageRepository.delete(2);
    assertEquals(2,packageRepository.count());
}

private void  saveThreePackages(){
    Package firstPackage = new Package();
    Package secondPackage = new Package();
    Package thirdPackage = new Package();
    packageRepository.save(firstPackage);
    packageRepository.save(secondPackage);
    packageRepository.save(thirdPackage);
}
@Test
   public void findByIdWorks_afterADeleteTest(){
        saveThreePackages();
        packageRepository.delete(2);

        Package foundPackage = packageRepository.findById(2);
        assertNull(foundPackage);

}

@Test
    public void saveAfterADelete_givesCorrectPackageIdTest(){
        saveThreePackages();
        packageRepository.delete(1);
        Package savedPackage = packageRepository.save(new Package());
        assertEquals(4,savedPackage.getId());

}

@Test
    public void deleteByPackage(){
    Package firstPackage = new Package();
    Package secondPackage = new Package();
    Package thirdPackage = new Package();
    packageRepository.save(firstPackage);
    packageRepository.save(secondPackage);
    packageRepository.save(thirdPackage);

    packageRepository.delete(secondPackage);

    assertEquals(2,packageRepository.count());
    assertNull(packageRepository.findById(2));
}

@Test
    public void findAllTest(){
        saveThreePackages();

    List<Package> all = packageRepository.findAll();

    assertEquals(3,all.size());
}




}