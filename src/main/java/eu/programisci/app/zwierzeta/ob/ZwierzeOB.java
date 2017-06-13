package eu.programisci.app.zwierzeta.ob;

import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.enums.EPlec;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "zwierzeta")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_zwierzeta_id")
public class ZwierzeOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "dataUtworzenia", columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    @Column(name = "nazwa")
    private String nazwa;

    @Enumerated(EnumType.STRING)
    @Column(name = "gatunek")
    private EGatunek gatunek;

    @Enumerated(EnumType.STRING)
    @Column(name = "plec")
    private EPlec plec;

    @Column(name = "wiek")
    private Integer wiek;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date aDataUtworzenia) {
        dataUtworzenia = aDataUtworzenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String aNazwa) {
        nazwa = aNazwa;
    }

    public EGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(EGatunek aGatunek) {
        gatunek = aGatunek;
    }

    public EPlec getPlec() {
        return plec;
    }

    public void setPlec(EPlec aPlec) {
        plec = aPlec;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer aWiek) {
        wiek = aWiek;
    }
}
