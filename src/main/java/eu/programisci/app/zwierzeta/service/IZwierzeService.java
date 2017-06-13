package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;

import java.util.List;

public interface IZwierzeService {

    ZwierzeDTO findOne(Long id);

    List<ZwierzeDTO> findAllForTable();

    void deleteOne(Long id);

    ZwierzeDTO save(ZwierzeDTO userDTO);
}
