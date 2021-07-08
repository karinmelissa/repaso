package com.davidosorno.repaso.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dojos")
@Getter @Setter @NoArgsConstructor
public class Dojo extends ModeloBase {
    
    @NotNull
    @Size(min = 5, max = 20, message = "Este campo es requerido y debe tener entre 5 y 20 caracteres.")
    String nombre;

    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "dojos_megusta", 
        joinColumns = @JoinColumn(name = "dojo_id"), 
        inverseJoinColumns = @JoinColumn(name = "ninja_id")
    )
    private List<Ninja> ninjas_liked;
}
