package com.formacion.marca.endpoints;

import com.formacion.core.controller.CommonController;
import com.formacion.core.json.page.PageJson;
import com.formacion.core.json.page.ResultJson;
import com.formacion.core.util.MessageConstants;
import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import com.formacion.marca.services.MarcaService;
import com.formacion.util.UrlConstants;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path =  UrlConstants.MARCA, produces = MediaType.APPLICATION_JSON_VALUE)

public class MarcaController extends CommonController {
    @Autowired
    private MarcaService service;

    @Operation(summary = "Obtenir marca per filtres", description = "Retorna el marca que coincideix amb els filtres")
    @GetMapping
    public ResultJson<PageJson<MarcaJson>> getAll(@ParameterObject MarcaFiltersJson filter, @ParameterObject Pageable pageable) {
        return commonUtils.getResultJsonByPaged(service.getAll(filter, pageable));
    }

    @Operation(summary = "Obtenir marca", description = "Retorna el marca que coincideix amb l'id ")
    @GetMapping(value = UrlConstants.PATH_ID)
    public ResponseEntity<ResultJson<MarcaJson>> getById(@PathVariable Long id) {
        ResultJson<MarcaJson> result = new ResultJson<>(service.getById(id), MessageConstants.SUCCES);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Crear marca", description = "Creació de marca")
    @PostMapping
    public ResultJson<MarcaJson> create(@RequestBody MarcaJson equipament) {
        return new ResultJson<>(service.create(equipament), MessageConstants.SUCCES);
    }

    @Operation(summary = "Modificar marca", description = "Modificació de marca")
    @PutMapping(value = UrlConstants.PATH_ID)
    public ResultJson<MarcaJson> update(@RequestBody MarcaJson equipament) {
        return new ResultJson<>(service.update(equipament), MessageConstants.SUCCES);
    }

    @Operation(summary = "Eliminar marca per id", description = "Eliminació del marca per id")
    @DeleteMapping(value = UrlConstants.PATH_ID)
    public ResultJson<Boolean> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResultJson<>(true);
    }

    @Operation(summary = "Eliminar marcas per llistat", description = "Eliminació de marcas per llistat")
    @DeleteMapping
    public ResultJson<List<ResultJson<MarcaJson>>> remove(@RequestBody List<Long> ids) {
        service.remove(ids);
        return new ResultJson<>(true);
    }
}
