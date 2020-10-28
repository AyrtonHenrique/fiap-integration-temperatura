package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.time.LocalDateTime;

public class Evento {
    private LocalDateTime horaPrimeiroEventoAlerta;
    private LocalDateTime horaFimEnvioAlerta;
    private Long idDrone;
    private Boolean persiteTemperaturaUmidadeNivelAlerta;

    public Boolean getPersiteTemperaturaUmidadeNivelAlerta() {
        return persiteTemperaturaUmidadeNivelAlerta;
    }

    public void setPersiteTemperaturaUmidadeNivelAlerta(Boolean persiteTemperaturaUmidadeNivelAlerta) {
        this.persiteTemperaturaUmidadeNivelAlerta = persiteTemperaturaUmidadeNivelAlerta;
    }

    public Long getIdDrone() {
        return idDrone;
    }

    public LocalDateTime getHoraFimEnvioAlerta() {
        return horaFimEnvioAlerta;
    }

    public LocalDateTime getHoraPrimeiroEventoAlerta() {
        return horaPrimeiroEventoAlerta;
    }

    public Evento(LocalDateTime horaPrimeiroEventoAlerta, LocalDateTime horaFimEnvioAlerta, Long idDrone,
            Boolean persiteTemperaturaUmidadeNivelAlerta) {
        this.horaPrimeiroEventoAlerta = horaPrimeiroEventoAlerta;
        this.horaFimEnvioAlerta = horaFimEnvioAlerta;
        this.idDrone = idDrone;
        this.setPersiteTemperaturaUmidadeNivelAlerta(persiteTemperaturaUmidadeNivelAlerta);
    }
}
