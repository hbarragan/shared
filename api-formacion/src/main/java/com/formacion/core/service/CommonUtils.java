package com.formacion.core.service;

import com.formacion.core.json.page.PageJson;
import com.formacion.core.json.page.ResultJson;
import com.formacion.core.util.MessageConstants;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class CommonUtils<T> {
    public ResultJson getResultJsonByPaged(Page<T> resultatPaginat) {
        return new ResultJson(new PageJson<>(resultatPaginat.getContent(), resultatPaginat.getSize(),
                resultatPaginat.getTotalElements()), MessageConstants.SUCCES);
    }
}
