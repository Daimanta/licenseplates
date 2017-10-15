package nl.leonvanderkaap.licenseplates.model.series;

import org.springframework.stereotype.Service;

@Service
public class SeriesService {

    public void update(Series series, SeriesDTO seriesDTO) {
        series.setName(seriesDTO.getName());
        series.setFullRegex(seriesDTO.getFullRegex());
        series.setStrippedRegex(seriesDTO.getStrippedRegex());
    }
}
