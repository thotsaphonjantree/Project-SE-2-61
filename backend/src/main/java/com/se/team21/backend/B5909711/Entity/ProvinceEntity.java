package com.se.team21.backend.B5909711.Entity;

import lombok.*;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Province")
public class ProvinceEntity {
    @Id
    @SequenceGenerator(name="province_seq",sequenceName="province_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="province_seq")
    @Column(name="PROVINCE_ID",unique = true, nullable = false)
    private @NonNull Long provinceID;
    private @NonNull String provinceName;

    public ProvinceEntity(){}

    public Long getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Long provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
