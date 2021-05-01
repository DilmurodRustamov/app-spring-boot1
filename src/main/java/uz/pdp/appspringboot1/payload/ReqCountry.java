package uz.pdp.appspringboot1.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class ReqCountry {

    @NotBlank(message = "Karochi bosh emas")
    private String nameUz;

    @NotBlank(message = "Karochi bosh emas")
    private String nameRu;

    @NotBlank(message = "Karochi bosh emas")
    private String nameEn;

}
