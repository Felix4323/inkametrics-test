package pe.edu.upc.inkametrics.dtos;

public class MetricaPorRegionDTO {
    private String nombreRegion;
    private String nombreMetrica;
    private Double valorPromedio;

    public String getNombreRegion() {
        return nombreRegion;
    }

    public String getNombreMetrica() {
        return nombreMetrica;
    }

    public Double getValorPromedio() {
        return valorPromedio;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public void setNombreMetrica(String nombreMetrica) {
        this.nombreMetrica = nombreMetrica;
    }

    public void setValorPromedio(Double valorPromedio) {
        this.valorPromedio = valorPromedio;
    }

    public MetricaPorRegionDTO(String nombreRegion, String nombreMetrica, Double valorPromedio) {
        this.nombreRegion = nombreRegion;
        this.nombreMetrica = nombreMetrica;
        this.valorPromedio = valorPromedio;
    }
}
