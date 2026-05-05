package pe.edu.upc.inkametrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inkametrics.dtos.MetricaPorRegionDTO;
import pe.edu.upc.inkametrics.entities.Metricas;

import java.util.List;

@Repository
public interface IMetricasRepository extends JpaRepository<Metricas, Integer> {

    @Query("SELECT m.transmisiones.titulo_stream, SUM(m.cantidadMetrica) " +
            "FROM Metricas m " +
            "WHERE m.nameMetrica = :nombre " +
            "GROUP BY m.transmisiones.titulo_stream " +
            "ORDER BY SUM(m.cantidadMetrica) DESC")
    List<Object[]> reporteMetricasJPQL(@Param("nombre") String nombre);

    @Query("SELECT new pe.edu.upc.inkametrics.dtos.MetricaPorRegionDTO(r.nombre, m.nameMetrica, AVG(m.cantidadMetrica)) " +
            "FROM Metricas m " +
            "JOIN m.transmisiones t " +
            "JOIN t.canales c " +      // En Transmisiones el atributo se llama 'canales'
            "JOIN c.streamer s " +     // En Canales el atributo se llama 'streamer'
            "JOIN s.regiones r " +      // En Streamers el atributo se llama 'regiones'
            "GROUP BY r.nombre, m.nameMetrica " +
            "ORDER BY AVG(m.cantidadMetrica) DESC")
    List<MetricaPorRegionDTO> findMetricsPerformanceByRegion();
    //    Regiones, Streamers, Plataformas, Canales, Transmisiones, Metricas
}
