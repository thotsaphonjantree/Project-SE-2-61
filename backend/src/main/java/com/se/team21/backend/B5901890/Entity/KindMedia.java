package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="KindMedia")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class KindMedia {
    @Id
    @SequenceGenerator(name="KindMedia_seq",sequenceName="KindMedia_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KindMedia_seq")
    @Column(name="KindMedia_Id",unique = true, nullable = false)

    private @NotNull Long id_kind;

    private @NotNull (message="kind_Media must not be null to be valid")
     @NonNull String kind_Media;


    public Long getId_kind() {
        return id_kind;
    }

    public void setId_kind(Long id_kind) {
        this.id_kind = id_kind;
    }

    public String getKind_Media() {
        return kind_Media;
    }

    public void setKind_Media(String kind_Media) {
        this.kind_Media = kind_Media;
    }
}
