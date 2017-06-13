package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.converters.TowarConverter;
import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import eu.programisci.app.zwierzeta.repository.ITowarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ZwierzeServiceImpl implements IZwierzeService {

    @Autowired
    private ITowarRepository towarRepository;

    @Autowired
    private TowarConverter towarConverter;

    @Override
    public ZwierzeDTO findOne(Long id) {
        ZwierzeOB ob = towarRepository.findOne(id);
        ZwierzeDTO dto = towarConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<ZwierzeDTO> findAllForTable() {
        List<ZwierzeOB> obList = towarRepository.findAll();
        List<ZwierzeDTO> dtoList = towarConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        towarRepository.delete(id);
    }

    @Override
    public ZwierzeDTO save(ZwierzeDTO dto) {
        if (dto.getId() == null) {
            return towarConverter.obToDto(create(dto));
        } else {
            return towarConverter.obToDto(update(dto));
        }
    }

    private ZwierzeOB create(ZwierzeDTO dto) {
        ZwierzeOB ob = towarConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = towarRepository.save(ob);
        return ob;
    }

    private ZwierzeOB update(ZwierzeDTO dto) {
        ZwierzeOB ob = towarRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setJednostkaMiary(dto.getJednostkaMiary());
        ob.setCenaNetto(dto.getCenaNetto());
        ob.setPkwiu(dto.getPkwiu());
        ob.setVat(dto.getVat());
        ob = towarRepository.save(ob);
        return ob;
    }
}
