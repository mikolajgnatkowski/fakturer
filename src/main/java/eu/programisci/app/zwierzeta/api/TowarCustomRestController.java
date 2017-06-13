package eu.programisci.app.zwierzeta.api;

import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.service.IZwierzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/towar")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TowarCustomRestController {

    @Autowired
    private IZwierzeService towarService;

    @RequestMapping(value = "/findByNazwa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> findByNazwa(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwa(aNazwa);
    }

    @RequestMapping(value = "/findByNazwaStartingWith", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> findByNazwaStartingWith(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwaStartingWith(aNazwa);
    }

    @RequestMapping(value = "/findByNazwaLikeIgnoreCaseOrderByIdDesc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> findByNazwaLikeIgnoreCaseOrderByIdDesc(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwaLikeIgnoreCaseOrderByIdDesc("%" + aNazwa + "%");
    }

    @RequestMapping(value = "/znajdzLikeNazwaICbyIdAsc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> znajdzLikeNazwaICbyIdAsc(@RequestParam("nazwa") String aNazwa) {
        return towarService.znajdzLikeNazwaICbyIdAsc(aNazwa);
    }

    @RequestMapping(value = "/znajdzLikeNazwaICbyIdAscParam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> znajdzLikeNazwaICbyIdAscParam(@RequestParam("nazwa") String aNazwa) {
        return towarService.znajdzLikeNazwaICbyIdAscParam(aNazwa);
    }

    @RequestMapping(value = "/znajdzWszystkieWersjaLight", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarLightDTO> znajdzWszystkieWersjaLight() {
        return towarService.znajdzWszystkieWersjaLight();
    }

    @RequestMapping(value = "/znajdzWszystkiePowyzejCeny", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarLightDTO> znajdzWszystkiePowyzejCeny(@RequestParam("cenaNetto") Double aCenaNetto) {
        return towarService.znajdzWszystkiePowyzejCeny(aCenaNetto);
    }

    @RequestMapping(value = "/znajdzPoId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZwierzeDTO znajdzPoId(@RequestParam("id") Long aId) {
        return towarService.znajdzPoId(aId);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ZwierzeDTO> init() {
        return towarService.init();
    }

    @RequestMapping(value = "/forceUpdate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void forceUpdate(@RequestParam("nazwa") String aNazwa) {
        towarService.forceUpdate(aNazwa);
    }
}
