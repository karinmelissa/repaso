package com.davidosorno.repaso.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "ninjas",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@Getter @Setter @NoArgsConstructor
public class Ninja extends ModeloBase {
    
    @NotNull
    @NotBlank
    @Size(min = 5, max = 20, message = "Este campo es requerido y debe tener entre 5 y 20 caracteres.")
    String nombre;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 20, message = "Este campo es requerido y debe tener entre 5 y 20 caracteres.")
    String apellido;

    @NotNull
    @Min(15)
    @Max(100)
    int edad;

    @NotNull
    @NotBlank
    @Email(message = "Debe ingresar un email válido")
    @Size(min = 8, max = 40, message = "El email es requerido")
    String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "dojos_megusta", 
        joinColumns = @JoinColumn(name = "ninja_id"), 
        inverseJoinColumns = @JoinColumn(name = "dojo_id")
    )
    private List<Ninja> dojos_likes;

}
