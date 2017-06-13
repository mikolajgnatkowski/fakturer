package eu.programisci.app.zwierzeta.converters;

import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TowarConverter {

    public ZwierzeDTO obToDto(ZwierzeOB in) {
        ZwierzeDTO out = new ZwierzeDTO();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setCenaNetto(in.getCenaNetto());
        out.setPkwiu(in.getPkwiu());
        out.setVat(in.getVat());
        return out;
    }

    public ZwierzeOB dtoToOb(ZwierzeDTO in) {
        ZwierzeOB out = new ZwierzeOB();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setCenaNetto(in.getCenaNetto());
        out.setPkwiu(in.getPkwiu());
        out.setVat(in.getVat());
        return out;
    }


    public List<ZwierzeDTO> obListToDtoList(List<ZwierzeOB> inList) {
        if (inList == null) {
            return null;
        }
        List<ZwierzeDTO> outList = new ArrayList<>();
        for (ZwierzeOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
