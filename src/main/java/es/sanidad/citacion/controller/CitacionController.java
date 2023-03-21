package es.sanidad.citacion.controller;

import es.sanidad.citacion.entity.Citacion;
import es.sanidad.citacion.model.CitacionBusquedaDto;
import es.sanidad.citacion.model.CitacionCreacionDto;
import es.sanidad.citacion.model.CitacionListadoDto;
import es.sanidad.citacion.service.CitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CitacionController {

  private final CitacionService citacionService;

  private static final String PAGE_CITACION_LIST   = "web/pages/citacion/citacion-list";
  private static final String PAGE_CITACION_CREATE   = "";

  @GetMapping("/")
  public String initView(Model model, CitacionBusquedaDto citacionBusquedaDto) {
    if(citacionBusquedaDto.getObservacion() != null && citacionBusquedaDto.getUrgente() != null
            && citacionBusquedaDto.getDoctor() != null) {
      model.addAttribute("page", citacionService.busquedaCitacion(citacionBusquedaDto));
    } else  {
      model.addAttribute("page", citacionService.busquedaTodasCitaciones());
    }
    CitacionCreacionDto citacionCreacionDto = new CitacionCreacionDto();
    
    // Add the form-backing bean to the model attributes
    model.addAttribute("citacionCreacionDto", citacionCreacionDto);

    model.addAttribute("citacionBusquedaDto", citacionBusquedaDto);
    return PAGE_CITACION_LIST;
  }
  @GetMapping("/createModal")
  public String register()
  {
      return PAGE_CITACION_CREATE;
  }

  @PostMapping("/create")
  public String createView(CitacionCreacionDto citacionCreacionDto) {
      citacionService.creacionCitacion(citacionCreacionDto);
      return PAGE_CITACION_CREATE;
  }
  
}
