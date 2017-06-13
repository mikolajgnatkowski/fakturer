package eu.programisci.app.zwierzeta.dto;

import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.enums.EPlec;

public class ZwierzeDTO {

    private Long id;
    private String nazwa;
    private EGatunek gatunek;
    private EPlec plec;
    private Integer wiek;

    public ZwierzeDTO() {
    }

    public ZwierzeDTO(Long aId, String aNazwa, EGatunek aGatunek, EPlec aPlec, Integer aWiek) {
        id = aId;
        nazwa = aNazwa;
        gatunek = aGatunek;
        plec = aPlec;
        wiek = aWiek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
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
