package uz.pdp.appspringboot1.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReqDistrict {
    @NotBlank
    private String nameUz;
    @NotBlank
    private String nameRu;
    @NotBlank
    private String nameEn;
    @NotNull
    private Integer regionId;
}
