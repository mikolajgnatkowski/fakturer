package eu.programisci.app.zwierzeta.repository;


import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITowarRepository extends JpaRepository<ZwierzeOB,Long> {

    // metoda zwraca wszystkie towary z identyczna nazwa
    List<ZwierzeOB> findByNazwa(String aNazwa);

    // metoda zwraca wszystkie towary zaczynajace sie od przekazanego stringa, jest czula na rozmiar liter, wyniki sa posortowane "blizej nieokreslonym algorytmem"
    List<ZwierzeOB> findByNazwaStartingWith(String aNazwa);

    // metoda zwraca wszystkie towary zawierajace przekazany string, jest nieczula na rozmiar liter i sortuje rosnaco po ID
    // nalezy pamietac, ze w przypadku metody LIKE nalezy do stringa dokleic wildcardy
    List<ZwierzeOB> findByNazwaLikeIgnoreCaseOrderByIdDesc(String aNazwa);

    // to samo co powyzsza metoda, lecz z uzyciem zapytania JPQL, wildcardy sa doklejane wewnatrz zapytania
    // w tym przypadku nazwa metody nie ma znaczenia, warto jednak trzymac sie przyjetego w aplikacji standardu
    // poprzez ?1 odnosimy sie do pierwszego parametru
    @Query("SELECT t FROM ZwierzeOB t WHERE upper(t.nazwa) LIKE upper(concat('%', ?1, '%')) ORDER BY t.id ASC")
    List<ZwierzeOB> znajdzLikeNazwaICbyIdAsc(String aNazwa);

    // to samo co powyzsza metoda, lecz zastepujemy niepewne odniesienie do parametru czyms lepszym
    @Query("SELECT t FROM ZwierzeOB t WHERE upper(t.nazwa) LIKE upper(concat('%', :nazwa, '%')) ORDER BY t.id ASC")
    List<ZwierzeOB> znajdzLikeNazwaICbyIdAscParam(@Param("nazwa") String aNazwa);

    // metoda wyszukuje wszystkie towary, lecz wyniki mapuje bezposrednio na TowarLightDTO
    @Query("SELECT new eu.programisci.app.towary.dto.TowarLightDTO(t.id, t.nazwa, t.cenaNetto) FROM ZwierzeOB t")
    List<TowarLightDTO> znajdzWszystkieWersjaLight();

    // metoda wyszukuje towary powyzej okreslonej w parametrze ceny, sortuje je wg ceny rosnaco i zwraca liste TowarLightDTO
    @Query("SELECT new eu.programisci.app.towary.dto.TowarLightDTO(t.id, t.nazwa, t.cenaNetto) FROM ZwierzeOB t WHERE t.cenaNetto > :cenaNetto ORDER BY t.cenaNetto ASC")
    List<TowarLightDTO> znajdzWszystkiePowyzejCeny(@Param("cenaNetto") Double aCenaNetto);

    // metoda robi dokladnie to co .findOne, z bazy mozna pozyskac jeden wynik, lecz trzeba byc pewnym, ze zapytanie nie moze zwrocic wiecej niz jednego
    // w przypadku znalezienia wiecej niz 1 wyniku operacja zakonczylaby sie bledem, dlatego takie operacje powinno sie wykonywac tylko na kolumnach z
    // constraintami unique lub PK (lub na zestawienaich unikalnych)
    @Query("SELECT t FROM ZwierzeOB t WHERE t.id = :id")
    ZwierzeOB znajdzPoId(@Param("id") Long aId);

    // metoda updatujaca (podobnie mozna uzyc usuwajacej) - wymaga transakcji oraz @Modifying do dzialania
    @Modifying
    @Query("UPDATE ZwierzeOB SET nazwa = :nazwa")
    void forceUpdate(@Param("nazwa") String aNazwa);
}
